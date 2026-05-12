package org.example.trackerauth.service.impl;


import lombok.RequiredArgsConstructor;
import org.example.trackerauth.api.ApiErrorMessages;
import org.example.trackerauth.dto.response.UserResponse;
import org.example.trackerauth.entity.User;
import org.example.trackerauth.exception.UserNotFoundException;
import org.example.trackerauth.mapper.UserMapper;
import org.example.trackerauth.repository.UserRepository;
import org.example.trackerauth.service.UserService;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse findUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(ApiErrorMessages.USER_NOT_FOUND.getMessage()));

        return userMapper.toUserDto(user);
    }
}
