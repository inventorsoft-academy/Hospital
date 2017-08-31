package co.inventorsoft.academy.hospital.doa;

import co.inventorsoft.academy.hospital.model.Diagnose;
import co.inventorsoft.academy.hospital.model.Doctor;
import co.inventorsoft.academy.hospital.model.Hospital;
import co.inventorsoft.academy.hospital.model.Patient;
import co.inventorsoft.academy.hospital.ui.ConsoleUserInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager implements DataManager {

    private static final File DOCTORS_FILE =new File("src\\main\\resources\\doctors.txt");
    private static final File PATIENTS_FILE =new File("src\\main\\resources\\patients.txt");
    private static final File DIAGNOSES_FILE =new File("src\\main\\resources\\diagnoses.txt");

    @Override
    public boolean save(final Hospital hospital) {
        try{
            BufferedWriter doctorsWriter = new BufferedWriter(new FileWriter(DOCTORS_FILE,false));
            BufferedWriter patientsWriter = new BufferedWriter(new FileWriter(PATIENTS_FILE,false));
            BufferedWriter diagnosesWriter = new BufferedWriter(new FileWriter(DIAGNOSES_FILE,false));

            for (Doctor doctor:hospital.getDoctors()){
                doctorsWriter.write(doctor.toString());
                doctorsWriter.append('\n');
                for (Patient patient:doctor.getPatients() ){
                    patientsWriter.write(patient.toString());
                    patientsWriter.append('\n');
                    for (Diagnose diagnose: patient.getDiagnoses()){
                        diagnosesWriter.write(diagnose.toString());
                        diagnosesWriter.append('\n');
                    }
                }
            }
            ConsoleUserInterface.log.info("File saveDoctors");

            doctorsWriter.close();
            patientsWriter.close();
            diagnosesWriter.close();
            return true;
        }catch (IOException e){
            ConsoleUserInterface.log.error("File not saveDoctors"+'\n'+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean load(Hospital hospital) {
        try{
            BufferedReader doctorsReader = new BufferedReader(new FileReader(DOCTORS_FILE));
            BufferedReader patientsReader = new BufferedReader(new FileReader(PATIENTS_FILE));
            BufferedReader diagnosesReader = new BufferedReader(new FileReader(DIAGNOSES_FILE));

            List<String> doctors;
            List <String> doctorsField;

            List<String> patients=new ArrayList<>();
            List <String> patientsField=new ArrayList<>();

            List<String> diagnoses=new ArrayList<>();
            List <String> diagnosesField=new ArrayList<>();

            int countDoctor = 0;
            int countPatient = 0;
            int countDiagnoses = 0;

            String line;
            while ((line = doctorsReader.readLine()) != null) {
                doctors=new ArrayList<>();
                doctors.add(line);
                String[] doc = line.split(",");
                doctorsField=new ArrayList<>();
                for (String aDoc : doc) {
                    String[] dField = aDoc.split("=");
                    try {
                        doctorsField.add(dField[1]);
                    }catch (IndexOutOfBoundsException e){
                        ConsoleUserInterface.log.info(e.getMessage());
                    }
                }
                hospital.addDoctor(new Doctor(doctorsField.get(1),doctorsField.get(2),
                        doctorsField.get(4),doctorsField.get(3)));
                try {
                    hospital.getDoctors().get(countDoctor).setNum(Integer.parseInt(doctorsField.get(0)));
                }catch (NumberFormatException e){
                    ConsoleUserInterface.log.info("Non integer "+e.getMessage());
                    hospital.getDoctors().get(countDoctor).setNum(1);
                }
                countDoctor++;
            }
            while ((line = patientsReader.readLine()) != null) {
                patients.add(line);
                String[] pat = line.split(",");
                for (String aPat : pat) {
                    String[] dField = aPat.split("=");
                    patientsField.add(dField[1]);
                }
                try {
                    for (Doctor doctor : hospital.getDoctors()) {
                        int id = Integer.parseInt(patientsField.get(0));
                        if (doctor.getNum() == id) {
                            Patient patient=new Patient(patientsField.get(3),patientsField.get(2),
                                    patientsField.get(6),patientsField.get(4),patientsField.get(5));
                            patient.setNum(Integer.parseInt(patientsField.get(0)));
                            patient.setDoctorID(Integer.parseInt(patientsField.get(1)));
                            doctor.addPatient(patient);
                        }
                    }
                }catch (NumberFormatException e){
                    ConsoleUserInterface.log.info("Non integer "+e.getMessage());
                }
                countPatient++;
            }
//            while ((line = diagnosesReader.readLine()) != null) {
//                diagnoses.add(line);
//                String[] diagnose = line.split(",");
//                for (int i = 0; i < diagnose.length; i++) {
//                    String[] dField = diagnose[i].split("=");
//                    diagnose[i] = dField[1];
//                }
//                int patientId;
//                try {
//
//                }
//                for (Doctor doctor:hospital.getDoctors()){
//                    for (Patient patient:doctor.getPatients()){
//                        if (patient.getNum()= )
//                    }
//                }
//            }

            ConsoleUserInterface.log.info("File read");

            doctorsReader.close();
            patientsReader.close();
            diagnosesReader.close();
            return true;
        }catch (IOException e){
            ConsoleUserInterface.log.error("File not read"+'\n'+e.getMessage());
            return false;
        }
    }
}