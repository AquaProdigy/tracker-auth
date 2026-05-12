package org.example.trackerauth.controller;

import jakarta.validation.Valid;
import org.example.trackerauth.dto.request.AuthUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {
    @PostMapping("/register")
    ResponseEntity<Void> register(@Valid @RequestBody AuthUserRequest user);

    @PostMapping("/login")
    ResponseEntity<Void> login(@Valid @RequestBody AuthUserRequest user);
}
