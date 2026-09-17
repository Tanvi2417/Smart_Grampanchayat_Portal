package com.sgp_hibernate.SGP_Hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sgp_hibernate.SGP_Hibernate.entity.Role;
import com.sgp_hibernate.SGP_Hibernate.entity.User;

public class UserRepository {
	
private SessionFactory sessionFactory;
	
	public UserRepository() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure();
		
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Role.class);
		
		sessionFactory = configuration.buildSessionFactory();
		
	}
	
	//Create user
	public void addUser(User user) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.persist(user);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//Read or GET role
	public User getUser(int userId) {
		
		Session session = sessionFactory.openSession();
		
		User user = session.find(User.class, userId);
		
		session.close();
		
		return user;
		
	}
	
	//Update role
	public void updateUser(User user) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.merge(user);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//Delete role
	public void deleteUser(int userId) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		User user = session.find(User.class, userId);
		
		session.remove(user);
		
		transaction.commit();
		
		session.close();
		
	}

}
