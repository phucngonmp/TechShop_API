package org.example.learningjwt.controller;

import org.example.learningjwt.dto.request.ApiResponse;
import org.example.learningjwt.dto.request.LoginRequest;
import org.example.learningjwt.exception.AppException;
import org.example.learningjwt.exception.ErrorCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping()
    public ApiResponse login(@RequestBody LoginRequest loginRequest) {
        try{
            System.out.println(loginRequest.getPassword() + loginRequest.getUsername());
            Authentication authenticationRequest =
                    UsernamePasswordAuthenticationToken.unauthenticated(
                            loginRequest.getUsername(), loginRequest.getPassword());
            Authentication authenticationResponse =
                    this.authenticationManager.authenticate(authenticationRequest);
            return new ApiResponse<>(200, "login successfully", authenticationResponse);
        } catch (Exception e){
            return new ApiResponse(400, "incorrect username and password", null);
        }
    }
}
