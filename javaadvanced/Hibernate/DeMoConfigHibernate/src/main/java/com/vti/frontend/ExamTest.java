package com.vti.frontend;

import java.util.Date;
import java.util.List;

import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;

public class ExamTest {
			@SuppressWarnings("deprecation")
			public static void main(String[] args) {
				ExamRepository examRepository = new ExamRepository();
				
				List<Exam> exams = examRepository.getAllExam();
				
				for (Exam exam : exams) {
					System.out.println(exam);
				}
				System.out.println("\n \n =============CreateExam=========");
				
				Exam exam = new Exam();
				exam.setCode1("L-2");
				exam.setCode2(null);
				exam.setDuration((short) 170);
				exam.setTitle("Đê Thi Java");
				exam.setId((short)11);
				exam.setCreateDate( new Date("2022/04/10"));
				examRepository.createExam(exam);
			}
			
}
