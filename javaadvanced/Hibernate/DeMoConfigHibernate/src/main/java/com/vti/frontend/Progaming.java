package com.vti.frontend;

import java.util.List;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class Progaming {
			public static void main(String[] args) {
				DepartmentRepository repository = new DepartmentRepository();
					
				List<Department> departments = repository.getAllDepartments();
				
				for (Department department : departments) {
					System.out.println(department);
				}
				
				System.out.println("\n\n--------------------------Create------------------------");
				Department department = new Department();
				department.setDepartmentName("po");
				department.setId((short)10);
				repository.createDepartment(department);
			}
}
