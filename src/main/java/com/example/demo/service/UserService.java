package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.request.update.UpdateUserRequest;


public interface UserService {
    User save(User user);

    User updateUser(String userId, UpdateUserRequest updateUserRequest);

    User inActiveUserAccount(String id);

    User activeUserAccount(String id);
}
