package com.example.demo.controller;

import com.example.demo.annotation.RoleAdmin;
import com.example.demo.constant.ERole;
import com.example.demo.request.create.CreateUserRequest;
import com.example.demo.domain.User;
import com.example.demo.response.ResponseObject;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "demo/v1/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;
    private static final String KEY = "admin";

    @RoleAdmin
    @PostMapping()
    public ResponseEntity<ResponseObject> createUserAdmin(@Valid @RequestBody CreateUserRequest createUserRequest)
            throws Exception {
        if (createUserRequest.getKey() == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value()
                            , "Can not creat user without key", null));

        }
        if (!createUserRequest.getKey().equals(KEY)) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value()
                            , "Can not creat user without key", null));
        }
        User newUser = new User();
        newUser.setAvatar(createUserRequest.getAvatar());
        newUser.setName(createUserRequest.getName());
        newUser.setEmail(createUserRequest.getEmail());
        newUser.setPassword(createUserRequest.getPassword());
        newUser.setRole(ERole.ADMIN);
        userService.save(newUser);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                , "Creat User success", newUser));
    }


    @RoleAdmin
    @PostMapping("createUser")
    public ResponseEntity<ResponseObject> creatUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
//        String tokens = jwtService.parseTokenToRole(token);
//        if (tokens.equals(ERole.ADMIN)) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
//                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value()
//                            , "Role error (only admin can create)", null));
//        }

        User newUser = new User();
        newUser.setAvatar(createUserRequest.getAvatar());
        newUser.setName(createUserRequest.getName());
        newUser.setEmail(createUserRequest.getEmail());
        newUser.setPassword(createUserRequest.getPassword());
        newUser.setRole(ERole.USER);
        userService.save(newUser);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                , "Creat User success", newUser));
    }
}

