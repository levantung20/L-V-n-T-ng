package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Order;
import com.vti.utils.HibernateUtils;

public class OrderRepository {

	private HibernateUtils hibernateUtils;

	public OrderRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Order> query = session.createQuery("FROM Order");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createOrder(Order order) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(order);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
