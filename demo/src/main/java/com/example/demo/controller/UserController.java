package com.example.demo.controller;

import com.example.demo.constant.ERole;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.response.ResponseObject;
import com.example.demo.response.UserReponse;
import com.example.demo.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "demo/v1/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private static final String KEY = "admin";

    @PostMapping()
    public ResponseEntity<ResponseObject> createUser(@RequestBody UserRequest userRequest) throws Exception {
        if (userRequest.getKey() != null) {
            if (!Objects.equals(KEY, userRequest.getKey())) {
                throw new Exception("PERMISSION DENIED");
            }
            if (userRequest.getKey().equals(KEY)) {
                User user = new User();
                user.setAvatar(userRequest.getAvatar());
                user.setName(userRequest.getName());
                user.setEmail(userRequest.getEmail());
                user.setPassword(userRequest.getPassword());
                user.setRole(ERole.ADMIN);
                userRepository.save(user);
                return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Creat User success", user));
            }
        }
        User user = new User();
        user.setAvatar(userRequest.getAvatar());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(ERole.USER);
        userRepository.save(user);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Creat User with not key", user));
    }

    @PostMapping("login")
    public ResponseEntity<ResponseObject> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
        if (user.isPresent()) {
            if (user.get().getPassword().equalsIgnoreCase(loginRequest.getPassword())) {
                return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                        , jwtService.generateToken(user.get().getEmail(), user.get().getRole())
                        , new UserReponse(user.get().getName(), user.get().getEmail(), user.get().getRole())));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "Login fail!", null));
    }
}
