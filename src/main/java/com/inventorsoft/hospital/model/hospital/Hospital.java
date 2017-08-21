package com.inventorsoft.hospital.model.hospital;

import com.inventorsoft.hospital.model.person.Doctor;
import com.inventorsoft.hospital.services.ConsoleUserInterface;
import com.inventorsoft.hospital.services.MyValidator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;

public class Hospital implements MyValidator{
    private List<Doctor> doctors;

    public Hospital() {
        doctors = new ArrayList<>();
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public boolean addDoctor(String lastName, String firstName, String gender, String specialisation) {
        Doctor doctor = new Doctor(lastName, firstName, gender, specialisation);

        if (validate(doctor, Validation.buildDefaultValidatorFactory().getValidator())){
            doctors.add(doctor);
            ConsoleUserInterface.log.info("User add new doctor: last name" + lastName
                    + " first name " + firstName
                    + " gender " + gender
                    + " specialisation " + specialisation);
            return true;
        }else {
            return false;
        }
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

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}