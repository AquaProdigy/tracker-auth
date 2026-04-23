package org.example.trackerauth.services;


import lombok.RequiredArgsConstructor;
import org.example.trackerauth.api.ApiErrorMessages;
import org.example.trackerauth.dto.UserDto;
import org.example.trackerauth.entities.User;
import org.example.trackerauth.exceptions.UserNotFoundException;
import org.example.trackerauth.mapper.UserMapper;
import org.example.trackerauth.repositories.UserRepository;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(ApiErrorMessages.USER_NOT_FOUND.getMessage()));

        return userMapper.toUserDto(user);
    }
}
