package co.inventorsoft.academy.hospital.doa;

import co.inventorsoft.academy.hospital.model.Diagnose;
import co.inventorsoft.academy.hospital.model.Doctor;
import co.inventorsoft.academy.hospital.model.Hospital;
import co.inventorsoft.academy.hospital.model.Patient;
import co.inventorsoft.academy.hospital.ui.ConsoleUserInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager implements DataManager {

    private static final String URL_DB ="jdbc:postgresql://localhost:5432/hospital";
    private static final String USER="postgres";
    private static final String PASSWORD="postgres";

    private List<Doctor>  doctors;
    private List<Patient> patients;
    private List<Diagnose> diagnoses;

    public DataBaseManager(){
        doctors=new ArrayList<>();
        patients=new ArrayList<>();
        diagnoses=new ArrayList<>();
    }

    @Override
    public boolean save(Hospital hospital) {
        return false;
    }

    @Override
    public boolean load(Hospital hospital) {
        readDoctors();
        readDiagnoses();
        readPatients();
        for(Patient patient: patients){
            for (Diagnose diagnose: diagnoses){
                if (diagnose.getPatientID()==patient.getNum()){
                    patient.addDiagnoses(diagnose);
                }
            }
        }

        for(Doctor doctor: doctors){
            for (Patient patient: patients){
                if (patient.getDoctorID()==doctor.getNum()){
                    doctor.addPatient(patient);
                }
            }
        }
        hospital.setDoctors(doctors);
        return true;
    }

    private void readDoctors() {
        try (Statement statement = (DriverManager.getConnection(URL_DB, USER, PASSWORD)).createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM doctor")){
            Class.forName("org.postgresql.Driver");
            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        (String) resultSet.getObject(2),
                        (String) resultSet.getObject(3),
                        (String) resultSet.getObject(4),
                        (String) resultSet.getObject(5));
                doctor.setNum((int) resultSet.getObject(1));
                doctors.add(doctor);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // ConsoleUserInterface.log.warn(e.getMessage());
            e.printStackTrace();
        }
    }

    private void readPatients() {
        try (Statement statement = (DriverManager.getConnection(URL_DB, USER, PASSWORD)).createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM patient")){
            Class.forName("org.postgresql.Driver");
            while (resultSet.next()) {
                Patient patient = new Patient(
                        (String) resultSet.getObject(3),
                        (String) resultSet.getObject(4),
                        (String) resultSet.getObject(5),
                        (String) resultSet.getObject(6),
                        (String) resultSet.getObject(7));
                patient.setNum((int) resultSet.getObject(1));
                patient.setDoctorID((int) resultSet.getObject(2));
                patients.add(patient);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // ConsoleUserInterface.log.warn(e.getMessage());
            e.printStackTrace();
        }
    }

    private void readDiagnoses() {
        try (Statement statement = (DriverManager.getConnection(URL_DB, USER, PASSWORD)).createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM diagnoses")){
            Class.forName("org.postgresql.Driver");
            while (resultSet.next()) {
                Diagnose  diagnose= new Diagnose((String) resultSet.getObject(3));
                diagnose.setDate((String)resultSet.getObject(4));
                diagnose.setPatientID((int)resultSet.getObject(2));
                diagnose.setId((int)resultSet.getObject(1));
                diagnoses.add(diagnose);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // ConsoleUserInterface.log.warn(e.getMessage());
            e.printStackTrace();
        }
    }
}
