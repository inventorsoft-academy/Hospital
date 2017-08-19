package com.inventorsoft.hospital.model.services;

import com.inventorsoft.hospital.model.hospital.Hospital;
import com.inventorsoft.hospital.model.person.Doctor;
import com.inventorsoft.hospital.model.person.Patient;
import com.inventorsoft.hospital.model.person.Person;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleUserInterface {

    private static final Logger log = Logger.getLogger(ConsoleUserInterface.class);

    public void run() {
        Person.setN(loadID());
        Hospital hospital = new Hospital();
        Scanner scan = new Scanner(System.in);
        HospitalServices hospitalServices;
        System.out.println("Enter format to work program");
        System.out.println("Select variant \n 1 - txt \n 2 - json");
        int formatVar=scan.nextInt();
        switch (formatVar) {
            case 1:
                hospitalServices = new FileWork();
                break;
            default:
                hospitalServices = new JSONFormat();
        }
        System.out.println(hospitalServices.load(hospital));
        boolean isReturn = true;
        while (isReturn) {
            System.out.println("Select variant \n" +
                    "1 - Show all doctor \n" +
                    "2 - Exit system");
            int var = scan.nextInt();
//            log.info("user select "+var);
            switch (var) {
                case 1:
                    boolean isReturnDoc = true;
                    while (isReturnDoc) {
                        System.out.println(hospital.showAllDoctor());
                        System.out.println("Select variant \n" +
                                "1 - Add doctor \n" +
                                "2 - Remove all doctor by first name \n" +
                                "3 - Remove all doctor by last name \n" +
                                "4 - Remove all doctor by full name \n" +
                                "5 - Remove all doctor by gender \n" +
                                "6 - Remove all doctor by specialisation \n" +
                                "7 - Select doctor by number \n" +
                                "8 - Return previous menu");
                        int varDoc = scan.nextInt();
                        switch (varDoc) {
                            case 1:
                                System.out.println("Enter doctor last name");
                                String lastName = scan.next();
                                System.out.println("Enter doctor first name");
                                String firstName = scan.next();
                                System.out.println("Enter doctor Gender(m-male, f-female)");
                                String gender = scan.next();
                                System.out.println("Enter doctor specialisation");
                                String specialisation = scan.next();
                                System.out.println(hospital.addDoctor(lastName, firstName, gender, specialisation));
                                break;
                            case 2:
                                System.out.println("Enter doctor first name");
                                String firstNameByRemove = scan.next();
                                System.out.println(hospital.removeDoctorByFirstName(firstNameByRemove));
                                break;
                            case 3:
                                System.out.println("Enter doctor last name");
                                String lastNameByRemove = scan.next();
                                System.out.println(hospital.removeDoctorByLastName(lastNameByRemove));
                                break;
                            case 4:

                                System.out.println("Enter doctor first name and last name by enter");
                                String firstNameByRemove2 = scan.next();
                                String lastNameByRemove2 = scan.next();
                                System.out.println(hospital.removeDoctorByFullName(firstNameByRemove2,
                                        lastNameByRemove2));
                                break;
                            case 5:
                                System.out.println("Enter doctor Gender(MALE, FEMALE)");
                                String genderByRemove = scan.next();
                                System.out.println(hospital.removeDoctorByGender(genderByRemove));
                                break;
                            case 6:
                                System.out.println("Enter doctor specialisation");
                                String specialisationByRemove = scan.next();
                                System.out.println(hospital.removeDoctorBySpecialisation(specialisationByRemove));
                                break;
                            case 7:
                                try {
                                    System.out.println("Enter doctor number");
                                    int num = scan.nextInt();
                                    Doctor doc = null;
                                    for (Doctor d : hospital.getDoctors()) {
                                        if (d.getNum() == num) {
                                            doc = d;
                                            break;
                                        }
                                    }
                                    boolean isReturnPat = true;
                                    while (isReturnPat) {
                                        assert doc != null;
                                        System.out.println(doc.showAllPatient());
                                        System.out.println("Select variant \n" +
                                                "1 - Add patient \n" +
                                                "2 - Remove all patient by first name \n" +
                                                "3 - Remove all patient by last name \n" +
                                                "4 - Remove all patient by full name \n" +
                                                "5 - Remove all patient by gender \n" +
                                                "6 - Remove all patient by blood type \n" +
                                                "7 - Select patient by number \n" +
                                                "8 - Return previous menu");
                                        int varPat = scan.nextInt();
                                        switch (varPat) {
                                            case 1:
                                                System.out.println("Enter patient last name");
                                                String lastNamePat = scan.next();
                                                System.out.println("Enter patient first name");
                                                String firstNamePat = scan.next();
                                                System.out.println("Enter patient Gender(m-male, f-female)");
                                                String genderPat = scan.next();
                                                System.out.println("Enter patient DOB");
                                                String DOB = scan.next();
                                                System.out.println("Enter patient blood type");
                                                String bloodType = scan.next();
                                                System.out.println(doc.addPatient(lastNamePat, firstNamePat, genderPat, DOB, bloodType));
                                                break;
                                            case 2:
                                                System.out.println("Enter patient first name");
                                                String firstNameByRemovePat = scan.next();
                                                System.out.println(doc.removePatientByFirstName(firstNameByRemovePat));
                                                break;
                                            case 3:
                                                System.out.println("Enter patient last name");
                                                String lastNameByRemovePat = scan.next();
                                                System.out.println(doc.removePatientByLastName(lastNameByRemovePat));
                                                break;
                                            case 4:

                                                System.out.println("Enter patient first name and last name by enter");
                                                String firstNameByRemovePat2 = scan.next();
                                                String lastNameByRemovePat2 = scan.next();
                                                System.out.println(doc.removePatientByFullName(firstNameByRemovePat2, lastNameByRemovePat2));
                                                break;
                                            case 5:
                                                System.out.println("Enter patient Gender(MALE, FEMALE)");
                                                String genderByRemovePat = scan.next();
                                                System.out.println(doc.removePatientByGender(genderByRemovePat));
                                                break;
                                            case 6:
                                                System.out.println("Enter patient blood type");
                                                String bloodTypeByRemove = scan.next();
                                                System.out.println(doc.removePatientByBloodType(bloodTypeByRemove));
                                                break;
                                            case 7:
                                                try {
                                                    System.out.println("Enter patient number");
                                                    int numPat = scan.nextInt();
                                                    Patient pat = null;
                                                    for (Patient p : doc.getPatients()) {
                                                        if (p.getNum() == numPat) {
                                                            pat = p;
                                                            break;
                                                        }
                                                    }
                                                    boolean isReturnDiag = true;
                                                    while (isReturnDiag) {
                                                        assert pat != null;
                                                        System.out.println(pat.showAllDiagnoses());
                                                        System.out.println("Select variant \n" +
                                                                "1 - Add diagnose \n" +
                                                                "2 - Return previous menu");
                                                        int varDiag = scan.nextInt();
                                                        switch (varDiag) {
                                                            case 1:
                                                                System.out.println("Diagnose description ");
                                                                String description = scan.next();
                                                                pat.addDiagnoses(description);
                                                                break;
                                                            case 2:
                                                                isReturnDiag = false;
                                                                break;
                                                            default:
                                                                System.out.println("Error input!!");
                                                        }
                                                    }
                                                }catch (Exception e){
                                                    System.out.println("You enter failed data");
                                                }
                                                break;
                                            case 8:
                                                isReturnPat = false;
                                                break;
                                            default:
                                                System.out.println("Error input!!");
                                        }
                                    }
                                }catch (Exception e){
                                    System.out.println("You enter failed data");
                                }
                                break;
                            case 8:
                                isReturnDoc = false;
                                break;
                            default:
                                System.out.println("Error input!!");
                        }
                    }
                    break;
                case 2:
                    isReturn = false;
                    break;
                default:
                    System.out.println("Error input!!");
            }
        }
        System.out.println(hospitalServices.save(hospital));
    }

    private static int loadID() {
        final File file = new File("src\\main\\resources\\data.txt");
        String line;
        int result=0;
        try {
            BufferedReader reader =new BufferedReader(new FileReader(file));
            while ((line=reader.readLine()) !=null) {
                result = Integer.parseInt(line);
            }
            reader.close();
        } catch (IOException | NumberFormatException ex) {
            result = 0;
        }
        return result;
    }
}