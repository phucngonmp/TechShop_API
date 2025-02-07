package org.example.learningjwt.controller;

import jakarta.validation.Valid;
import org.example.learningjwt.dto.request.ApiResponse;
import org.example.learningjwt.dto.request.UserDTO;
import org.example.learningjwt.dto.response.UserResponse;
import org.example.learningjwt.entity.User;
import org.example.learningjwt.exception.AppException;
import org.example.learningjwt.mapper.UserMapper;
import org.example.learningjwt.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @GetMapping()
    private List<UserResponse> getUsers(){
        return userService.getUsers().stream()
                .map(user -> userMapper.toUserResponse(user))
                .collect(Collectors.toList());
    }

    @PostMapping()
    private ApiResponse<UserResponse> createUser(@Valid @RequestBody UserDTO request) throws AppException {
        User user = userService.createUser(request);
        return new ApiResponse<>(200, "register successfully", userMapper.toUserResponse(user));
    }

    @DeleteMapping("/{id}")
    private ApiResponse deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ApiResponse<>(200, "delete successfully", null);
    }

    @PutMapping("/{id}")
    private ApiResponse<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO request){
        userService.updateUser(id, request);
        return new ApiResponse<>(200, "update successfully", userService.getUser(id));
    }

    @PostMapping("/{id}")
    private UserResponse getUser(@PathVariable Long id){
        return userMapper.toUserResponse(userService.getUser(id));
    }

}
