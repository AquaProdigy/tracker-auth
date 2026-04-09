package org.example.trackerauth.mapper;

import org.example.trackerauth.dto.UserDto;
import org.example.trackerauth.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
}
