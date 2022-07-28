package com.example.demo.controller;

import com.example.demo.constant.ERole;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.login.LoginRequest;
import com.example.demo.response.AccountResponse;
import com.example.demo.response.LoginResponse;
import com.example.demo.response.ResponseObject;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController()
@RequestMapping("demo/v1/tokens/")
@RequiredArgsConstructor
public class TokenController {

    @Autowired
    private JwtService jwtService;
    private final UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity<ResponseObject> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findByEmail(loginRequest.getEmail());
        if (!userOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "user does not exist in db", null));
        }
        User user = userOpt.get();

        if (!user.getPassword().equalsIgnoreCase(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "wrong password format", null));
        }

        String token = jwtService.generateToken(user.getId(), user.getEmail(), user.getRole());
        LoginResponse loginResponse = new LoginResponse(user.getId(), user.getName(), user.getEmail(), user.getRole(), token);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Login success", loginResponse));
    }

    @PutMapping("inActiveUser/{id}")
    public  ResponseEntity<ResponseObject> inActiveUserAccount(@PathVariable(name = "id") String id, @RequestHeader("Authorization") String token){
        String userFixRole = jwtService.parseTokenToRole(token);
        if(!userFixRole.equals(ERole.ADMIN.toString())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseObject(HttpStatus.UNAUTHORIZED.value(),"Deactive Account",null));
        }
        User user = userService.inActiveUserAccount(id);
        AccountResponse accountResponse = new AccountResponse(user.getId(),user.getAvatar(),user.getName(),user.getEmail(),user.getRole(),user.getAccountStatus(),null);
        return  ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),"Get User By Id Success",accountResponse));
    }
    @PutMapping("activeUser/{id}")
    public ResponseEntity<ResponseObject> activeUserAccount(@PathVariable(name = "id") String id, @RequestHeader("Authorization") String token){
        String userFixRole = jwtService.parseTokenToRole(token);
        if(!userFixRole.equals(ERole.ADMIN.toString())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseObject(HttpStatus.UNAUTHORIZED.value(),"active user account succeccfuly!!!",null));
        }
        User user = userService.activeUserAccount(id);
        AccountResponse accountResponse = new AccountResponse(user.getId(),user.getAvatar(),user.getName(),user.getEmail(),user.getRole(),user.getAccountStatus(),null);
        return  ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),"Get User By Id Success",accountResponse));
    }
}
