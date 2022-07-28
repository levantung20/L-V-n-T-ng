package com.example.demo.service.impl;

import com.example.demo.constant.AccountStatus;
import com.example.demo.constant.ERole;
import com.example.demo.domain.News;
import com.example.demo.domain.User;
import com.example.demo.exception.NewsNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.update.UpdateUserRequest;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtService jwtService;
    public final UserRepository userRepository;

    @Override
    public User save(User User) {
        return userRepository.save(User);
    }

    @Override
    public User updateUser(String userId, UpdateUserRequest updateUserRequest) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new NewsNotFoundException("Can't find userId = " + userId);
        }
        User user = userOptional.get();
        user.setName(updateUserRequest.getName());
        user.setAge(updateUserRequest.getAge());
        user.setAvatar(updateUserRequest.getAvatar());
        return userRepository.save(user);
    }

    @Override
    public User inActiveUserAccount(String id) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            throw new NewsNotFoundException("no active");
        }
        user.setAccountStatus(AccountStatus.INACTIVE);
        userRepository.save(user);
        return user;
    }
    @Override
    public User activeUserAccount(String id) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            throw  new NewsNotFoundException("....");
        }
        user.setAccountStatus(AccountStatus.ACTIVE);
        userRepository.save(user);
        return user;
    }


}
