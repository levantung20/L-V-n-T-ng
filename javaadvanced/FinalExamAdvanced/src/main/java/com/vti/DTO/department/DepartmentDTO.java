package com.vti.DTO.department;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO {
	private int id;
	private String name;
	private int totalMember;
	private String Type;
	@JsonFormat(pattern = "MM-dd-yyyy")
	private Date createDate;
	
//	Json Property(variable)
//	private List<AccountDTO> accounts; // convert  1 List AccountDTO thì mình sẽ khai báo kiểu innnerclass
////
//	@Data
//	@NoArgsConstructor
//	static class AccountDTO {
//		private int id;
//		private String departmentName;
//	}

}
