package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.RegularEmployee;
import com.vti.utils.HibernateUtils;

public class EmployeeRepository {

	private HibernateUtils hibernateUtils;

	public EmployeeRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<RegularEmployee> getAllRegularEmployees() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<RegularEmployee> query = session.createQuery("FROM RegularEmployee");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createRegularEmployee(RegularEmployee regularEmployee) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(regularEmployee);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
