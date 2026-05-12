package org.example.trackerauth.controller.impl;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.controller.InternalController;
import org.example.trackerauth.dto.response.InternalUserEmailResponse;
import org.example.trackerauth.service.impl.InternalServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/internal/users/email")
@RequiredArgsConstructor
public class InternalControllerImpl implements InternalController {
    private final InternalServiceImpl internalServiceImpl;

    @Override
    public ResponseEntity<List<InternalUserEmailResponse>> getAllUsers(
            @RequestBody List<Long> ids
    ) {
        return ResponseEntity.ok()
                .body(internalServiceImpl.getEmailByIds(ids));
    }
}
