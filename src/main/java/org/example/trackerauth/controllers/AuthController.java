package org.example.trackerauth.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.trackerauth.dto.AuthUserRequest;
import org.example.trackerauth.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final static String AUTH_HEADER = "Authorization";
    private final static String BEARER_START_TOKEN = "Bearer ";

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody AuthUserRequest user) {
        String token = authService.register(user);

        return ResponseEntity.ok()
                .header(AUTH_HEADER, BEARER_START_TOKEN + token)
                .build();
    }


    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody AuthUserRequest user) {
        String token = authService.login(user);

        return ResponseEntity.ok()
                .header(AUTH_HEADER, BEARER_START_TOKEN + token)
                .build();
    }
}
