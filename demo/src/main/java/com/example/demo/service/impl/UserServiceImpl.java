package com.example.demo.service.impl;

import com.example.demo.constant.ERole;
import com.example.demo.domain.User;
import com.example.demo.repository.NewRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    @Override
    public User save(User User) {
        return userRepository.save(User);
    }


}
