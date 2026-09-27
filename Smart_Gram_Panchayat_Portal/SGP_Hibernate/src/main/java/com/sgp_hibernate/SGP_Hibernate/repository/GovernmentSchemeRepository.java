package com.sgp_hibernate.SGP_Hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sgp_hibernate.SGP_Hibernate.entity.GovernmentScheme;

public class GovernmentSchemeRepository {
	
private SessionFactory sessionFactory;
	
	public GovernmentSchemeRepository() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure();
		
		configuration.addAnnotatedClass(GovernmentScheme.class);
		
		sessionFactory = configuration.buildSessionFactory();
		
	}
	
	//Create Scheme
	public void addGovernmentScheme(GovernmentScheme scheme) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.persist(scheme);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//Read or GET Scheme
	public GovernmentScheme getGovernmentScheme(int schemeId) {
				
		Session session = sessionFactory.openSession();
				
		GovernmentScheme scheme = session.find(GovernmentScheme.class, schemeId);
				
		session.close();
				
		return scheme;
				
	}
			
	//Update scheme
	public void updateGovernmentScheme(GovernmentScheme scheme) {
				
		Session session = sessionFactory.openSession();
				
		Transaction transaction = session.beginTransaction();
				
		session.merge(scheme);
				
		transaction.commit();
				
		session.close();
				
	}
			
	//Delete scheme
	public void deleteGovernmentScheme(int schemeId) {
				
		Session session = sessionFactory.openSession();
				
		Transaction transaction = session.beginTransaction();
				
		GovernmentScheme scheme = session.find(GovernmentScheme.class, schemeId);
				
		session.remove(scheme);
				
		transaction.commit();
				
		session.close();
				
	}

}
