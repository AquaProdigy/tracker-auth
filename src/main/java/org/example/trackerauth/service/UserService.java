package org.example.trackerauth.service;

import org.example.trackerauth.dto.response.UserResponse;

public interface UserService {
    UserResponse findUserById(Long userId);
}
