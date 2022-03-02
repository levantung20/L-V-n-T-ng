package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.TypeQuestion;
import com.vti.utils.HibernateUtils;

public class TypeQuestionRepository {
			private HibernateUtils hibernateUtils;

		@SuppressWarnings("static-access")
		public	TypeQuestionRepository() {

				hibernateUtils = hibernateUtils.getInstance();
			}
				
		public List<TypeQuestion> getAllTypeQuestions() {
			Session session = null;
			 
			try {
					// get session 
				session = hibernateUtils.openSession();
				
				// create hql query
				@SuppressWarnings("unchecked")
				Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion");
				return query.list();
			} finally {
				if (session  != null ) {
					session.close();
				}
			}
		}
		public void createTypeQuestion(TypeQuestion typeQuestion) {
			Session session = null;
			try {
					// get session 
				session = hibernateUtils.openSession();
				session.beginTransaction();
				
				// create save
				session.save(typeQuestion);
				session.getTransaction().commit();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
}
