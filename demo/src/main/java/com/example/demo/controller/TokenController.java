package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.login.LoginRequest;
import com.example.demo.response.ResponseObject;
import com.example.demo.response.UserReponse;
import com.example.demo.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController()
@RequestMapping("demo/v1/tokens/")
@RequiredArgsConstructor
public class TokenController {

    @Autowired
    private JwtService jwtService;
    private final UserRepository userRepository;

    @PostMapping("login")
    public ResponseEntity<ResponseObject> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "user does not exist in db", null));
        }
        if (!user.get().getPassword().equalsIgnoreCase(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "wrong password format", null));
        }
        String token = jwtService.generateToken(user.get().getId(), user.get().getEmail(), user.get().getRole());
        UserReponse userReponse = new UserReponse(user.get().getName(), user.get().getEmail(), user.get().getRole());
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), token, userReponse));
    }
}
