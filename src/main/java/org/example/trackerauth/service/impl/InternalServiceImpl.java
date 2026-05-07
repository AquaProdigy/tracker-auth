package org.example.trackerauth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.dto.UserDto;
import org.example.trackerauth.mapper.UserMapper;
import org.example.trackerauth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternalServiceImpl {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }
}
