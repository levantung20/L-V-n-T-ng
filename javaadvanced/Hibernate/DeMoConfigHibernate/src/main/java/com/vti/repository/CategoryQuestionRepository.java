package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.CategoryQuestion;
import com.vti.utils.HibernateUtils;

public class CategoryQuestionRepository {
	private HibernateUtils hibernateUtils;

	public CategoryQuestionRepository() {
		hibernateUtils = hibernateUtils.getInstance();
	}

	public List<CategoryQuestion> getAllCategoryQuestions() {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			@SuppressWarnings("unchecked")
			Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion");

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
			public void createCategoryQuestion(CategoryQuestion categoryQuestion) {
				Session session = null;
				
				try {
					// get session 
					session = hibernateUtils.openSession();
					session.beginTransaction();
					// create
					session.save(categoryQuestion);
					session.getTransaction().commit();
				} finally {
					if (session != null) {
						session.close();
					}
				}
			}

}
