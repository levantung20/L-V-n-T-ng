package com.vti;

import java.util.List;

import com.vti.entity.RegularEmployee;
import com.vti.repository.EmployeeRepository;

public class Program {
	public static void main(String[] args) {
		EmployeeRepository employeeRepository = new EmployeeRepository();

		System.out.println("***********GET ALL REGULAR EMPLOYEES***********");

		List<RegularEmployee> regularEmployees = employeeRepository.getAllRegularEmployees();

		for (RegularEmployee regularEmployee : regularEmployees) {
			System.out.println(regularEmployee);
		}

		System.out.println("\n\n***********CREATE REGULAR EMPLOYEE***********");

		RegularEmployee regularEmployee = new RegularEmployee();
		regularEmployee.setName("Nguyen Van A");
		regularEmployee.setSalary(3000);
		regularEmployee.setBonus(300);
		employeeRepository.createRegularEmployee(regularEmployee);
	}
}
