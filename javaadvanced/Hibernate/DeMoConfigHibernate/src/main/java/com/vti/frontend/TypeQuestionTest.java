package com.vti.frontend;

import java.util.List;

import com.vti.entity.TypeQuestion;
import com.vti.entity.enumrate.TypeName;
import com.vti.repository.TypeQuestionRepository;

public class TypeQuestionTest {
		public static void main(String[] args) {
			TypeQuestionRepository tyRepository = new TypeQuestionRepository();
			
//			List<TypeQuestion> tests = tyRepository.getAllTypeQuestions();
//			for (TypeQuestion typeQuestion : tests) {
//				System.out.println(typeQuestion);
//			}
				TypeQuestion typeQuestion = new TypeQuestion();
				typeQuestion.setId((short)3);
				typeQuestion.setName(TypeName.SCRUM_MASTER);
				tyRepository.createTypeQuestion(typeQuestion);
		}
			
}
