package org.example.trackerauth.service;

import org.example.trackerauth.dto.UserDto;

public interface UserService {
    UserDto findUserById(Long userId);
}
