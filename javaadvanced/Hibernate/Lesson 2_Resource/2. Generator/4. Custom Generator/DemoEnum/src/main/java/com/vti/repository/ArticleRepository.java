package com.vti.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Article;
import com.vti.utils.HibernateUtils;

public class ArticleRepository {

	private HibernateUtils hibernateUtils;

	public ArticleRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public void createArticle(Article article) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(article);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked" })
	public int getCountByType(String type) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Long> query = session.createQuery("SELECT COUNT(1) FROM Article WHERE type = :typeParameter");

			// set parameter
			query.setParameter("typeParameter", type);

			// get result
			return query.uniqueResult().intValue();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
