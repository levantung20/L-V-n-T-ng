package com.vti.frontend;

import java.util.List;

import com.vti.entity.Salary;
import com.vti.entity.enumrate.SalaryName;
import com.vti.repository.SalaryRepository;

public class SalaryTest {
				@SuppressWarnings("unused")
				public static void main(String[] args) {
					SalaryRepository saRepository = new SalaryRepository();
					
					List<Salary> salaries = saRepository.getAllList();
					
					for (Salary salary : salaries) {
						System.out.println(salaries);
						}
					
					System.out.println("\n\n===================================");
					Salary salary = new Salary();
			
					 salary.setName(SalaryName.PM);
					saRepository.createSalary(salary);
				}
				
}
