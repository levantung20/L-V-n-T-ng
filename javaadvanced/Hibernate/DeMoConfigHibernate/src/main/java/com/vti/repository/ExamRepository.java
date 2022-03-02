package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;

public class ExamRepository {
	private HibernateUtils hibernateUtils;

	@SuppressWarnings("static-access")
	public ExamRepository() {
		hibernateUtils = hibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExam() {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Exam> query = session.createQuery("FROM Exam");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
			public void createExam(Exam exam) {
				Session session = null;
				
				try {
					// get session 
					session = hibernateUtils.openSession();
					session.beginTransaction();
					
					// create save
					session.save(exam);
					session.getTransaction().commit();
				} finally {
					if (session != null) {
						session.close();
					}
				}
			}
}
