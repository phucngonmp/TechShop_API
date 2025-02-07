package org.example.learningjwt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.learningjwt.enums.Role;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 8, message = "USERNAME_INVALID")
    private String username;
    @Size(min = 8, message = "PASSWORD_INVALID_LENGTH")
    @Pattern(
            regexp = "^(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*\\d).+$",
            message = "PASSWORD_INVALID_RULE")
    private String password;
    @Email(message = "EMAIL_INVALID")
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private Role role;
}
