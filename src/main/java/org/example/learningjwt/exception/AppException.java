package org.example.learningjwt.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppException extends Exception {
    private ErrorCode errorCode;
}
