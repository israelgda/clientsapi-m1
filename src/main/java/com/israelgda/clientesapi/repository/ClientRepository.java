package com.israelgda.clientesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.israelgda.clientesapi.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
