package com.example.demo.request;

import com.example.demo.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {


    private String id;
    private String avatar;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String key;
}
