package com.example.demo.service.impl;

import com.example.demo.constant.ERole;
import com.example.demo.domain.User;
import com.example.demo.repository.NewRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    @Override
    public User save(UserRequest userRequest) {
        User newUser = new User();
        newUser.setAvatar(userRequest.getAvatar());
        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(userRequest.getPassword());
        newUser.setRole(ERole.ADMIN);
        userRepository.save(newUser);
        return userRepository.save(newUser);
    }
}
