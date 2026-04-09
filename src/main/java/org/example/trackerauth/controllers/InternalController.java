package org.example.trackerauth.controllers;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.dto.UserDto;
import org.example.trackerauth.entities.User;
import org.example.trackerauth.mapper.UserMapper;
import org.example.trackerauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/internal/users")
@RequiredArgsConstructor
public class InternalController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Value("${internal.api-key}")
    private String internalApiKey;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().header("X-Internal-Api-Key", internalApiKey)
                .body(
                        userRepository.findAll()
                        .stream()
                        .map(userMapper::toUserDto)
                        .toList()
                );
    }
}
