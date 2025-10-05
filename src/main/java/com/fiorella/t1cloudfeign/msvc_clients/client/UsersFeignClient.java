package com.fiorella.t1cloudfeign.msvc_clients.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fiorella.t1cloudfeign.msvc_clients.models.Users;

@FeignClient(name = "msvc-users")
public interface UsersFeignClient {

    @GetMapping("/api/users")
    public ResponseEntity<List<Users>> list();

    @GetMapping("/api/users/{id}")
    public ResponseEntity<Users> detail(@PathVariable Long id);

}
