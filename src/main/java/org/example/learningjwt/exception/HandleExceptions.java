package org.example.learningjwt.exception;

import jakarta.validation.ConstraintViolationException;
import org.example.learningjwt.dto.request.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public ApiResponse handleValidationExceptions(ConstraintViolationException ex) {
        Map<Integer, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String message = violation.getMessage();
            ErrorCode errorCode = ErrorCode.valueOf(message);
            errors.put(errorCode.getCode(), errorCode.getName());
        });
        return new ApiResponse<>(ErrorCode.USER_ERRORS.getCode(), ErrorCode.USER_ERRORS.getName(), errors);
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
        return new ApiResponse<>(ErrorCode.USER_ERRORS.getCode(), ErrorCode.USER_ERRORS.getName(), errors);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ApiResponse handleUserNameNotFound(UsernameNotFoundException e){
        return new ApiResponse(ErrorCode.USERNAME_NOT_FOUND.getCode(), ErrorCode.USERNAME_NOT_FOUND.getName(), null);
    }


}
