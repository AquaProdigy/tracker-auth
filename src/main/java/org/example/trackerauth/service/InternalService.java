package org.example.trackerauth.service;

import org.example.trackerauth.dto.UserDto;

import java.util.List;

public interface InternalService {
    List<UserDto> getUsers();
}
