package com.inventorsoft.hospital.model.people;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends People implements DoctorInterface{
    private String specialisation;
    private List<Patient> patients;

    public Doctor(String lastName, String firstName, String gender, String specialisation) {
        super(lastName, firstName, gender);
        this.specialisation = specialisation;
        patients = new ArrayList<>();
    }

    @Override
    public boolean addPatient(String firstName, String lastName, String gender, String DOB, String bloodType) {
        patients.add(new Patient(firstName,lastName,gender,DOB,bloodType));
        return true;
    }

    @Override
    public boolean removePatientByFirstName(String firstName) {
        int k=0;
        for(Patient p:patients){
            if(p.firstName.equals(firstName)){
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    @Override
    public boolean removePatientByLastName(String lastName) {
        int k=0;
        for(Patient p:patients){
            if(p.lastName.equals(lastName)){
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    @Override
    public boolean removePatientByFullName(String firstName, String lastName) {
        int k=0;
        for(Patient p:patients){
            if(p.firstName.equals(firstName) && p.lastName.equals(lastName)){
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    @Override
    public boolean removePatientByGender(String gender) {
        int k=0;
        for(Patient p:patients){
            if(p.gender.equals(gender)){
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    @Override
    public boolean removePatientByBloodType(String bloodType) {
        int k=0;
        for(Patient p:patients){
            if(p.bloodType.equals(bloodType)){
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    @Override
    public String showAllPatient() {
        StringBuilder builder=new StringBuilder();
        for(Patient p:patients){
            builder.append(p.toString());
        }
        return String.valueOf(builder);
    }
}
