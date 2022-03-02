package com.vti.frontend;

import java.util.List;

import com.vti.entity.CategoryQuestion;
import com.vti.repository.CategoryQuestionRepository;

public class CategoryQuestionTest {
			public static void main(String[] args) {
				CategoryQuestionRepository categoryQuestionRepository = new CategoryQuestionRepository();
				
				 List<CategoryQuestion> categoryQuestions = categoryQuestionRepository.getAllCategoryQuestions();
				
				 for (CategoryQuestion categoryQuestion : categoryQuestions) {
					System.out.println(categoryQuestion);
				}
					System.out.println("\n\n***********CREATE CATEGORYQUESTION***********");
					CategoryQuestion categoryQuestion = new CategoryQuestion();
					categoryQuestion.setId((short)11);
					categoryQuestion.setCategoryName("BlockChain");
					categoryQuestionRepository.createCategoryQuestion(categoryQuestion);
			}
			
}
