package org.example.learningjwt.mapper;

import org.example.learningjwt.dto.request.UserDTO;
import org.example.learningjwt.dto.response.UserResponse;
import org.example.learningjwt.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "username", target = "username")
    @Mapping(source = "role", target = "role")
    User toUser(UserDTO userDTO);

    void updateUser(@MappingTarget User user, UserDTO userDTO);

    @Mapping(source = "role", target = "role")
    UserResponse toUserResponse(User user);
}
