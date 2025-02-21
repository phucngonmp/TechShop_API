package org.example.learningjwt.controller;

import jakarta.validation.Valid;
import org.example.learningjwt.dto.response.ApiResponse;
import org.example.learningjwt.dto.UserDTO;
import org.example.learningjwt.dto.response.UserResponse;
import org.example.learningjwt.entity.User;
import org.example.learningjwt.mapper.UserMapper;
import org.example.learningjwt.service.CustomUserDetail;
import org.example.learningjwt.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public List<UserResponse> getUsers(){
        return userService.getUsers().stream()
                .map(user -> userMapper.toUserResponse(user))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ApiResponse<>(200, "delete successfully", null);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO request){
        userService.updateUser(id, request);
        return new ApiResponse<>(200, "update successfully", userService.getUser(id));
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id){
        if(isUserPermitted(id)){
            return userMapper.toUserResponse(userService.getUser(id));
        }
        throw new RuntimeException("not permitted");
    }

    private boolean isUserPermitted(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
        if(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))){
            return true;
        }
        return userDetails.getId() == id;
    }
}
