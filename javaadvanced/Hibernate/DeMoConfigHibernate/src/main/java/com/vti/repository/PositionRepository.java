package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;

public class PositionRepository {
	private HibernateUtils hibernateUtils;

	@SuppressWarnings("static-access")
	public PositionRepository() {

		hibernateUtils = hibernateUtils.getInstance();

	}
	@SuppressWarnings("unchecked")
	public	List<Position> getPositions() {
			Session session = null;
			
			try {
					// get session
				session = hibernateUtils.openSession();
				
				// create hql query 
				Query<Position> query = session.createQuery("FROM Position");
				return query.list();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
	
		public void createPosition(Position positionCreate) {
			Session session = null;
			 try {
				 	// get session 
				 session = hibernateUtils.openSession();
				 session.beginTransaction();
				 
				 session.save(getPositions());
				 session.getTransaction().commit();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}

}
