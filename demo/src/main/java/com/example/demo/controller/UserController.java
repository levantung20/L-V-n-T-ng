package com.example.demo.controller;

import com.example.demo.constant.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.response.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "demo/v1/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
        private static final String KEY ="admin";
    @PostMapping("createuser")
    public ResponseEntity<ResponseObject> createUser(@RequestBody UserRequest userRequest) throws Exception{
        if (!Objects.equals(KEY , userRequest.getKey())) {
            throw  new Exception("PERMISSION DENIED");
        }
       if (userRequest.getKey() != null){
           if (userRequest.getKey().equals(KEY) && userRequest.getEmail().contains("@ntq-solution.com")){
               List<User> emailCheck = userRepository.findByEmail(userRequest.getEmail());
               if(emailCheck == null || emailCheck.size() == 0){
                   User user = new User();
                   user.setName(userRequest.getName());
                   user.setAvatar(userRequest.getAvatar());
                   user.setEmail(userRequest.getEmail());
                   user.setRole(Role.ADMIN);
                   user.setPassword(userRequest.getPassword());
                   userRepository.insert(user);
                   return  ResponseEntity.ok(new ResponseObject(HttpStatus.CREATED.value(),"Create user admin success!",user));
               }
               else {
                   return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).
                           body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(),"Create user admin fail! Can not create User with same email",null));
               }
           }
           else {
               return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                       .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(),"Create user admin fail!",null));
           }
       }
       else {
           if(userRequest.getEmail().contains("@ntq-solution.com")){
               List<User> emailCheck = userRepository.findByEmail(userRequest.getEmail());
               if(emailCheck == null || emailCheck.size() == 0){
                   User user = new User();
                   user.setName(userRequest.getName());
                   user.setAvatar(userRequest.getAvatar());
                   user.setEmail(userRequest.getEmail());
                   user.setRole(Role.USER);
                   user.setPassword(userRequest.getPassword());
                   userRepository.insert(user);
                   return ResponseEntity.ok(new ResponseObject(HttpStatus.CREATED.value(), "Create user success!", user));
               }
               else {
                   return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).
                           body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(),"Create user fail! Can not create User with same email",null));
               }
           }
       }
       return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
               .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(),"Create user fail!",null));
    }
    
    @PostMapping("login")
    public ResponseEntity<ResponseObject> login(@RequestBody LoginRequest loginRequest){
        List<User> userCheck = userRepository.findByEmail(loginRequest.getEmail());
        if (userCheck.size() > 0){
            if (userCheck.get(0).getPassword().equalsIgnoreCase(loginRequest.getPassword())){
                return  ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                        "Login success!",
                        userCheck));
            }
        }
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ResponseObject(HttpStatus.UNAUTHORIZED.value(),
                        "Login fail!",
                        null));
    }
}
