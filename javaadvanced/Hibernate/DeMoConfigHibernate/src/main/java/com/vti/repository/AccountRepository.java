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
		
	public 	List<Account> getAllAccounts() {
				Session session = null;
				
				try {
						
					// get session 
					session = hibernateUtils.openSession();
					session.beginTransaction();
					// create hql query
					@SuppressWarnings("unchecked")
					Query<Account> query = session.createQuery("FROM Account");
					
					
					session.getTransaction().commit();
					return query.list();
				} finally {
					if (session != null) {
						session.close();
					}
				}
		}
	
			public void createAccount(Account account) {
				Session session = null;
				 try {
					 
					 // get sesssion 
					 session = hibernateUtils.openSession();
					 session.beginTransaction();
					 
					 //create
					 session.save(account);
					 session.getTransaction().commit();
					 
				} finally {
					if (session != null) {
						session.close();
					}
				}
			}
}
