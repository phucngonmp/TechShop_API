package org.example.learningjwt.dto.response;

import lombok.Data;
import org.example.learningjwt.enums.Role;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Role role;
}
