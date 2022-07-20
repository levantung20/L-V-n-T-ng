package com.example.demo.response;

import com.example.demo.constant.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReponse {
    private String name;
    private String email;
    private ERole erole;


}
