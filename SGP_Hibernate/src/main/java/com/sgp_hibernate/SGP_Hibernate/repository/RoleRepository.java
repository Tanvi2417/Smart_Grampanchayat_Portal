package com.sgp_hibernate.SGP_Hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sgp_hibernate.SGP_Hibernate.entity.Role;

public class RoleRepository {
	
	private SessionFactory sessionFactory;
	
	public RoleRepository() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure();
		
		configuration.addAnnotatedClass(Role.class);
		
		sessionFactory = configuration.buildSessionFactory();
		
	}
	
	//Create role
	public void addRole(Role role) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.persist(role);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//Read or GET role
	public Role getRole(int roleId) {
		
		Session session = sessionFactory.openSession();
		
		Role role = session.find(Role.class, roleId);
		
		session.close();
		
		return role;
		
	}
	
	//Update role
	public void updateRole(Role role) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.merge(role);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//Delete role
	public void deleteRole(int roleId) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Role role = session.find(Role.class, roleId);
		
		session.remove(role);
		
		transaction.commit();
		
		session.close();
		
	}

}
