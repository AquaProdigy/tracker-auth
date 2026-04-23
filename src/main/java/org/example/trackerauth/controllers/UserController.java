package org.example.trackerauth.controllers;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.dto.UserDto;
import org.example.trackerauth.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserDto> getUser(
            @RequestHeader(name = "X-User-Id")  String userId
            ){
        UserDto user = userService.findUserById(Long.valueOf(userId));
        return ResponseEntity.ok(user);
    }
}
