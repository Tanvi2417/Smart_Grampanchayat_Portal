package com.sgp_hibernate.SGP_Hibernate.repository;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sgp_hibernate.SGP_Hibernate.entity.Certificate;
import com.sgp_hibernate.SGP_Hibernate.entity.CertificateDocument;
import com.sgp_hibernate.SGP_Hibernate.entity.CertificateType;
import com.sgp_hibernate.SGP_Hibernate.entity.Role;
import com.sgp_hibernate.SGP_Hibernate.entity.User;

public class CertificateDocumentRepository {
	
private SessionFactory sessionFactory;
	
	public CertificateDocumentRepository() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure();
		
		configuration.addAnnotatedClass(CertificateDocument.class);
		configuration.addAnnotatedClass(Certificate.class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Role.class);
		configuration.addAnnotatedClass(CertificateType.class);
		
		sessionFactory = configuration.buildSessionFactory();
		
	}
	
	//Create Certificate Document
	public void addCertificateDocument(CertificateDocument certificateDocument) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.persist(certificateDocument);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//Read or GET certificate document
	public CertificateDocument getCertificateDocument(int documentId) {
				
		Session session = sessionFactory.openSession();
				
		CertificateDocument certificateDocument = session.find(CertificateDocument.class, documentId);
				
		session.close();
				
		return certificateDocument;
				
	}
			
	//Update certificate document
	public void updateCertificateDocument(CertificateDocument certificateDocument) {
				
		Session session = sessionFactory.openSession();
				
		Transaction transaction = session.beginTransaction();
				
		session.merge(certificateDocument);
				
		transaction.commit();
				
		session.close();
				
	}
			
	//Delete certificate document
	public void deleteCertificateDocument(int documentId) {
				
		Session session = sessionFactory.openSession();
				
		Transaction transaction = session.beginTransaction();
				
		CertificateDocument certificateDocument = session.find(CertificateDocument.class, documentId);
				
		session.remove(certificateDocument);
				
		transaction.commit();
				
		session.close();
				
	}

}
