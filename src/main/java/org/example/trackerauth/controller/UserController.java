package org.example.trackerauth.controller;

import org.example.trackerauth.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

public interface UserController {
    @GetMapping
    ResponseEntity<UserResponse> getUser(
            @RequestHeader(name = "X-User-Id") Long userId
    );
}
