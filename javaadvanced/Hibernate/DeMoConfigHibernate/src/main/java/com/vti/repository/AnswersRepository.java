package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Answer;
import com.vti.utils.HibernateUtils;

public class AnswersRepository {
	@SuppressWarnings("unused")
	private HibernateUtils hibernateUtils;

	public AnswersRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
			
		public List<Answer> getAllAnswer() {
			Session session = null; 
				
			try {
				// get session 
				session = hibernateUtils.openSession();
				
				// create hql  query 
				@SuppressWarnings("unchecked")
				Query<Answer> query = session.createQuery("FROM Answer");
				
				return query.list();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
		public void createAnswers(Answer answer) {
			Session session = null;
			try {
					// get session 
				session = hibernateUtils.openSession();
				session.beginTransaction();
				// create save
				session.save(answer);
				session.getTransaction().commit();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
}
