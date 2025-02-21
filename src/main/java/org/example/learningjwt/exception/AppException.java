package org.example.learningjwt.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.learningjwt.enums.ErrorCode;

@Getter
@Setter
@AllArgsConstructor
public class AppException extends Exception {
    private ErrorCode errorCode;
}
