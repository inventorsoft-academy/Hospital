package com.inventorsoft.hospital.model.people;

import com.inventorsoft.hospital.model.diagnose.Diagnose;

import java.util.ArrayList;
import java.util.List;

public class Patient extends People {
    private String DOB;
    BloodType bloodType;
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

    public String getBloodType() {
        return bloodType.toString();
    }

    boolean addDiagnoses(String diagnosesDescription) {
        diagnoses.add(new Diagnose(diagnosesDescription));
        return true;
    }

    public String showAllDiadnoses() {
        StringBuilder builder = new StringBuilder();
        for (Diagnose d : diagnoses) {
            builder.append(d.toString());
        }
        return String.valueOf(builder);
    }


    @Override
    public String toString() {

        return "Patient" +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + '\n' +
                ", DOB='" + DOB + '\'' + '\n' +
                ", bloodType=" + bloodType +
                ", gender=" + gender;
    }
}
