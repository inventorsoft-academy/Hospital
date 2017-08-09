package com.inventorsoft.hospital.model.hospital;

import com.inventorsoft.hospital.model.people.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Hospital implements HospitalInterface{
    public List <Doctor> doctors;

    public Hospital(){
        doctors=new ArrayList<>();
    }

    @Override
    public boolean addDoctor(String lastName, String firstName, String gender, String specialisation){
        doctors.add(new Doctor(lastName,firstName,gender,specialisation));
        return true;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public String showAllDoctor() {
        StringBuilder builder = new StringBuilder();
        for (Doctor d : doctors) {
            builder.append(d.toString()).append('\n');
        }
        return String.valueOf(builder);
    }


}
