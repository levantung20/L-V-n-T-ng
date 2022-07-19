package com.example.demo.domain;

import com.example.demo.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
    @Id
    private String id;
    private String avatar;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String key;
}
