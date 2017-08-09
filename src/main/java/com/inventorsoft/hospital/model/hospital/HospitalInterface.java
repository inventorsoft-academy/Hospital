package com.inventorsoft.hospital.model.hospital;

public interface HospitalInterface {
    boolean addDoctor(String lastName, String firstName, String gender, String specialisation);

    boolean removeDoctorByFirstName(String firstName);
    boolean removeDoctorByLastName(String lastName);
    boolean removeDoctorByFullName(String firstName, String lastName);
    boolean removeDoctorByGender(String gender);
    boolean removeDoctorBySpecialisation(String specialisation);

    String showAllDoctor();
}
