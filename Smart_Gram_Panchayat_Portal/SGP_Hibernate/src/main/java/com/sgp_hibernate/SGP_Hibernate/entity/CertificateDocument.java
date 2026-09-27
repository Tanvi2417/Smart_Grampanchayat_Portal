package com.sgp_hibernate.SGP_Hibernate.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificate_document")
public class CertificateDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documentId;
	
	private String documentName;
	private LocalDate uploadedDate;
	private String filepath;
	
	@ManyToOne
	@JoinColumn(name = "certificate_id")
	private Certificate certificate;
	
	public CertificateDocument() {
		
	}

	public CertificateDocument(String documentName, LocalDate uploadedDate, String filepath, Certificate certificate) {
		super();
		this.documentName = documentName;
		this.uploadedDate = uploadedDate;
		this.filepath = filepath;
		this.certificate = certificate;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public LocalDate getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(LocalDate uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	@Override
	public String toString() {
		return "CertificateDocument [documentId=" + documentId + ", documentName=" + documentName + ", uploadedDate="
				+ uploadedDate + ", filepath=" + filepath + ", certificate=" + certificate + "]";
	}
	
	

}
