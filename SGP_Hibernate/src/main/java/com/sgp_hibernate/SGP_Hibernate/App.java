package com.sgp_hibernate.SGP_Hibernate;

import com.sgp_hibernate.SGP_Hibernate.entity.User;
import com.sgp_hibernate.SGP_Hibernate.repository.UserRepository;

import java.time.LocalDate;

import com.sgp_hibernate.SGP_Hibernate.entity.CertificateType;
import com.sgp_hibernate.SGP_Hibernate.entity.Role;
import com.sgp_hibernate.SGP_Hibernate.repository.CertificateTypeRepository;
import com.sgp_hibernate.SGP_Hibernate.repository.RoleRepository;

public class App {
	
  public static void main(String[] args) {
	  
//	  RoleRepository rp = new RoleRepository();
	  
	  //Create role
//	  Role r1 = new Role("Admin", "Administrator");
//	  rp.addRole(r1);
	  
	  //Read or GET role
//	  System.out.println("Role:");
//	  Role r2 = rp.getRole(1);
//	  System.out.println(r2);
//	  
	  //Update role
//	  Role r3 = rp.getRole(1);
//	  r3.setRoleName("Admin1");
//	  r3.setDescription("Main Administrator");
//	  rp.updateRole(r3);
	  
	  //Delete role
//	  rp.deleteRole(2);
	  
//	  UserRepository ur = new UserRepository();
	  
	  //Create user
//	  User u1 = new User(r2, "Siddhesh Thakur", "sid@123", "1234567890", "admin", LocalDate.of(2004,12,18), "Male", "Mumbai");
//	  ur.addUser(u1);
	  
	  //Read user
//	  System.out.println("User:");
//	  User u2 = ur.getUser(2);
//	  System.out.println(u2);
	  
	  //Update user
//	  User u3 = ur.getUser(1);
//	  u3.setFullName("Rohit Sharma");
//	  ur.updateUser(u3);
	  
	  //Delete user
//	  ur.deleteUser(1);
	  
	  CertificateTypeRepository ctr = new CertificateTypeRepository();
	  
	  //Create certificate type
//	  CertificateType ct1 = new CertificateType( "Birth Certificate", "Certificate issued as proof of birth");
//	  ctr.addCertificateType(ct1);
	  
	  //Read or GET certificate type
//	  System.out.println("Certificate Type:");
//	  CertificateType ct2 = ctr.getCertificateType(1);
//	  System.out.println(ct2);
	  
	  //Update certificate type
//	  CertificateType ct3 = ctr.getCertificateType(1);
//	  ct3.setDescription("Certificate issued as proof of birth to user");
//	  ctr.updateCertificateType(ct3);
	  
	  //Delete certificate type
	  ctr.deleteCertificateType(2);
  
  }
}
