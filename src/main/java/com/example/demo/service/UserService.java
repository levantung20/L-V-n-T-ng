package com.example.demo.service;

import com.example.demo.constant.AccountStatus;
import com.example.demo.domain.User;
import com.example.demo.request.update.UpdateUserRequest;


public interface UserService {
    User save(User user);

    User updateUser(String userId, UpdateUserRequest updateUserRequest);

    User setStatusUserAccount(String id, AccountStatus accountStatus);
}
