package org.example.trackerauth.mapper;

import org.example.trackerauth.dto.response.UserResponse;
import org.example.trackerauth.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserDto(User user);
}
