package org.example.learningjwt.enums;

import lombok.Getter;

@Getter
public enum StatusCode {
    OK(200, "Success"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found");

    private int code;
    private String message;
    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
