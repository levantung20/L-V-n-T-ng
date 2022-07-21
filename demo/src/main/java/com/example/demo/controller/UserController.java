package com.example.demo.controller;

import com.example.demo.constant.ERole;
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

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping(value = "demo/v1/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;
    private static final String KEY = "admin";

    @PostMapping()
    public ResponseEntity<ResponseObject> createUser(@Valid @RequestBody UserRequest userRequest)
            throws Exception {
        if (userRequest.getKey() == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value()
                            , "Can not creat user without key", null));

        }
        if (!userRequest.getKey().equals(KEY)) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value()
                            , "Can not creat user without key", null));
        }
        User newUser = new User();
        newUser.setAvatar(userRequest.getAvatar());
        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(userRequest.getPassword());
        newUser.setRole(ERole.ADMIN);
        userService.save(newUser);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                , "Creat User success", newUser));
    }
    }

