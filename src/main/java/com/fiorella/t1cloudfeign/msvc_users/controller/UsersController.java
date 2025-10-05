package com.fiorella.t1cloudfeign.msvc_users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiorella.t1cloudfeign.msvc_users.entity.Users;
import com.fiorella.t1cloudfeign.msvc_users.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

     @Autowired
    private UsersService usersService;
    
    @GetMapping
    public ResponseEntity<List<Users>> list() {
        return ResponseEntity.ok(usersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> detail(@PathVariable Long id) {
        Optional<Users> optional = usersService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
