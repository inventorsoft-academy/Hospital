package com.inventorsoft.hospital.model.people;

public interface DoctorInterface {

    boolean addPatient(String firstName, String lastName, String gender, String DOB, String bloodType);

    boolean removePatientByFirstName(String firstName);
    boolean removePatientByLastName(String lastName);
    boolean removePatientByFullName(String firstName, String lastName);
    boolean removePatientByGender(String gender);
    boolean removePatientByBloodType(String bloodType);

    String showAllPatient();
}
