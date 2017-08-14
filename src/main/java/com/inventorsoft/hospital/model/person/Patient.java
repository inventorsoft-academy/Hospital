package com.inventorsoft.hospital.model.person;

import com.inventorsoft.hospital.model.diagnose.Diagnose;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private String DOB;
    private BloodType bloodType;
    private List<Diagnose> diagnoses;

    Patient(String firstName, String lastName, String gender, String DOB, String bloodType) {
        super(lastName, firstName, gender);
        this.DOB = DOB;
        switch (bloodType) {
            case "1+":
                this.bloodType = BloodType.I_P;
                break;
            case "1-":
                this.bloodType = BloodType.I_N;
                break;
            case "2+":
                this.bloodType = BloodType.II_P;
                break;
            case "2-":
                this.bloodType = BloodType.II_N;
                break;
            case "3+":
                this.bloodType = BloodType.III_P;
                break;
            case "3-":
                this.bloodType = BloodType.III_N;
                break;
            case "4+":
                this.bloodType = BloodType.IV_P;
                break;
            default:
                this.bloodType = BloodType.IV_N;
        }
        diagnoses = new ArrayList<>();
    }

    public List<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public boolean addDiagnoses(String diagnosesDescription) {
        diagnoses.add(new Diagnose(diagnosesDescription));
        return true;
    }

    public String showAllDiagnoses() {
        StringBuilder builder = new StringBuilder();
        for (Diagnose d : diagnoses) {
            builder.append(d.toString());
        }
        return String.valueOf(builder);
    }

    @Override
    public String toString() {
        return "num=" + num +
                ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender +
                ", DOB='" + DOB + ", bloodType=" + bloodType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (DOB != null ? !DOB.equals(patient.DOB) : patient.DOB != null) return false;
        if (bloodType != patient.bloodType) return false;
        return diagnoses != null ? diagnoses.equals(patient.diagnoses) : patient.diagnoses == null;
    }

    @Override
    public int hashCode() {
        int result = DOB != null ? DOB.hashCode() : 0;
        result = 31 * result + (bloodType != null ? bloodType.hashCode() : 0);
        result = 31 * result + (diagnoses != null ? diagnoses.hashCode() : 0);
        return result;
    }
}
