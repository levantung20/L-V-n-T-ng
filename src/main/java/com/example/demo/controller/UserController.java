package com.example.demo.controller;

import com.example.demo.annotation.RoleAdmin;
import com.example.demo.constant.AccountStatus;
import com.example.demo.constant.ERole;
import com.example.demo.constant.RequestStatus;
import com.example.demo.converter.RequestConverter;
import com.example.demo.domain.Request;
import com.example.demo.request.Request.CreateLeaveRequest;
import com.example.demo.request.Request.CreateSoonLateRequest;
import com.example.demo.request.user.CreateUserRequest;
import com.example.demo.domain.User;
import com.example.demo.request.user.UpdateUserRequest;
import com.example.demo.response.*;
import com.example.demo.service.JwtService;
import com.example.demo.service.RequestService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "demo/v1/users/")
@RequiredArgsConstructor
public class  UserController {
    private final UserService userService;
    private final JwtService jwtService;

    private final RequestService requestService;

    @RoleAdmin
    @PostMapping("admin")
    public ResponseEntity<ResponseObject> createUserAdmin(@Valid @RequestBody CreateUserRequest createUserRequest,
                                                          @Value("${secret-key}") String SECRET_KEY)
            throws Exception {
        String inputCreateAdminKey = createUserRequest.getKey();
        if (inputCreateAdminKey == null || (!inputCreateAdminKey.equals(SECRET_KEY))) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value()
                            , "UNAUTHORIZED FOR CREATE ADMIN", null));

        }
        User newAdmin = new User();
        newAdmin.setAvatar(createUserRequest.getAvatar());
        newAdmin.setName(createUserRequest.getName());
        newAdmin.setEmail(createUserRequest.getEmail());
        newAdmin.setPassword(createUserRequest.getPassword());
        newAdmin.setRole(ERole.ADMIN);
        newAdmin.setAccountStatus(AccountStatus.ACTIVE);
        userService.save(newAdmin);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                , "CREATE ADMIN SUCCESS", newAdmin));
    }

    @RoleAdmin
    @PostMapping("user")
    public ResponseEntity<ResponseObject> creatUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        User newUser = new User();
        newUser.setAvatar(createUserRequest.getAvatar());
        newUser.setName(createUserRequest.getName());
        newUser.setEmail(createUserRequest.getEmail());
        newUser.setPassword(createUserRequest.getPassword());
        newUser.setRole(ERole.USER);
        newUser.setAccountStatus(AccountStatus.ACTIVE);
        userService.save(newUser);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                , "CREATE USER SUCCESS", newUser));
    }

    @PutMapping("{userId}")
    public ResponseEntity<ResponseObject> updateUserInfor(@RequestHeader("Authorization") String token,
                                                     @PathVariable(name = "userId") String userId,
                                                    @RequestBody UpdateUserRequest updateUserRequest) {
        String userId1 = jwtService.parseTokenToUserId(token);
        if (userId1.equals(userId)) {
            User user = userService.updateUser(userId, updateUserRequest);
            UserResponse userResponse = new UserResponse();
            userResponse.setName(user.getName());
            userResponse.setAvatar(user.getAvatar());
            return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                    "UPDATE ADMIN SUCCESS", userResponse));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ResponseObject(HttpStatus.UNAUTHORIZED.value()
                        , "UNAUTHORIZED TO DO THIS TASK", null));
    }

    @RoleAdmin
    @PutMapping("{userId}/status-account")
    public ResponseEntity<ResponseObject> setStatusAccoutUser(
                                                            @PathVariable(name = "userId") String userId,
                                                           @RequestParam(name = "statusUser") String statusUser) {
        User user = userService.setStatusUserAccount(userId, AccountStatus.valueOf(statusUser));
        UserResponse userResponse = new UserResponse(user.getId(), user.getAvatar(),user.getName(),
                user.getEmail(),user.getRole(),user.getAccountStatus(), null);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "CHANGE STATUS USER SUCCESS", userResponse));
    }

    @PostMapping("{id}/latesoon")
    public ResponseEntity<ResponseObject> createLateSoonRequest(@Valid @RequestBody CreateSoonLateRequest createSoonLateRequest,
                                                                @RequestHeader("Authorization") String token,
                                                                @PathVariable("id") String id) {
        RequestResponse response = requestService.insertLateSoonRequest(id, createSoonLateRequest);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "CREATE REQUEST SUCCESS", response));
    }

    @PostMapping("{id}/off")
    public ResponseEntity<ResponseObject> createLeaveRequest(@Valid @RequestBody CreateLeaveRequest createLeaveRequest,
                                                             @RequestHeader("Authorization") String token,
                                                             @PathVariable("id") String id) {
        RequestResponse response = requestService.insertLeaveRequest(id, createLeaveRequest);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "CREATE REQUEST SUCCESS", response));
    }

    @GetMapping("{id}/requests")
    public ResponseEntity<ResponseObject> findAll(@PathVariable("id") String id) {
        List<RequestByUserIdResponse> list = requestService.findListRequestByUserId(id);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "GET LIST REQUEST", list));
    }

    @GetMapping("{id}/requests/toApprove")
    public ResponseEntity<ResponseObject> findAllRequestsNeedToApprove(@RequestHeader("Authorization") String token,
                                                                       @PathVariable("id") String id) {
        List<RequestByUserIdResponse> list = requestService.findListRequestByReceiverEmail(id);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "GET LIST REQUEST", list));
    }

    @PutMapping({"requests/{requestId}/{status}"})
    public ResponseEntity<ResponseObject> approveRequest(@PathVariable(name = "requestId") String requestId,
                                                         @PathVariable(name = "status") RequestStatus status,
                                                         @RequestHeader("Authorization") String token) {
        ListRequestResponse response = requestService.approveRequest(requestId, status, token);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Request status set to " + status, response));
    }

}

