package org.example.learningjwt.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode{
    REGISTER_ERROR(1000, "register error"),
    USER_EXISTS(1001, "user existed"),
    USERNAME_INVALID(1002, "username must be at least 8 characters"),
    PASSWORD_INVALID_LENGTH(1003, "password must be at least 8 characters"),
    PASSWORD_INVALID_RULE(1004, "password must contain at least 1 special character and at least 1 number"),
    EMAIL_INVALID(1005, "invalid email"),
    EMAIL_EXISTS(1006, "email existed"),
    USERNAME_NOT_FOUND(1007, "username not found"),
    VERIFICATION_TOKEN_INVALID(1007, "invalid verification token"),
    LOGIN_ERROR(3000, "username and password are incorrect"),
    SEND_EMAIL_ERROR(5000, "send email error"),
    USER_DISABLED(6000, "user is disabled or banned");

    private int code;
    private String name;

    public static ErrorCode fromName(String name) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.name.equalsIgnoreCase(name)) {
                return errorCode;
            }
        }
        throw new IllegalArgumentException("No matching ErrorCode for name: " + name);
    }
}

