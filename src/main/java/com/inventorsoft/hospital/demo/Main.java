package com.inventorsoft.hospital.demo;

import com.inventorsoft.hospital.model.hospital.Hospital;
import com.inventorsoft.hospital.model.people.Doctor;
import com.inventorsoft.hospital.model.services.FileWork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scan = new Scanner(System.in);
        boolean isReturn = true;
        while (isReturn) {
            System.out.println("Select variant \n 1 - Show all doctor \n 2 - Save system state \n" +
                    "3 - Load system state \n 4 - Exit system");
            int var = scan.nextInt();
            switch (var) {
                case 1:
                    boolean isReturnDoc = true;
                    while (isReturnDoc) {
                        hospital.showAllDoctor();
                        System.out.println("Select variant \n 1 - Add doctor \n 2 - Remove all doctor by first name" +
                                "\n 3 - Remove all doctor by last name \n 4 - Remove all doctor by full name \n" +
                                "5 - Remove all doctor by gender \n 6 - Remove all doctor by specialisation \n" +
                                "7 - Select doctor by number \n 8 - Return previous menu");
                        int varDoc = scan.nextInt();
                        switch (varDoc) {
                            case 1:
                                System.out.println("Enter doctor last name");
                                String lastName = scan.nextLine();
                                System.out.println("Enter doctor first name");
                                String firstName = scan.nextLine();
                                System.out.println("Enter doctor Gender(m-male, f-female)");
                                String gender = scan.nextLine();
                                System.out.println("Enter doctor specialisation");
                                String specialisation = scan.nextLine();
                                System.out.println(hospital.addDoctor(lastName, firstName, gender, specialisation));
                                break;
                            case 2:
                                System.out.println("Enter doctor first name");
                                System.out.println(hospital.removeDoctorByFirstName(scan.nextLine()));
                                break;
                            case 3:
                                System.out.println("Enter doctor last name");
                                System.out.println(hospital.removeDoctorByLastName(scan.nextLine()));
                                break;
                            case 4:

                                System.out.println("Enter doctor first name and last name by enter");
                                System.out.println(hospital.removeDoctorByFullName(scan.nextLine(), scan.nextLine()));
                                break;
                            case 5:
                                System.out.println("Enter doctor Gender(m-male, f-female)");
                                System.out.println(hospital.removeDoctorByGender(scan.nextLine()));
                                break;
                            case 6:
                                System.out.println("Enter doctor specialisation");
                                System.out.println(hospital.removeDoctorBySpecialisation(scan.nextLine()));
                                break;
                            case 7:
                                System.out.println("Enter doctor number");
                                int num = scan.nextInt();
                                Doctor doc = null;
                                for (Doctor d : hospital.doctors) {
                                    if (d.getNum() == num) {
                                        doc = d;
                                        break;
                                    }
                                }
                                boolean isReturnPat = true;
                                while (isReturnPat) {
                                    System.out.println("Select variant \n 1 -");
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
                    FileWork.SaveFile();
                    break;
                case 3:
                    FileWork.LoadFile();
                    break;
                case 4:
                    isReturn = false;
                    break;
                default:
                    System.out.println("Error input!!");
            }
        }
    }
}
