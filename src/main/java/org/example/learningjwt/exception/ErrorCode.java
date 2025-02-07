package org.example.learningjwt.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode{
    USER_ERRORS(100, "register error"),
    USER_EXISTS(101, "user existed"),
    USERNAME_INVALID(102, "username must be at least 8 characters"),
    PASSWORD_INVALID_LENGTH(103, "password must be at least 8 characters"),
    PASSWORD_INVALID_RULE(104, "password must contain at least 1 special character and at least 1 number"),
    EMAIL_INVALID(105, "invalid email"),
    USERNAME_NOT_FOUND(101, "username not found");

    private int code;
    private String name;
}

