package com.sgp_hibernate.SGP_Hibernate.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificate")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int certificateId;
	
	private String applicationNumber;
	private String purpose;
	private String status;
	private String remarks;
	
	private LocalDateTime approvedAt;
	private LocalDate appliedDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "certificate_type_id")
	private CertificateType certificateType; 
	
	public Certificate() {
		
	}

	public Certificate(String applicationNumber, String purpose, String status, String remarks,
			LocalDateTime approvedAt, LocalDate appliedDate, User user, CertificateType certificateType) {
		super();
		this.applicationNumber = applicationNumber;
		this.purpose = purpose;
		this.status = status;
		this.remarks = remarks;
		this.approvedAt = approvedAt;
		this.appliedDate = appliedDate;
		this.user = user;
		this.certificateType = certificateType;
	}

	public int getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(LocalDateTime approvedAt) {
		this.approvedAt = approvedAt;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CertificateType getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(CertificateType certificateType) {
		this.certificateType = certificateType;
	}

	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", applicationNumber=" + applicationNumber + ", purpose="
				+ purpose + ", status=" + status + ", remarks=" + remarks + ", approvedAt=" + approvedAt
				+ ", appliedDate=" + appliedDate + ", user=" + user + ", certificateType=" + certificateType + "]";
	}
	
	

}
