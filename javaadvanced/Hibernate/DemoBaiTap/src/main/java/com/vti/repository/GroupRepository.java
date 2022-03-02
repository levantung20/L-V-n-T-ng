package com.vti.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import com.vti.Utils.HibernateUtils;
import com.vti.entity.Group;

public class GroupRepository {
	private HibernateUtils hibernateUtils;

	public GroupRepository() {
		hibernateUtils = HibernateUtils.getInstance();

	}

	@SuppressWarnings({ "unchecked" })
	public List<Group> getAllGroups() {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query

			Query<Group> query = session.createQuery(" FROM Group "); // tạo câu query
			
			return query.list();     // lấy ra câu query
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Group getGroupById(short id) {
		Session session = null;
		try {

			// get session
			session = hibernateUtils.openSession();

			// get group by id
			Group group = session.get(Group.class, id);
			return group;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Group getGroupByName(String name) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			@SuppressWarnings("unchecked")
			Query<Group> query = session.createQuery("FROM Group WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Group group = query.uniqueResult();
			return group;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
		
	
	// create
	@SuppressWarnings({ "null", "resource" })
	public void createGroup(Group group) {
		Session session = null;
		session.beginTransaction();
		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(group);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// update cách 1 :
	public void updateGroup(short id, String newName) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Group
			Group group = (Group) session.load(Group.class, id);

			// update
			group.setName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// update cách 2 :
	public void updateGroup(Group group) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(group);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// delete
	public void deleteGroupID(short id) {
		Session session = null;

		try {
			// get sesison
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get group
			Group group = (Group) session.load(Group.class, id);

			// thực hiện hàm delete
			session.delete(group);
			session.getTransaction().commit();
			System.out.println("delete thành công");
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// check by ID
	public boolean isGroupExistsByID(short id) {

		// get group
		Group group = getGroupById(id);

		// return result
		if (group == null) {
			return false;
		}
		return true;
	}

	// check byName
	public boolean isGroupExistsByName(String newName) {

		// get group
		Group group = getGroupByName(newName);

		// return result
		if (group == null) {
			return false;
		}
		return true;
	}
}
