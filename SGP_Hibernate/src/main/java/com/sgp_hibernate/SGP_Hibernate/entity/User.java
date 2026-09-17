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
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;
	
	private String fullName;
	private String email;
	private String mobileNumber;
	private String password;
	private LocalDate dateOfBirth;
	private String gender;
	private String address;
	
	public User() {
		
	}
	
	public User(Role role, String fullName, String email, String mobileNumber, String password, LocalDate dateOfBirth,
			String gender, String address) {
		super();
		this.role = role;
		this.fullName = fullName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", role=" + role + ", fullName=" + fullName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	
	

}
