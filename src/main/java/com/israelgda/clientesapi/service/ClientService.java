package com.israelgda.clientesapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.clientesapi.dto.ClientDTO;
import com.israelgda.clientesapi.entity.Client;
import com.israelgda.clientesapi.repository.ClientRepository;
import com.israelgda.clientesapi.service.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	public ClientDTO findById(Long id) {
		Optional<Client> client = repository.findById(id);
		ClientDTO result = new ClientDTO(client.orElseThrow(() -> new ResourceNotFoundException("Entity not found, id: " + id)));
		return result;
	}

	public ClientDTO create(ClientDTO clientDTO) {
		Client client = dtoToEntity(clientDTO);
		client = repository.save(client);
		return new ClientDTO(client);
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
