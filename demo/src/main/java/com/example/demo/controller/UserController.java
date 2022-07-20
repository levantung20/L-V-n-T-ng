package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.request.UserRequest;
import com.example.demo.response.ResponseObject;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "demo/v1/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;
    private static final String KEY = "admin";

    @PostMapping()
    public ResponseEntity<ResponseObject> createUser(@RequestBody UserRequest userRequest) throws Exception {
        if (userRequest.getKey() != null) {
            if (!Objects.equals(KEY, userRequest.getKey())) {
                throw new Exception("PERMISSION DENIED");
            }
            if (userRequest.getKey().equals(KEY)) {
                User newUser = userService.save(userRequest);
                return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Creat User success", newUser));
            }
        }
        User newUser = userService.save(userRequest);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Creat User with not key", newUser));
    }
}