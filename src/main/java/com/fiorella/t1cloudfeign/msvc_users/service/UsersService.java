package com.fiorella.t1cloudfeign.msvc_users.service;

import java.util.List;
import java.util.Optional;

import com.fiorella.t1cloudfeign.msvc_users.entity.Users;

public interface UsersService {

    
    List<Users> findAll();

    Optional<Users> findById(Long id);

}
