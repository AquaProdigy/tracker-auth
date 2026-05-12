package org.example.trackerauth.controller.impl;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.controller.UserController;
import org.example.trackerauth.dto.response.UserResponse;
import org.example.trackerauth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ResponseEntity<UserResponse> getUser(
            @RequestHeader(name = "X-User-Id") Long userId
            ){
        UserResponse user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }
}
