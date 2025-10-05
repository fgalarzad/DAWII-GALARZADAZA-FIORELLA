package com.fiorella.t1cloudfeign.msvc_users.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fiorella.t1cloudfeign.msvc_users.entity.Users;
import com.fiorella.t1cloudfeign.msvc_users.repository.UsersRepository;
import com.fiorella.t1cloudfeign.msvc_users.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private Environment environment;

    @Override
    public List<Users> findAll() {
        return ((List<Users>) usersRepository.findAll()).stream().map(users -> {
            users.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return users;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id).map(users -> {
            users.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return users;
        });
    }

}

