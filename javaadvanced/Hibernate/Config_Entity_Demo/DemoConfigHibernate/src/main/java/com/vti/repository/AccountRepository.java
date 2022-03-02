package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account Account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public Account getAccountByID(short id) {
		Session session = null;
		try {
				// get session 
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// get accountbyid;
			Account account = session.get(Account.class, id);
			session.getTransaction().commit();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
		@SuppressWarnings("unchecked")
		public Account getAccountByName(String title) {
			Session session = null;
			try {
					// get session 
				session = hibernateUtils.openSession();
				session.beginTransaction();
				
				// get account by name
				Query<Account> query = session.createQuery("FROM Account WHERE title = :nameParameter");
				query.setParameter("nameParameter", title);
				
				Account accounts = query.uniqueResult();
				session.getTransaction().commit();
				return accounts;
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
}
