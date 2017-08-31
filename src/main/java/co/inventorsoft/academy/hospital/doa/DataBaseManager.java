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
    public static final String DRIVER="org.postgresql.Driver";

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
        List <Doctor> doctorList=hospital.getDoctors();
        doctorList.removeAll(doctors);
        if (!doctorList.isEmpty()) {
            for (Doctor doctor : doctorList) {
                saveDoctors(doctor);
            }
            return true;
        }else {
            return false;
        }
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
            Class.forName(DRIVER);
            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        (String) resultSet.getObject(2),
                        (String) resultSet.getObject(3),
                        (String) resultSet.getObject(4),
                        (String) resultSet.getObject(5));
                doctor.setNum((int) resultSet.getObject(1));
                doctors.add(doctor);
            }//todo handle
        } catch (ClassNotFoundException | SQLException e) {
             ConsoleUserInterface.log.warn(e.getMessage());
        }
    }

    private void readPatients() {
        try (Statement statement = (DriverManager.getConnection(URL_DB, USER, PASSWORD)).createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM patient")){
            Class.forName(DRIVER);
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
             ConsoleUserInterface.log.warn(e.getMessage());
        }
    }

    private void readDiagnoses() {
        try (Statement statement = (DriverManager.getConnection(URL_DB, USER, PASSWORD)).createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM diagnoses")){
            Class.forName(DRIVER);
            while (resultSet.next()) {
                Diagnose  diagnose= new Diagnose((String) resultSet.getObject(3));
                diagnose.setDate((String)resultSet.getObject(4));
                diagnose.setPatientID((int)resultSet.getObject(2));
                diagnose.setId((int)resultSet.getObject(1));
                diagnoses.add(diagnose);
            }
        } catch (ClassNotFoundException | SQLException e) {
             ConsoleUserInterface.log.warn(e.getMessage());
        }
    }

    private void saveDoctors(Doctor doctor) {
        try (Connection connection = DriverManager.getConnection(URL_DB, USER, PASSWORD)) {
            Class.forName(DRIVER);

            String s = "INSERT INTO doctor(id, last_name, first_name, gendeer, specialisation) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(s);

            statement.setInt(1, doctor.getNum());
            statement.setString(2, doctor.getLastName());
            statement.setString(3, doctor.getFirstName());
            statement.setString(4, doctor.getGender());
            statement.setString(5, doctor.getSpecialisation());

        } catch (ClassNotFoundException | SQLException e) {
            ConsoleUserInterface.log.warn(e.getMessage());
        }
    }
    private void saveDiagnoses(Diagnose diagnose){

    }
    private void savePatients(Patient patient){

    }
}
