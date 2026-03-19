package org.example.trackerauth.services;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.trackerauth.dto.AuthUserRequest;
import org.example.trackerauth.entities.User;
import org.example.trackerauth.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;
    private final UserRepository userRepository;

    @Transactional
    public String register(AuthUserRequest authUserRequest) {
        User user = new User();
        user.setEmail(authUserRequest.getEmail());
        user.setPassword(passwordEncoder.encode(authUserRequest.getPassword()));

        User savedUser = userRepository.save(user);

        return jwtTokenService.generateToken(savedUser);
    }
}
