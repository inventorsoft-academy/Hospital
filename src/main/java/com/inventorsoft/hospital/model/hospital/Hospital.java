package com.inventorsoft.hospital.model.hospital;

import com.inventorsoft.hospital.model.person.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Hospital{
    private List <Doctor> doctors;

    public Hospital(){
        doctors=new ArrayList<>();
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public boolean addDoctor(String lastName, String firstName, String gender, String specialisation){
        doctors.add(new Doctor(lastName,firstName,gender,specialisation));
        return true;
    }

    public boolean removeDoctorByFirstName(String firstName) {
        int k = 0;
        for (Doctor p : doctors) {
            if (p.getFirstName().equals(firstName)) {
                doctors.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public boolean removeDoctorByLastName(String lastName) {
        int k = 0;
        for (Doctor p : doctors) {
            if (p.getLastName().equals(lastName)) {
                doctors.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public boolean removeDoctorByFullName(String firstName, String lastName) {
        int k = 0;
        for (Doctor p : doctors) {
            if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
                doctors.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public boolean removeDoctorByGender(String gender) {
        int k = 0;
        for (Doctor p : doctors) {
            if (p.getGender().equals(gender)) {
                doctors.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public boolean removeDoctorBySpecialisation(String specialisation) {
        int k = 0;
        for (Doctor p : doctors) {
            if (p.getSpecialisation().equals(specialisation)) {
                doctors.remove(p);
                k++;
            }
        }
        return k > 0;
    }

    public String showAllDoctor() {
        StringBuilder builder = new StringBuilder();
        for (Doctor d : doctors) {
            builder.append(d.toString()).append('\n');
        }
        return String.valueOf(builder);
    }
}