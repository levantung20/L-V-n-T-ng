package com.vti.frontend;

import java.util.List;

import com.vti.entity.Answer;
import com.vti.repository.AnswersRepository;

public class AnswersTest {
			public static void main(String[] args) {
				AnswersRepository answersRepository = new AnswersRepository();
					
				List<Answer> answers = answersRepository.getAllAnswer();
				
				for (Answer answer : answers) {
					System.out.println(answer);
					}
				
				System.out.println("\n\n=======Create Answers======");
				Answer answer = new Answer();
				answer.setContent("Nội dung");
				answer.setId((short)11);
				answer.setIsconrrect(true);
				answersRepository.createAnswers(answer);
			}
			
}
