package com.sgp_hibernate.SGP_Hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificateType")
public class CertificateType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int certificateTypeId;
	
	private String typeName;
	
	private String description;
	
	public CertificateType() {
		
	}

	public CertificateType(String typeName, String description) {
		super();
		this.typeName = typeName;
		this.description = description;
	}

	public int getCertificateTypeId() {
		return certificateTypeId;
	}

	public void setCertificateTypeId(int certificateTypeId) {
		this.certificateTypeId = certificateTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CertificateType [certificateTypeId=" + certificateTypeId + ", typeName=" + typeName + ", description="
				+ description + "]";
	}
	
	

}
