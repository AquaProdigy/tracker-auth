package org.example.trackerauth.controller;

import org.example.trackerauth.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

public interface UserController {
    @GetMapping
    ResponseEntity<UserDto> getUser(
            @RequestHeader(name = "X-User-Id") Long userId
    );
}
