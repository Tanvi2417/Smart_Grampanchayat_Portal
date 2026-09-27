package com.sgp_hibernate.SGP_Hibernate;

import java.time.LocalDate;
import java.util.Scanner;

import com.sgp_hibernate.SGP_Hibernate.entity.Certificate;
import com.sgp_hibernate.SGP_Hibernate.entity.CertificateDocument;
import com.sgp_hibernate.SGP_Hibernate.entity.CertificateType;
import com.sgp_hibernate.SGP_Hibernate.entity.GovernmentScheme;
import com.sgp_hibernate.SGP_Hibernate.entity.Role;
import com.sgp_hibernate.SGP_Hibernate.entity.User;
import com.sgp_hibernate.SGP_Hibernate.repository.CertificateDocumentRepository;
import com.sgp_hibernate.SGP_Hibernate.repository.CertificateRepository;
import com.sgp_hibernate.SGP_Hibernate.repository.CertificateTypeRepository;
import com.sgp_hibernate.SGP_Hibernate.repository.GovernmentSchemeRepository;
import com.sgp_hibernate.SGP_Hibernate.repository.RoleRepository;
import com.sgp_hibernate.SGP_Hibernate.repository.UserRepository;
import com.sgp_hibernate.SGP_Hibernate.service.EligibilityService;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== SMART GRAM PANCHAYAT PORTAL =====");
            System.out.println("1. Role");
            System.out.println("2. User");
            System.out.println("3. Certificate Type");
            System.out.println("4. Certificate");
            System.out.println("5. Certificate Document");
            System.out.println("6. Government Scheme");
            System.out.println("7. Eligibility Check");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    roleMenu(scanner);
                    break;

                case 2:
                    userMenu(scanner);
                    break;

                case 3:
                    certificateTypeMenu(scanner);
                    break;

                case 4:
                    certificateMenu(scanner);
                    break;

                case 5:
                    certificateDocumentMenu(scanner);
                    break;

                case 6:
                    governmentSchemeMenu(scanner);
                    break;
                    
                case 7:
                    eligibilityMenu(scanner);
                    break;

                case 0:
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ROLE
    public static void roleMenu(Scanner scanner) {

        RoleRepository roleRepository = new RoleRepository();

        while (true) {

            System.out.println("\n--- Role ---");
            System.out.println("1. Add");
            System.out.println("2. Get");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    scanner.nextLine();

                    System.out.print("Enter role name: ");
                    String roleName = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    Role role = new Role(roleName, description);

                    roleRepository.addRole(role);

                    System.out.println("Role added successfully.");
                    break;

                case 2:
                    System.out.print("Enter role id: ");
                    int roleId = scanner.nextInt();

                    Role getRole = roleRepository.getRole(roleId);

                    if (getRole != null) {
                        System.out.println(getRole);
                    } else {
                        System.out.println("Role not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter role id: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter new role name: ");
                    String newRoleName = scanner.nextLine();

                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();

                    Role updateRole = new Role(newRoleName, newDescription);
                    updateRole.setRoleId(updateId);

                    roleRepository.updateRole(updateRole);

                    System.out.println("Role updated successfully.");
                    break;

                case 4:
                    System.out.print("Enter role id: ");
                    int deleteId = scanner.nextInt();

                    roleRepository.deleteRole(deleteId);

                    System.out.println("Role deleted successfully.");
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // USER
    public static void userMenu(Scanner scanner) {

        UserRepository userRepository = new UserRepository();
        RoleRepository roleRepository = new RoleRepository();

        while (true) {

            System.out.println("\n--- User ---");
            System.out.println("1. Add");
            System.out.println("2. Get");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    scanner.nextLine();

                    System.out.print("Enter role id: ");
                    int roleId = scanner.nextInt();
                    scanner.nextLine();

                    Role role = roleRepository.getRole(roleId);

                    if (role == null) {
                        System.out.println("Role not found.");
                        break;
                    }

                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter mobile number: ");
                    String mobileNumber = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    System.out.print("Enter date of birth (yyyy-mm-dd): ");
                    LocalDate dateOfBirth =
                            LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();

                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    
                    System.out.print("Enter annual income: ");
                    double annualIncome = scanner.nextDouble();

                    User user = new User(
                            role,
                            fullName,
                            email,
                            mobileNumber,
                            password,
                            dateOfBirth,
                            gender,
                            address,
                            annualIncome
                    );

                    userRepository.addUser(user);

                    System.out.println("User added successfully.");
                    break;


                case 2:
                    System.out.print("Enter user id: ");
                    int userId = scanner.nextInt();

                    User getUser = userRepository.getUser(userId);

                    if (getUser != null) {
                        System.out.println(getUser);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;


                case 3:
                    System.out.print("Enter user id: ");
                    int updateId = scanner.nextInt();

                    System.out.print("Enter role id: ");
                    int updateRoleId = scanner.nextInt();
                    scanner.nextLine();

                    Role updateRole = roleRepository.getRole(updateRoleId);

                    if (updateRole == null) {
                        System.out.println("Role not found.");
                        break;
                    }

                    System.out.print("Enter full name: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String updateEmail = scanner.nextLine();

                    System.out.print("Enter mobile number: ");
                    String updateMobile = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String updatePassword = scanner.nextLine();

                    System.out.print("Enter date of birth (yyyy-mm-dd): ");
                    LocalDate updateDob =
                            LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter gender: ");
                    String updateGender = scanner.nextLine();

                    System.out.print("Enter address: ");
                    String updateAddress = scanner.nextLine();
                    
                    System.out.print("Enter annual income: ");
                    double updateannualIncome = scanner.nextDouble();

                    User updateUser = new User(
                            updateRole,
                            updateName,
                            updateEmail,
                            updateMobile,
                            updatePassword,
                            updateDob,
                            updateGender,
                            updateAddress,
                            updateannualIncome
                    );

                    updateUser.setUserId(updateId);

                    userRepository.updateUser(updateUser);

                    System.out.println("User updated successfully.");
                    break;


                case 4:
                    System.out.print("Enter user id: ");
                    int deleteId = scanner.nextInt();

                    userRepository.deleteUser(deleteId);

                    System.out.println("User deleted successfully.");
                    break;


                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // CERTIFICATE TYPE
    public static void certificateTypeMenu(Scanner scanner) {

        CertificateTypeRepository certificateTypeRepository =
                new CertificateTypeRepository();

        while (true) {

            System.out.println("\n--- Certificate Type ---");
            System.out.println("1. Add");
            System.out.println("2. Get");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    scanner.nextLine();

                    System.out.print("Enter type name: ");
                    String typeName = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    CertificateType certificateType =
                            new CertificateType(typeName, description);

                    certificateTypeRepository
                            .addCertificateType(certificateType);

                    System.out.println("Certificate type added successfully.");
                    break;


                case 2:
                    System.out.print("Enter certificate type id: ");
                    int certificateTypeId = scanner.nextInt();

                    CertificateType getCertificateType =
                            certificateTypeRepository
                                    .getCertificateType(certificateTypeId);

                    if (getCertificateType != null) {
                        System.out.println(getCertificateType);
                    } else {
                        System.out.println("Certificate type not found.");
                    }
                    break;


                case 3:
                    System.out.print("Enter certificate type id: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter new type name: ");
                    String newTypeName = scanner.nextLine();

                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();

                    CertificateType updateCertificateType =
                            new CertificateType(
                                    newTypeName,
                                    newDescription
                            );

                    updateCertificateType.setCertificateTypeId(updateId);

                    certificateTypeRepository
                            .updateCertificateType(updateCertificateType);

                    System.out.println("Certificate type updated successfully.");
                    break;


                case 4:
                    System.out.print("Enter certificate type id: ");
                    int deleteId = scanner.nextInt();

                    certificateTypeRepository
                            .deleteCertificateType(deleteId);

                    System.out.println("Certificate type deleted successfully.");
                    break;


                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // CERTIFICATE
    public static void certificateMenu(Scanner scanner) {

        CertificateRepository certificateRepository =
                new CertificateRepository();

        UserRepository userRepository =
                new UserRepository();

        CertificateTypeRepository certificateTypeRepository =
                new CertificateTypeRepository();

        while (true) {

            System.out.println("\n--- Certificate ---");
            System.out.println("1. Add");
            System.out.println("2. Get");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    scanner.nextLine();

                    System.out.print("Enter application number: ");
                    String applicationNumber = scanner.nextLine();

                    System.out.print("Enter purpose: ");
                    String purpose = scanner.nextLine();

                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();

                    System.out.print("Enter remarks: ");
                    String remarks = scanner.nextLine();

                    System.out.print("Enter applied date (yyyy-mm-dd): ");
                    LocalDate appliedDate =
                            LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter user id: ");
                    int userId = scanner.nextInt();

                    System.out.print("Enter certificate type id: ");
                    int certificateTypeId = scanner.nextInt();

                    User user = userRepository.getUser(userId);

                    CertificateType certificateType =
                            certificateTypeRepository
                                    .getCertificateType(certificateTypeId);

                    if (user == null) {
                        System.out.println("User not found.");
                        break;
                    }

                    if (certificateType == null) {
                        System.out.println("Certificate type not found.");
                        break;
                    }

                    Certificate certificate = new Certificate(
                            applicationNumber,
                            purpose,
                            status,
                            remarks,
                            null,
                            appliedDate,
                            user,
                            certificateType
                    );

                    certificateRepository.addCertificate(certificate);

                    System.out.println("Certificate added successfully.");
                    break;


                case 2:
                    System.out.print("Enter certificate id: ");
                    int certificateId = scanner.nextInt();

                    Certificate getCertificate =
                            certificateRepository
                                    .getCertificate(certificateId);

                    if (getCertificate != null) {
                        System.out.println(getCertificate);
                    } else {
                        System.out.println("Certificate not found.");
                    }
                    break;


                case 3:
                    System.out.print("Enter certificate id: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter application number: ");
                    String updateApplicationNumber =
                            scanner.nextLine();

                    System.out.print("Enter purpose: ");
                    String updatePurpose =
                            scanner.nextLine();

                    System.out.print("Enter status: ");
                    String updateStatus =
                            scanner.nextLine();

                    System.out.print("Enter remarks: ");
                    String updateRemarks =
                            scanner.nextLine();

                    System.out.print("Enter applied date (yyyy-mm-dd): ");
                    LocalDate updateAppliedDate =
                            LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter user id: ");
                    int updateUserId = scanner.nextInt();

                    System.out.print("Enter certificate type id: ");
                    int updateCertificateTypeId = scanner.nextInt();

                    User updateUser =
                            userRepository.getUser(updateUserId);

                    CertificateType updateCertificateType =
                            certificateTypeRepository
                                    .getCertificateType(updateCertificateTypeId);

                    if (updateUser == null) {
                        System.out.println("User not found.");
                        break;
                    }

                    if (updateCertificateType == null) {
                        System.out.println("Certificate type not found.");
                        break;
                    }

                    Certificate updateCertificate =
                            new Certificate(
                                    updateApplicationNumber,
                                    updatePurpose,
                                    updateStatus,
                                    updateRemarks,
                                    null,
                                    updateAppliedDate,
                                    updateUser,
                                    updateCertificateType
                            );

                    updateCertificate.setCertificateId(updateId);

                    certificateRepository.updateCertificate(
                            updateCertificate
                    );

                    System.out.println("Certificate updated successfully.");
                    break;


                case 4:
                    System.out.print("Enter certificate id: ");
                    int deleteId = scanner.nextInt();

                    certificateRepository.deleteCertificate(deleteId);

                    System.out.println("Certificate deleted successfully.");
                    break;


                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // CERTIFICATE DOCUMENT
    public static void certificateDocumentMenu(Scanner scanner) {

        CertificateDocumentRepository documentRepository =
                new CertificateDocumentRepository();

        CertificateRepository certificateRepository =
                new CertificateRepository();

        while (true) {

            System.out.println("\n--- Certificate Document ---");
            System.out.println("1. Add");
            System.out.println("2. Get");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    scanner.nextLine();

                    System.out.print("Enter document name: ");
                    String documentName = scanner.nextLine();

                    System.out.print("Enter uploaded date (yyyy-mm-dd): ");
                    LocalDate uploadedDate =
                            LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();

                    System.out.print("Enter certificate id: ");
                    int certificateId = scanner.nextInt();

                    Certificate certificate =
                            certificateRepository.getCertificate(certificateId);

                    if (certificate == null) {
                        System.out.println("Certificate not found.");
                        break;
                    }

                    CertificateDocument document =
                            new CertificateDocument(
                                    documentName,
                                    uploadedDate,
                                    filePath,
                                    certificate
                            );

                    documentRepository.addCertificateDocument(document);

                    System.out.println("Document added successfully.");
                    break;


                case 2:
                    System.out.print("Enter document id: ");
                    int documentId = scanner.nextInt();

                    CertificateDocument getDocument =
                            documentRepository
                                    .getCertificateDocument(documentId);

                    if (getDocument != null) {
                        System.out.println(getDocument);
                    } else {
                        System.out.println("Document not found.");
                    }
                    break;


                case 3:
                    System.out.print("Enter document id: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter document name: ");
                    String updateDocumentName = scanner.nextLine();

                    System.out.print("Enter uploaded date (yyyy-mm-dd): ");
                    LocalDate updateUploadedDate =
                            LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter file path: ");
                    String updateFilePath = scanner.nextLine();

                    System.out.print("Enter certificate id: ");
                    int updateCertificateId = scanner.nextInt();

                    Certificate updateCertificate =
                            certificateRepository
                                    .getCertificate(updateCertificateId);

                    if (updateCertificate == null) {
                        System.out.println("Certificate not found.");
                        break;
                    }

                    CertificateDocument updateDocument =
                            new CertificateDocument(
                                    updateDocumentName,
                                    updateUploadedDate,
                                    updateFilePath,
                                    updateCertificate
                            );

                    updateDocument.setDocumentId(updateId);

                    documentRepository
                            .updateCertificateDocument(updateDocument);

                    System.out.println("Document updated successfully.");
                    break;


                case 4:
                    System.out.print("Enter document id: ");
                    int deleteId = scanner.nextInt();

                    documentRepository
                            .deleteCertificateDocument(deleteId);

                    System.out.println("Document deleted successfully.");
                    break;


                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // GOVERNMENT SCHEME
    public static void governmentSchemeMenu(Scanner scanner) {

        GovernmentSchemeRepository schemeRepository =
                new GovernmentSchemeRepository();

        while (true) {

            System.out.println("\n--- Government Scheme ---");
            System.out.println("1. Add");
            System.out.println("2. Get");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    scanner.nextLine();

                    System.out.print("Enter scheme name: ");
                    String schemeName = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter eligibility criteria: ");
                    String eligibilityCriteria = scanner.nextLine();

                    System.out.print("Enter benefits: ");
                    String benefits = scanner.nextLine();

                    System.out.print("Enter application process: ");
                    String applicationProcess = scanner.nextLine();

                    System.out.print("Enter application link: ");
                    String applicationLink = scanner.nextLine();

                    System.out.print("Enter last updated date (yyyy-mm-dd): ");
                    LocalDate lastUpdated =
                            LocalDate.parse(scanner.nextLine());

                    GovernmentScheme scheme =
                            new GovernmentScheme(
                                    schemeName,
                                    description,
                                    eligibilityCriteria,
                                    benefits,
                                    applicationProcess,
                                    applicationLink,
                                    lastUpdated
                            );

                    schemeRepository.addGovernmentScheme(scheme);

                    System.out.println("Government scheme added successfully.");
                    break;


                case 2:
                    System.out.print("Enter scheme id: ");
                    int schemeId = scanner.nextInt();

                    GovernmentScheme getScheme =
                            schemeRepository.getGovernmentScheme(schemeId);

                    if (getScheme != null) {
                        System.out.println(getScheme);
                    } else {
                        System.out.println("Government scheme not found.");
                    }
                    break;


                case 3:
                    System.out.print("Enter scheme id: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter scheme name: ");
                    String updateSchemeName = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String updateDescription = scanner.nextLine();

                    System.out.print("Enter eligibility criteria: ");
                    String updateEligibilityCriteria = scanner.nextLine();

                    System.out.print("Enter benefits: ");
                    String updateBenefits = scanner.nextLine();

                    System.out.print("Enter application process: ");
                    String updateApplicationProcess = scanner.nextLine();

                    System.out.print("Enter application link: ");
                    String updateApplicationLink = scanner.nextLine();

                    System.out.print("Enter last updated date (yyyy-mm-dd): ");
                    LocalDate updateLastUpdated =
                            LocalDate.parse(scanner.nextLine());

                    GovernmentScheme updateScheme =
                            new GovernmentScheme(
                                    updateSchemeName,
                                    updateDescription,
                                    updateEligibilityCriteria,
                                    updateBenefits,
                                    updateApplicationProcess,
                                    updateApplicationLink,
                                    updateLastUpdated
                            );

                    updateScheme.setSchemeId(updateId);

                    schemeRepository.updateGovernmentScheme(updateScheme);

                    System.out.println("Government scheme updated successfully.");
                    break;


                case 4:
                    System.out.print("Enter scheme id: ");
                    int deleteId = scanner.nextInt();

                    schemeRepository.deleteGovernmentScheme(deleteId);

                    System.out.println("Government scheme deleted successfully.");
                    break;


                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    //Scheme Eligibility
    public static void eligibilityMenu(Scanner scanner) {

        UserRepository userRepository = new UserRepository();
        GovernmentSchemeRepository schemeRepository =
                new GovernmentSchemeRepository();

        EligibilityService eligibilityService =
                new EligibilityService();

        System.out.println("\n--- Eligibility Check ---");

        System.out.print("Enter user id: ");
        int userId = scanner.nextInt();

        System.out.print("Enter scheme id: ");
        int schemeId = scanner.nextInt();

        User user = userRepository.getUser(userId);

        GovernmentScheme scheme =
                schemeRepository.getGovernmentScheme(schemeId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (scheme == null) {
            System.out.println("Government scheme not found.");
            return;
        }

        boolean eligible =
                eligibilityService.cehckEligibility(user, scheme);

        System.out.println("\nUser: " + user.getFullName());
        System.out.println("Scheme: " + scheme.getSchemeName());

        if (eligible) {
            System.out.println("Result: Eligible");
        } else {
            System.out.println("Result: Not Eligible");
        }
    }
}