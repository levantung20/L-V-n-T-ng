package com.example.demo.response;

import com.example.demo.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private int code;
    private String message;
    private Object data;
}
