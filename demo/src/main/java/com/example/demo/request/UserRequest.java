package com.example.demo.request;

import com.example.demo.constant.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String id;
    private String avatar;
    private String name;
    @Email(regexp = ".+@ntq-solution.com.vn",message = "Email must end with @ntq-solution.com.vn")
    private String email;
    @Size(min = 8, max = 20,message = " ")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",message = "Password not valid")
    private String password;
    private ERole role;
    private String key;
}
