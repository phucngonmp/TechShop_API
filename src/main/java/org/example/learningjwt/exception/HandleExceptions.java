package org.example.learningjwt.exception;

import jakarta.validation.ConstraintViolationException;
import org.example.learningjwt.dto.response.ApiResponse;
import org.example.learningjwt.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSendException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class HandleExceptions {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResponse<Map<Integer, String>> handleValidationExceptions(ConstraintViolationException ex) {
        Map<Integer, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String message = violation.getMessage();
            ErrorCode errorCode = ErrorCode.valueOf(message);
            errors.put(errorCode.getCode(), errorCode.getName());
        });
        return new ApiResponse<>(ErrorCode.REGISTER_ERROR.getCode(), ErrorCode.REGISTER_ERROR.getName(), errors);
    }

    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleAppException(AppException e){
        return new ApiResponse<>(e.getErrorCode().getCode(), e.getErrorCode().getName(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Map<Integer, String>> handleUserDTOExceptions(MethodArgumentNotValidException e){
        Map<Integer, String> errors = new HashMap<>();
        for(FieldError fieldError : e.getFieldErrors()){
            ErrorCode errorCode = ErrorCode.valueOf(fieldError.getDefaultMessage());
            errors.put(errorCode.getCode(), errorCode.getName());
        }
        return new ApiResponse<>(ErrorCode.REGISTER_ERROR.getCode(), ErrorCode.REGISTER_ERROR.getName(), errors);
    }

    @ExceptionHandler(MailSendException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleMailSendException(){
        return new ApiResponse<>(ErrorCode.SEND_EMAIL_ERROR.getCode(), ErrorCode.SEND_EMAIL_ERROR.getName(), null);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleBadCredentials(){
        return new ApiResponse<>(ErrorCode.LOGIN_ERROR.getCode(), ErrorCode.LOGIN_ERROR.getName(), null);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleRuntimeException(RuntimeException e){
        e.printStackTrace();
        return new ApiResponse<>(400, e.getMessage(), null);
    }
}
