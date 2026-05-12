package org.example.trackerauth.controller;

import org.example.trackerauth.dto.response.InternalUserEmailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface InternalController {
    @GetMapping
    ResponseEntity<List<InternalUserEmailResponse>> getAllUsers(
            @RequestBody List<Long> ids
    );
}
