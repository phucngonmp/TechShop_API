package org.example.learningjwt.service;

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

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(UserDTO userDTO) throws AppException {
        if(userRepository.existsByUsername(userDTO.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTS);
        }
        User user = userMapper.toUser(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
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
                .orElseThrow(() ->new RuntimeException(ErrorCode.USER_EXISTS.getName()));
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}

