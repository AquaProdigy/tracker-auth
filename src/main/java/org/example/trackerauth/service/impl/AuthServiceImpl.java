package org.example.trackerauth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.api.ApiErrorMessages;
import org.example.trackerauth.config.jwt.JwtTokenService;
import org.example.trackerauth.dto.request.AuthUserRequest;
import org.example.trackerauth.dto.kafka.EmailLetterKafkaDto;
import org.example.trackerauth.entity.User;
import org.example.trackerauth.exception.EmailAlreadyExistsException;
import org.example.trackerauth.exception.InvalidPasswordException;
import org.example.trackerauth.exception.UserNotFoundException;
import org.example.trackerauth.repository.UserRepository;
import org.example.trackerauth.service.AuthService;
import org.example.trackerauth.service.KafkaSenderService;
import org.example.trackerauth.template.NewUserEmailTemplate;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;
    private final UserRepository userRepository;
    private final KafkaSenderService kafkaSenderService;

    @Transactional
    public String register(AuthUserRequest authUserRequest) {
        User user = new User();
        user.setEmail(authUserRequest.getEmail());
        user.setPassword(passwordEncoder.encode(authUserRequest.getPassword()));

        try {
            User savedUser = userRepository.save(user);

            kafkaSenderService.sendMessageToKafka(new EmailLetterKafkaDto(
                    savedUser.getEmail(),
                    NewUserEmailTemplate.TITLE,
                    NewUserEmailTemplate.DESCRIPTION
            ));

            return jwtTokenService.generateToken(savedUser);

        } catch (DataIntegrityViolationException e) {
            throw new EmailAlreadyExistsException(ApiErrorMessages.EMAIL_ALREADY_EXISTS.getMessage());
        }
    }

    public String login(AuthUserRequest authUserRequest) {
        User user = userRepository.findByEmail(authUserRequest.getEmail()).orElseThrow(() ->
                new UserNotFoundException(ApiErrorMessages.USER_NOT_FOUND.getMessage())
        );

        if (!passwordEncoder.matches(authUserRequest.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException(ApiErrorMessages.INVALID_PASSWORD.getMessage());
        }

        return jwtTokenService.generateToken(user);
    }
}
