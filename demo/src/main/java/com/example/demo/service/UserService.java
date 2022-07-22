package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.request.UserRequest;
import org.springframework.stereotype.Service;


public interface UserService {
    User save(User user);

    Boolean isValidPassword(String password);
    Boolean checkEmail(String email);


}
