package com.vti.DTO;

import com.vti.entity.Account;

import lombok.Data;

@Data
public class LoginInfoDTO {
	private int id;

	private String username;

	private String fullName;

	private String firstName;

	private String lastName;

	private Account.Role role;
}
