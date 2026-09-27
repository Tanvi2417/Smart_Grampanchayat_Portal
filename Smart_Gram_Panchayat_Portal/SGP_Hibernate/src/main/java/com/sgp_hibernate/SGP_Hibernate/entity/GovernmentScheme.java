package com.sgp_hibernate.SGP_Hibernate.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "government_scheme")
public class GovernmentScheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int schemeId;
	
	private String schemeName;
	private String description;
	private String eligibilityCriteria;
	private String benefits;
	private String applicationProcess;
	private String applicationLink;
	private LocalDate lastUpdated;
	
	public GovernmentScheme() {
		
	}

	public GovernmentScheme(String schemeName, String description, String eligibilityCriteria, String benefits,
			String applicationProcess, String applicationLink, LocalDate lastUpdated) {
		super();
		this.schemeName = schemeName;
		this.description = description;
		this.eligibilityCriteria = eligibilityCriteria;
		this.benefits = benefits;
		this.applicationProcess = applicationProcess;
		this.applicationLink = applicationLink;
		this.lastUpdated = lastUpdated;
	}

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}

	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getApplicationProcess() {
		return applicationProcess;
	}

	public void setApplicationProcess(String applicationProcess) {
		this.applicationProcess = applicationProcess;
	}

	public String getApplicationLink() {
		return applicationLink;
	}

	public void setApplicationLink(String applicationLink) {
		this.applicationLink = applicationLink;
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "GovernmentScheme [schemeId=" + schemeId + ", schemeName=" + schemeName + ", description=" + description
				+ ", eligibilityCriteria=" + eligibilityCriteria + ", benefits=" + benefits + ", applicationProcess="
				+ applicationProcess + ", applicationLink=" + applicationLink + ", lastUpdated=" + lastUpdated + "]";
	}
	
	

}
