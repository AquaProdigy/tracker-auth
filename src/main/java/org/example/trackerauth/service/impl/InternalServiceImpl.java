package org.example.trackerauth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.dto.response.InternalUserEmailResponse;
import org.example.trackerauth.repository.UserRepository;
import org.example.trackerauth.service.InternalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternalServiceImpl implements InternalService {
    private final UserRepository userRepository;

    @Override
    public List<InternalUserEmailResponse> getEmailByIds(List<Long> ids) {
        return userRepository.findAllById(ids)
                .stream()
                .map(u -> new InternalUserEmailResponse(u.getId(), u.getEmail()))
                .toList();
    }
}
