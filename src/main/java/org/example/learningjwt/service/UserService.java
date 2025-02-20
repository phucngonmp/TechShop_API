package org.example.learningjwt.service;

import jakarta.mail.MessagingException;
import org.example.learningjwt.dto.request.UserDTO;
import org.example.learningjwt.entity.User;
import org.example.learningjwt.exception.AppException;
import org.example.learningjwt.exception.ErrorCode;
import org.example.learningjwt.mapper.UserMapper;
import org.example.learningjwt.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, UserMapper userMapper,
                       PasswordEncoder passwordEncoder, EmailService emailService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public String createUser(UserDTO userDTO) {
        if(userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        if(userRepository.existsByUsername(userDTO.getUsername())){
            throw new RuntimeException("Username already exists");
        }
        User user = userMapper.toUser(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        String token = UUID.randomUUID().toString();
        user.setVerificationToken(token);
        emailService.sendVerificationEmail(user.getEmail(), token);
        userRepository.save(user);
        return "Registration successful! Please check your email for verification.";
    }
    public User verifyUser(String token){
        Optional<User> optionalUser = userRepository.findByVerificationToken(token);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException(ErrorCode.VERIFICATION_TOKEN_INVALID.getName());
        }

        User user = optionalUser.get();
        user.setEnabled(true);
        user.setVerificationToken(null);
        userRepository.save(user);

        return user;
    }
    public User updateUser(long id, UserDTO userDTO){
        User user = getUser(id);
        userMapper.updateUser(user, userDTO);
        return userRepository.save(user);
    }

    public void deleteUser(long id){
        User user = getUser(id);
        userRepository.delete(user);
    }

    public User getUser(long id){
        return userRepository.findById(id)
                .orElseThrow(() ->new RuntimeException(ErrorCode.USERNAME_NOT_FOUND.getName()));
    }
    public User getUser(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() ->new RuntimeException(ErrorCode.USERNAME_NOT_FOUND.getName()));
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public boolean isUserEnabled(Long id){
        return getUser(id).isEnabled();
    }
    public boolean isUserEnabled(String username){
        return getUser(username).isEnabled();
    }

}

