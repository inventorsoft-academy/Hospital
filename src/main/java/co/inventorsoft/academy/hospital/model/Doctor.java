package co.inventorsoft.academy.hospital.model;

import co.inventorsoft.academy.hospital.service.CustomValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Validation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Doctor extends Person {

    @NotNull(message = "specialisation mast by given")
    @Size(min=3,message = "specialisation mas be min size 3 characters ")
    private String specialisation;

    private List<Patient> patients;

    public Doctor(String lastName, String firstName, String gender, String specialisation) {
        super(lastName, firstName, gender);
        this.specialisation = specialisation;
        patients = new ArrayList<>();
    }

    public boolean addPatient(Patient patient) {
        if (new CustomValidator().validate(patient, Validation.buildDefaultValidatorFactory().getValidator())) {
            for (Patient pat : patients) {
                if (patient.equals(pat)) {
                    return false;
                }
            }
            patient.setDoctorID(num);
            patients.add(patient);
            return true;
        }
        return false;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "id= " + num +
                ", last name= " + lastName +
                ", first name= " + firstName +
                ", specialisation= " + specialisation +
                ", gender= " + gender;
    }
}