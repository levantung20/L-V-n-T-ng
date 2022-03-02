package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;

public class GroupRepository {
		private HibernateUtils hibernateUtils;

	@SuppressWarnings("static-access")
	public	GroupRepository() {
			hibernateUtils = hibernateUtils.getInstance();
		}
			
	@SuppressWarnings("unchecked")
	public List<Group> getALLGroups() {
		Session session = null ;
		
		try {
			// get session 
			session = hibernateUtils.openSession();
			
			// create hql query 
			Query<Group> query = session.createQuery("FROM Group");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
		public void createGroup(Group groups) {
			Session session = null; 
			
			try {
				// get session 
				session = hibernateUtils.openSession();
				session.beginTransaction();
				// create save
				session.save(groups);
				session.getTransaction().commit();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
}
