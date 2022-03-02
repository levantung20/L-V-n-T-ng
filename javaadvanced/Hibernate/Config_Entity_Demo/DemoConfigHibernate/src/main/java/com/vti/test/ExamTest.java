package com.vti.test;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Exam;
import com.vti.repository.AccountRepository;
import com.vti.repository.ExamRepository;

public class ExamTest {
	public static void main(String[] args) {
		ExamRepository repository = new ExamRepository();
		AccountRepository accountRepository = new AccountRepository();	
		System.out.println("***********GET ALL EXAMS***********");

		List<Exam> Exams = repository.getAllExams();

		for (Exam Exam : Exams) {
			System.out.println(Exam);
		}

		System.out.println("\n\n***********CREATE EXAMS***********");
		Account account1 = accountRepository.getAccountByID((short)6);
		Exam examCreate = new Exam();
		examCreate.setTitle("network");
		examCreate.setDuration((short) 100);
		examCreate.setCategoryid((short)8);
		examCreate.setExam(account1);

//		repository.createExam(examCreate);
//			System.out.println("\n\n***********GET EXAMS***********");
//		Exam accountbyName = repository.getAccountByName("Đề thi Postman");
//		System.out.println(accountbyName);
	}
		
}
