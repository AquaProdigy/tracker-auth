package org.example.trackerauth.service.impl;

import org.example.trackerauth.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

public interface InternalService {
    ResponseEntity<UserDto> getUser(@RequestHeader(name = "X-User-Id") Long userId);
}
