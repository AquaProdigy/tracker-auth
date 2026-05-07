package org.example.trackerauth.service;

import org.example.trackerauth.dto.request.AuthUserRequest;

public interface AuthService {
    String register(AuthUserRequest authUserRequest);
    String login(AuthUserRequest authUserRequest);
}
