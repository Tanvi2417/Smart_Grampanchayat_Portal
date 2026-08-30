package com.gpp;

import com.gpp.entity.Role;
import com.gpp.entity.User;
import com.gpp.repository.RoleRepository;
import com.gpp.repository.UserRepository;
import com.gpp.entity.CertificateType;
import com.gpp.repository.CertificateTypeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserRepository userRepository = new UserRepository();
        RoleRepository roleRepository = new RoleRepository();
        CertificateTypeRepository certificateTypeRepository = new CertificateTypeRepository();

        while (true) {

            System.out.println("===== SMART GRAM PANCHAYAT =====");
            System.out.println("1. User Management");
            System.out.println("2. Role Management");
            System.out.println("3. Certificate Type Management");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    userMenu(scanner, userRepository);
                    break;

                case 2:
                    roleMenu(scanner, roleRepository);
                    break;
                    
                case 3:
                		certificateTypeMenu(scanner, certificateTypeRepository);
                		break;

                case 4:
                    System.out.println("Application Closed");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // USER MENU
    public static void userMenu(Scanner scanner, UserRepository repository) {

        while (true) {

            System.out.println("===== USER MANAGEMENT =====");  
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. View User By ID");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Back");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Role ID: ");
                    int roleId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Full Name: ");
                    String fullName = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Mobile Number: ");
                    String mobileNumber = scanner.nextLine();

                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    System.out.print("Date of Birth (YYYY-MM-DD): ");
                    String dateInput = scanner.nextLine();
                    LocalDate dateOfBirth = null;

                    if (!dateInput.isEmpty()) {
                    	
                        dateOfBirth = LocalDate.parse(dateInput);
                    }

                    System.out.print("Gender: ");
                    String gender = scanner.nextLine();

                    System.out.print("Address: ");
                    String address = scanner.nextLine();

                    User user = new User(
                            roleId,
                            fullName,
                            email,
                            mobileNumber,
                            password,
                            dateOfBirth,
                            gender,
                            address,
                            true
                    );

                    repository.addUser(user);
                    break;

                case 2:
                    List<User> users = repository.getAllUsers();

                    if (users.isEmpty()) {

                        System.out.println("No Users Found");

                    } else {

                        for (User user1 : users) {
                        	
                            System.out.println(user1);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int searchId = scanner.nextInt();
                    User foundUser = repository.getUserById(searchId);

                    if (foundUser != null) {

                        System.out.println(foundUser);

                    } else {
                        System.out.println("User Not Found");
                    }
                    break;

                case 4:
                    System.out.print("Enter User ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    User existingUser = repository.getUserById(updateId);

                    if (existingUser == null) {

                        System.out.println("User Not Found");
                        break;
                    }

                    System.out.print("Role ID: ");
                    int newRoleId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Full Name: ");
                    existingUser.setFullName(scanner.nextLine());

                    System.out.print("Email: ");
                    existingUser.setEmail(scanner.nextLine());

                    System.out.print("Mobile Number: ");
                    existingUser.setMobileNumber(scanner.nextLine());

                    System.out.print("Password: ");
                    existingUser.setPassword(scanner.nextLine());

                    System.out.print("Gender: ");
                    existingUser.setGender(scanner.nextLine());

                    System.out.print("Address: ");
                    existingUser.setAddress(scanner.nextLine());

                    existingUser.setRoleId(newRoleId);
                    repository.updateUser(existingUser);
                    break;

                case 5:
                    System.out.print("Enter User ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    repository.deleteUser(deleteId);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // ROLE MENU
    public static void roleMenu(Scanner scanner, RoleRepository repository) {

        while (true) {

            System.out.println("===== ROLE MANAGEMENT =====");
            System.out.println("1. Add Role");
            System.out.println("2. View All Roles");
            System.out.println("3. View Role By ID");
            System.out.println("4. Update Role");
            System.out.println("5. Delete Role");
            System.out.println("6. Back");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Role Name: ");
                    String roleName = scanner.nextLine();
                    
                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    Role role = new Role(roleName, description);
                    repository.addRole(role);
                    break;

                case 2:
                    List<Role> roles = repository.getAllRoles();

                    if (roles.isEmpty()) {

                        System.out.println("No Roles Found");

                    } else {
                    	
                        for (Role r : roles) {
                            System.out.println(r);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Role ID: ");
                    int roleId = scanner.nextInt();

                    Role foundRole = repository.getRoleById(roleId);

                    if (foundRole != null) {

                        System.out.println(foundRole);

                    } else {
                        System.out.println("Role Not Found");
                    }
                    break;

                case 4:
                    System.out.print("Enter Role ID to Update: ");
                    int updateRoleId = scanner.nextInt();
                    scanner.nextLine();

                    Role existingRole = repository.getRoleById(updateRoleId);

                    if (existingRole == null) {

                        System.out.println("Role Not Found");
                        break;
                    }

                    System.out.print("New Role Name: ");
                    existingRole.setRoleName(scanner.nextLine());

                    System.out.print("New Description: ");
                    existingRole.setDescription(scanner.nextLine());

                    repository.updateRole(existingRole);
                    break;

                case 5:
                    System.out.print("Enter Role ID to Delete: ");
                    int deleteRoleId = scanner.nextInt();
                    repository.deleteRole(deleteRoleId);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    
    //Certificate Type Menu
    
    public static void certificateTypeMenu(Scanner scanner, CertificateTypeRepository repository) {

        while (true) {

            System.out.println("===== CERTIFICATE TYPE MANAGEMENT =====");
            System.out.println("1. Add Certificate Type");
            System.out.println("2. View All Certificate Types");
            System.out.println("3. View Certificate Type By ID");
            System.out.println("4. Update Certificate Type");
            System.out.println("5. Delete Certificate Type");
            System.out.println("6. Back");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Type Name: ");
                    String typeName = scanner.nextLine();

                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    CertificateType certificateType = new CertificateType(typeName,description);

                    repository.addCertificateType(certificateType);
                    break;

                case 2:
                    List<CertificateType> certificateTypes = repository.getAllCertificateTypes();

                    if (certificateTypes.isEmpty()) {

                        System.out.println("No Certificate Types Found");

                    } else {

                        for (CertificateType certificateType1 : certificateTypes) {
                            System.out.println(certificateType1);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Certificate Type ID: ");
                    int certificateTypeId = scanner.nextInt();

                    CertificateType foundCertificateType = repository.getCertificateTypeById(certificateTypeId);

                    if (foundCertificateType != null) {

                        System.out.println(foundCertificateType);

                    } else {
                        System.out.println("Certificate Type Not Found");
                    }
                    break;

                case 4:
                    System.out.print("Enter Certificate Type ID to Update: ");
                    int updateCertificateTypeId = scanner.nextInt();
                    scanner.nextLine();

                    CertificateType existingCertificateType = repository.getCertificateTypeById(updateCertificateTypeId);

                    if (existingCertificateType == null) {

                        System.out.println("Certificate Type Not Found");
                        break;
                    }

                    System.out.print("New Type Name: ");
                    existingCertificateType.setTypeName(scanner.nextLine());

                    System.out.print("New Description: ");
                    existingCertificateType.setDescription(scanner.nextLine());

                    repository.updateCertificateType(existingCertificateType);
                    break;

                case 5:
                    System.out.print("Enter Certificate Type ID to Delete: ");
                    int deleteCertificateTypeId = scanner.nextInt();

                    repository.deleteCertificateType(deleteCertificateTypeId);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}