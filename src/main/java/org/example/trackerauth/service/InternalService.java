package org.example.trackerauth.service;

import org.example.trackerauth.dto.response.InternalUserEmailResponse;

import java.util.List;

public interface InternalService {
    List<InternalUserEmailResponse> getEmailByIds(List<Long> ids);
}
