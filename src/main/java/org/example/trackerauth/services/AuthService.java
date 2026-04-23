package org.example.trackerauth.services;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.trackerauth.api.ApiErrorMessages;
import org.example.trackerauth.dto.AuthUserRequest;
import org.example.trackerauth.dto.EmailLetterModel;
import org.example.trackerauth.entities.User;
import org.example.trackerauth.exceptions.EmailAlreadyExistsException;
import org.example.trackerauth.exceptions.InvalidPasswordException;
import org.example.trackerauth.repositories.UserRepository;
import org.example.trackerauth.templates.NewUserEmailTemplate;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
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

            kafkaSenderService.sendMessageToKafka(new EmailLetterModel(
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
                new UsernameNotFoundException(ApiErrorMessages.USER_NOT_FOUND.getMessage())
        );

        if (!passwordEncoder.matches(authUserRequest.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException(ApiErrorMessages.INVALID_PASSWORD.getMessage());
        }

        return jwtTokenService.generateToken(user);
    }
}
