package com.vti.DTO.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {
	private int id;
	private String username;
	private String fullName;
	private String role;       // enum tự convert ra string
	private int departmentId;
	private String departmentName;
	
//	cần thông tin gì thì mình định nghĩa nó ra (định nghĩa trường gì thì ra trường đó) 
//	muốn lấy gì thì mình mapping vs entity 
	
//	1 account chỉ có 1 department
}
