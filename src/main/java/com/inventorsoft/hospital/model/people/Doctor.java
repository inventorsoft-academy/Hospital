package com.inventorsoft.hospital.model.people;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialisation;
    private List<Patient> patients;

    public List<Patient> getPatients() {
        return patients;
    }

    public Doctor(String lastName, String firstName, String gender, String specialisation) {
        super(lastName, firstName, gender);
        this.specialisation = specialisation;
        patients = new ArrayList<>();
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public boolean addPatient(String firstName, String lastName, String gender, String DOB, String bloodType) {
        patients.add(new Patient(firstName, lastName, gender, DOB, bloodType));
        return true;
    }

    public boolean removePatientByFirstName(String firstName) {
        int k = 0;
        for (Patient p : patients) {
            if (p.firstName.equals(firstName)) {
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public boolean removePatientByLastName(String lastName) {
        int k = 0;
        for (Patient p : patients) {
            if (p.lastName.equals(lastName)) {
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public boolean removePatientByFullName(String firstName, String lastName) {
        int k = 0;
        for (Patient p : patients) {
            if (p.firstName.equals(firstName) && p.lastName.equals(lastName)) {
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public boolean removePatientByGender(String gender) {
        int k = 0;
        for (Patient p : patients) {
            if (p.getGender().equals(gender)) {
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public boolean removePatientByBloodType(String bloodType) {
        int k = 0;
        for (Patient p : patients) {
            if (p.getBloodType().equals(bloodType)) {
                patients.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public String showAllPatient() {
        StringBuilder builder = new StringBuilder();
        for (Patient p : patients) {
            builder.append(p.toString()).append('\n');
        }
        return String.valueOf(builder);
    }

    @Override
    public String toString() {
        return "num=" + num + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender +
                ", specialisation='" + specialisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (specialisation != null ? !specialisation.equals(doctor.specialisation) : doctor.specialisation != null)
            return false;
        return patients != null ? patients.equals(doctor.patients) : doctor.patients == null;
    }

    @Override
    public int hashCode() {
        int result = specialisation != null ? specialisation.hashCode() : 0;
        result = 31 * result + (patients != null ? patients.hashCode() : 0);
        return result;
    }
}