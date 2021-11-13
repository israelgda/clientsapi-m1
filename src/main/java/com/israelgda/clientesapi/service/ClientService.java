package com.israelgda.clientesapi.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.israelgda.clientesapi.dto.ClientDTO;
import com.israelgda.clientesapi.entity.Client;
import com.israelgda.clientesapi.repository.ClientRepository;
import com.israelgda.clientesapi.service.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> client = repository.findById(id);
		ClientDTO result = new ClientDTO(
				client.orElseThrow(() -> new ResourceNotFoundException("Entity not found, id: " + id)));
		return result;
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(PageRequest pageable) {
		Page<Client> list = repository.findAll(pageable);
		return list.map(result -> new ClientDTO(result));
	}

	@Transactional
	public ClientDTO create(ClientDTO clientDTO) {
		Client client = dtoToEntity(clientDTO);
		client = repository.save(client);
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO clientDTO) {
		try {
			Client newClient = repository.getOne(id);
			repository.save(updateClient(newClient, clientDTO));

			return new ClientDTO(newClient);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity not found, id: " + id);
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Entity not found, id: " + id);
		}

	}

	private Client updateClient(Client newClient, ClientDTO clientDTO) {
		newClient.setName(clientDTO.getName());
		newClient.setCpf(clientDTO.getCpf());
		newClient.setIncome(clientDTO.getIncome());
		newClient.setBirthDate(clientDTO.getBirthDate());
		newClient.setChildren(clientDTO.getChildren());
		return newClient;
	}

	private Client dtoToEntity(ClientDTO clientDTO) {
		Client client = new Client();
		client.setName(clientDTO.getName());
		client.setCpf(clientDTO.getCpf());
		client.setIncome(clientDTO.getIncome());
		client.setBirthDate(clientDTO.getBirthDate());
		client.setChildren(clientDTO.getChildren());
		return client;
	}

}
