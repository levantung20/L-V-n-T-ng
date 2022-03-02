package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

public class DepartmentRepository {
				@SuppressWarnings("unused")
				private HibernateUtils hibernateUtils;
				
				public DepartmentRepository() {
					hibernateUtils = hibernateUtils.getInstance();
				}
				
			@SuppressWarnings("unchecked")
			public 	List<Department> getAllDepartments(){
					Session session = null;
					
					try {
							
						// get session 
						session = hibernateUtils.openSession();
						
						Query<Department> query = session.createQuery("FROM Department");
						
						return query.list();
						//create hql query
					} finally {
						if (session != null ) {
							session.close();
						}
					}
				}
			
			public void createDepartment(Department department) {
				Session session = null;
				
				 try {
					 
					 // get session 
					 session = hibernateUtils.openSession();
					 session.beginTransaction();
					 
					 // create 
					 session.save(department);
					 session.getTransaction().commit();
				} finally {
					if (session != null) {
						session.close();
					}
				}
			}
}
