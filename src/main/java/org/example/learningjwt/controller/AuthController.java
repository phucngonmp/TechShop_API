package org.example.learningjwt.controller;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.example.learningjwt.dto.ApiResponse;
import org.example.learningjwt.dto.request.LoginRequest;
import org.example.learningjwt.dto.request.UserDTO;
import org.example.learningjwt.exception.AppException;
import org.example.learningjwt.exception.ErrorCode;
import org.example.learningjwt.service.JwtService;
import org.example.learningjwt.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService,
                          UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginRequest loginRequest) {
        if(!userService.isUserEnabled(loginRequest.getUsername())){
            throw new RuntimeException(ErrorCode.USER_DISABLED.getName());
        }
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(
                        loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authenticationResponse =
                this.authenticationManager.authenticate(authenticationRequest);
        String token = jwtService.generateToken((UserDetails) authenticationResponse.getPrincipal());

        return new ApiResponse<>(200, "login successfully", token);
    }

    @PostMapping("/register")
    public ApiResponse register(@Valid @RequestBody UserDTO userDTO){
        String message = userService.createUser(userDTO);
        return new ApiResponse<>(200, message, null);

    }
    @GetMapping("/verify")
    public String verify(@RequestParam String token) {
        userService.verifyUser(token);
        return "<html>" +
                "<head>" +
                "<meta http-equiv='refresh' content='5;url=/'>" +
                "<script>setTimeout(() => window.close(), 5000);</script>" +
                "</head>" +
                "<body>" +
                "<h2 style='text-align:center; color:green;'>Verification Successful!</h2>" +
                "<p style='text-align:center;'>This window will close in 5 seconds...</p>" +
                "</body>" +
                "</html>";
    }
}
