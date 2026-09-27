package com.sgp_hibernate.SGP_Hibernate.repository;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sgp_hibernate.SGP_Hibernate.entity.CertificateType;


public class CertificateTypeRepository {
	
	private SessionFactory sessionFactory;
	
	public CertificateTypeRepository() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure();
		
		configuration.addAnnotatedClass(CertificateType.class);
		
		sessionFactory = configuration.buildSessionFactory();
		
	}
	
	//Create certificate type
		public void addCertificateType(CertificateType certificateType) {
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.persist(certificateType);
			
			transaction.commit();
			
			session.close();
			
		}
		
		//Read or GET certificate type
		public CertificateType getCertificateType(int certificateTypeId) {
			
			Session session = sessionFactory.openSession();
			
			CertificateType certificateType = session.find(CertificateType.class, certificateTypeId);
			
			session.close();
			
			return certificateType;
			
		}
		
		//Update certificate type
		public void updateCertificateType(CertificateType certificateType) {
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.merge(certificateType);
			
			transaction.commit();
			
			session.close();
			
		}
		
		//Delete certificate type
		public void deleteCertificateType(int certificateTypeId) {
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			CertificateType certificateType = session.find(CertificateType.class, certificateTypeId);
			
			session.remove(certificateType);
			
			transaction.commit();
			
			session.close();
			
		}

}
