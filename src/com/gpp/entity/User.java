package com.gpp.entity;

import java.time.LocalDate;
import java.sql.Timestamp;

public class User {

    private int userId;
    private int roleId;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String password;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public User() {
    }

    public User(int roleId, String fullName, String email,
                String mobileNumber, String password,
                LocalDate dateOfBirth, String gender,
                String address, boolean active) {

        this.roleId = roleId;
        this.fullName = fullName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.active = active;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {

        return "User{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}