package org.example.learningjwt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @Size(min = 8, message = "USERNAME_INVALID")
    private String username;
    @Size(min = 8, message = "PASSWORD_INVALID_LENGTH")
    @Pattern(
            regexp = "^(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*\\d).+$",
            message = "PASSWORD_INVALID_RULE")
    private String password;
    @Email(message = "EMAIL_INVALID")
    private String email;
}
