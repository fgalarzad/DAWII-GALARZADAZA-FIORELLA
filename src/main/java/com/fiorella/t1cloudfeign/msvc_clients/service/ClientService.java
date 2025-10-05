package com.fiorella.t1cloudfeign.msvc_clients.service;

import java.util.List;
import java.util.Optional;

import com.fiorella.t1cloudfeign.msvc_clients.models.Client;


public interface ClientService {

    List<Client> findAll();

    Optional<Client> findById(Long id);
}
