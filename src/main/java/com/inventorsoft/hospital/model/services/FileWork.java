package com.inventorsoft.hospital.model.services;

import com.inventorsoft.hospital.model.diagnose.Diagnose;
import com.inventorsoft.hospital.model.hospital.Hospital;
import com.inventorsoft.hospital.model.person.Doctor;
import com.inventorsoft.hospital.model.person.Patient;

import java.io.File;
import java.io.*;

public class FileWork implements HospitalServices {
    private final static File file = new File("src\\main\\resources\\data.txt");

    @Override
    public boolean save(final Hospital hospital) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            for (Doctor d : hospital.getDoctors()) {
                writer.write("|");
                writer.write(d.toString());
                writer.write('\n');
                for (Patient p : d.getPatients()) {
                    writer.write("\\");
                    writer.write(p.toString());
                    writer.write('\n');
                    for (Diagnose diagnose : p.getDiagnoses()) {
                        writer.write("/");
                        writer.write(diagnose.toString());
                        writer.write('\n');
                    }
                }
            }
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean load(Hospital hospital) {
        try {
            BufferedReader reader =new BufferedReader(new FileReader(file));
            String line;
            int countDoctor=0;
            int countPatient=0;
            int countDiagnoses=0;
            while ((line=reader.readLine()) !=null) {
                char[] c = line.toCharArray();
                if (c[0] == '|') {
                    countPatient=0;
                    String[] doctors = line.split(",");
                    for (int i = 0; i < doctors.length; i++) {
                        String[] dField = doctors[i].split("=");
                        doctors[i] = dField[1];
                    }
                    hospital.addDoctor(doctors[2], doctors[1], ("Gender." + doctors[3]), doctors[4]);
                    hospital.getDoctors().get(countDoctor).setNum(Integer.parseInt(doctors[0]));
                    countDoctor++;
                } else if (c[0] == '\\') {
                    countDiagnoses=0;
                    String[] patients = line.split(",");
                    for (int i = 0; i < patients.length; i++) {
                        String[] dField = patients[i].split("=");
                        patients[i] = dField[1];
                    }
                    hospital.getDoctors().get(countDoctor-1).addPatient(patients[1], patients[2],
                            ("Gender." + patients[3]), patients[4],("BloodType." + patients[5]));
                    hospital.getDoctors().get(countDoctor-1).getPatients().get(countPatient).
                            setNum(Integer.parseInt(patients[0]));
                    countPatient++;

                } else if (c[0] == '/') {
                    String[] diagnoses = line.split(",");
                    for (int i = 0; i < diagnoses.length; i++) {
                        String[] dField = diagnoses[i].split("=");
                        diagnoses[i] = dField[1];
                    }
                    hospital.getDoctors().get(countDoctor-1).getPatients().get(countPatient-1).
                            addDiagnoses(diagnoses[0]);
                    hospital.getDoctors().get(countDoctor-1).getPatients().get(countPatient-1).getDiagnoses().
                            get(countDiagnoses).setDate(diagnoses[1]);
                    countDiagnoses++;
                }
            }
            reader.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}