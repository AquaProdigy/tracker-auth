package org.example.trackerauth.controller;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.dto.UserDto;
import org.example.trackerauth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserDto> getUser(
            @RequestHeader(name = "X-User-Id") Long userId
            ){
        UserDto user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }
}
