package com.vti.form.department;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingDepartmentForm {
		private String name;
		
		private Department.Type type;
		
		private List<Integer> accountIds;

		
}


//@Data
//@NoArgsConstructor
//public static class Account{
//	private int id;
//}
