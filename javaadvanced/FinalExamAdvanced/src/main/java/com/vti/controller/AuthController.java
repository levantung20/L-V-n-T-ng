package com.vti.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.LoginInfoDTO;
import com.vti.entity.Account;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IAccountService service;
	
	@GetMapping("/login")
	public LoginInfoDTO login(Principal pricipal) {
		String username = pricipal.getName();   //get username khi da login thanh cong 
		Account entity = service.getAccountByUsername(username);
		
		
		// convert entity ===> DTO(trả ra thông tin khi đã login thành công)
		LoginInfoDTO dto = modelMapper.map(entity, LoginInfoDTO.class);
		
		return dto;
	}
}
