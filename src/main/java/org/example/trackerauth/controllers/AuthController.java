package org.example.trackerauth.controllers;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.dto.AuthUserRequest;
import org.example.trackerauth.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Validated @RequestBody AuthUserRequest user) {
        String token = authService.register(user);

        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .build();
    }


    @PostMapping("/login")
    public ResponseEntity<Void> login(@Validated @RequestBody AuthUserRequest user) {
        String token = authService.register(user);

        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .build();
    }
}
