package org.example.trackerauth.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.trackerauth.controller.AuthController;
import org.example.trackerauth.dto.request.AuthUserRequest;
import org.example.trackerauth.service.impl.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final static String AUTH_HEADER = "Authorization";
    private final static String BEARER_START_TOKEN = "Bearer ";

    private final AuthServiceImpl authServiceImpl;

    @Override
    public ResponseEntity<Void> register(@Valid @RequestBody AuthUserRequest user) {
        String token = authServiceImpl.register(user);

        return ResponseEntity.ok()
                .header(AUTH_HEADER, BEARER_START_TOKEN + token)
                .build();
    }


    @Override
    public ResponseEntity<Void> login(@Valid @RequestBody AuthUserRequest user) {
        String token = authServiceImpl.login(user);

        return ResponseEntity.ok()
                .header(AUTH_HEADER, BEARER_START_TOKEN + token)
                .build();
    }
}
