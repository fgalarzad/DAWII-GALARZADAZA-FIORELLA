package com.fiorella.t1cloudfeign.msvc_clients.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiorella.t1cloudfeign.msvc_clients.client.UsersFeignClient;
import com.fiorella.t1cloudfeign.msvc_clients.models.Client;
import com.fiorella.t1cloudfeign.msvc_clients.models.Users;
import com.fiorella.t1cloudfeign.msvc_clients.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private UsersFeignClient usersFeignClient;
     @Override
    public List<Client> findAll() {
        return usersFeignClient.list().getBody().stream()
                .map(users -> {
                    String usuario = generarUsuario(users.nombres(), users.apellidos());
                    String contraseña = generarPassword();
                    return new Client(users, usuario, contraseña);
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findById(Long id) {
        Users user = usersFeignClient.detail(id).getBody();
        String usuario = generarUsuario(user.nombres(), user.apellidos());
        String contraseña = generarPassword();
        return Optional.of(new Client(user, usuario, contraseña));
    }

    private String generarUsuario(String nombres, String apellidos) {
    String primerNombre = nombres.split("\\s+")[0];
    String primerApellido = apellidos.split("\\s+")[0];
    return (primerNombre + "." + primerApellido).toLowerCase();
}


    private String generarPassword() {
    return UUID.randomUUID().toString()
               .replace("-", "")
               .substring(0, 8);
}
}


