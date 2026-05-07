package org.example.trackerauth.controller;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.dto.UserDto;
import org.example.trackerauth.service.impl.InternalServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/internal/users")
@RequiredArgsConstructor
public class InternalController {
    private final InternalServiceImpl internalServiceImpl;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok()
                .body(internalServiceImpl.getUsers());
    }
}
