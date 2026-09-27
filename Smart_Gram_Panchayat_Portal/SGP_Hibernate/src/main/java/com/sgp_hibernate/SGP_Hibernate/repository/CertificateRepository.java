package com.sgp_hibernate.SGP_Hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sgp_hibernate.SGP_Hibernate.entity.Certificate;
import com.sgp_hibernate.SGP_Hibernate.entity.CertificateType;
import com.sgp_hibernate.SGP_Hibernate.entity.Role;
import com.sgp_hibernate.SGP_Hibernate.entity.User;

public class CertificateRepository {
	
	private SessionFactory sessionFactory;
	
	public CertificateRepository() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure();
		
		configuration.addAnnotatedClass(Certificate.class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Role.class);
		configuration.addAnnotatedClass(CertificateType.class);
		
		sessionFactory = configuration.buildSessionFactory();
		
	}
	
	//Create Certificate
	public void addCertificate(Certificate certificate) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.persist(certificate);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//Read or GET certificate 
	public Certificate getCertificate(int certificateId) {
				
		Session session = sessionFactory.openSession();
				
		Certificate certificate = session.find(Certificate.class, certificateId);
				
		session.close();
				
		return certificate;
				
	}
			
	//Update certificate 
	public void updateCertificate(Certificate certificate) {
				
		Session session = sessionFactory.openSession();
				
		Transaction transaction = session.beginTransaction();
				
		session.merge(certificate);
				
		transaction.commit();
				
		session.close();
				
	}
			
	//Delete certificate 
	public void deleteCertificate(int certificateId) {
				
		Session session = sessionFactory.openSession();
				
		Transaction transaction = session.beginTransaction();
				
		Certificate certificate = session.find(Certificate.class, certificateId);
				
		session.remove(certificate);
				
		transaction.commit();
				
		session.close();
				
	}

}
