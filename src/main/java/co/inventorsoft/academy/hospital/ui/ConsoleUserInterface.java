package co.inventorsoft.academy.hospital.ui;

import co.inventorsoft.academy.hospital.doa.DataWork;
import co.inventorsoft.academy.hospital.doa.FileWork;
import co.inventorsoft.academy.hospital.doa.JSONFormat;
import co.inventorsoft.academy.hospital.model.Diagnose;
import co.inventorsoft.academy.hospital.model.Doctor;
import co.inventorsoft.academy.hospital.model.Hospital;
import co.inventorsoft.academy.hospital.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ConsoleUserInterface {

    public static final Logger log = LogManager.getLogger(ConsoleUserInterface.class);

    public void run() {
        log.info("Run program");

        Hospital hospital = new Hospital();
        Scanner scan = new Scanner(System.in);
        DataWork hospitalServices;
        System.out.println("Enter format to work program");
        System.out.println("Select variant \n 1 - txt \n 2 - json");
        int formatVar = scan.nextInt();
        switch (formatVar) {
            case 1:
                hospitalServices = new FileWork();
                log.info("User select txt format for working");
                break;
            default:
                hospitalServices = new JSONFormat();
                log.info("User select json format for working");
        }
        boolean b = hospitalServices.load(hospital);
        System.out.println(b);
        log.info("User load data by result " + b);
        boolean isReturn = true;
        while (isReturn) {
            System.out.println("Select variant \n" +
                    "1 - Show all doctor \n" +
                    "2 - Exit system");
            int var = scan.nextInt();
            switch (var) {
                case 1:
                    log.info("user run program");
                    boolean isReturnDoc = true;
                    while (isReturnDoc) {
                        for (Doctor doctor:hospital.getDoctors()) {
                            System.out.println(doctor.toString());
                        }
                        System.out.println("Select variant \n" +
                                "1 - Add doctor \n" +

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
                                System.out.println(hospital.addDoctor(new Doctor(lastName, firstName, gender, specialisation)));
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
                                    log.info("User selected doctor by number " + num);
                                    boolean isReturnPat = true;
                                    while (isReturnPat) {
                                        assert doc != null;
                                        for (Patient patient:doc.getPatients()) {
                                            System.out.println(patient.toString());
                                        }
                                        System.out.println("Select variant \n" +
                                                "1 - Add patient \n" +

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
                                                scan.nextLine();
                                                String DOB = scan.nextLine();
                                                System.out.println("Enter patient blood type");
                                                String bloodType = scan.next();
                                                System.out.println(doc.addPatient(new Patient(lastNamePat, firstNamePat, genderPat, DOB, bloodType)));
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
                                                    log.info("User selected patient by number " + num);
                                                    boolean isReturnDiag = true;
                                                    while (isReturnDiag) {
                                                        assert pat != null;
                                                        for(Diagnose diagnose: pat.getDiagnoses()) {
                                                            System.out.println(diagnose.toString());
                                                        }
                                                        System.out.println("Select variant \n" +
                                                                "1 - Add diagnose \n" +
                                                                "2 - Return previous menu");
                                                        int varDiag = scan.nextInt();
                                                        switch (varDiag) {
                                                            case 1:
                                                                System.out.println("Diagnose description ");
                                                                scan.nextLine();
                                                                String description = scan.nextLine();
                                                                System.out.println(pat.addDiagnoses(new Diagnose(description)));
                                                                break;
                                                            case 2:
                                                                isReturnDiag = false;
                                                                log.info("User  exit previous menu");
                                                                break;
                                                            default:
                                                                System.out.println("Error input!!");
                                                                log.warn("User  error input num " + varDiag);
                                                        }
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("You enter failed data");
                                                    log.warn("User enter failed data");
                                                }
                                                break;
                                            case 8:
                                                isReturnPat = false;
                                                log.info("User  exit previous menu");
                                                break;
                                            default:
                                                System.out.println("Error input!!");
                                                log.warn("User  error input num " + varPat);
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("You enter failed data");
                                    log.warn("User enter failed data");
                                }
                                break;
                            case 8:
                                isReturnDoc = false;
                                log.info("User  exit previous menu");
                                break;
                            default:
                                System.out.println("Error input!!");
                                log.warn("User  error input num " + varDoc);
                        }
                    }
                    break;
                case 2:
                    isReturn = false;
                    log.info("User  exit program");
                    break;
                default:
                    System.out.println("Error input!!");
                    log.warn("User  error input num " + var);
            }
        }
        boolean b1 = hospitalServices.save(hospital);
        System.out.println(b1);

        log.info("Finish program");
    }
}