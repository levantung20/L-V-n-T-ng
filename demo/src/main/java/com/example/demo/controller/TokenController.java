package com.example.demo.controller;

import com.example.demo.constant.ERole;
import com.example.demo.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("demo/v1/tokens")
@RequiredArgsConstructor
public class TokenController {

    @Autowired
    private JwtService jwtService;
}
