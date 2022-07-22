package com.example.demo.request;

import com.example.demo.constant.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String id;
    private String avatar;
    private String name;
    private String email;
    private String password;
    private ERole role;
    private String key;

}
