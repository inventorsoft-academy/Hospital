package co.inventorsoft.academy.hospital.model;

import co.inventorsoft.academy.hospital.service.CustomValidator;
import co.inventorsoft.academy.hospital.ui.ConsoleUserInterface;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode
public class Hospital {
    private List<Doctor> doctors;

    public Hospital() {
        doctors = new ArrayList<>();
    }

    public boolean addDoctor(Doctor doctor) {
        if (new CustomValidator().validate(doctor, Validation.buildDefaultValidatorFactory().getValidator())) {
            for (Doctor doc : doctors) {
                if (doctor.equals(doc)) {
                    return false;
                }
            }
            doctors.add(doctor);
            return true;
        }
        return false;
    }

    public List<Doctor> getDoctors() {
        try {
            return doctors;
        }catch (NullPointerException e){
            ConsoleUserInterface.log.error(e.getMessage());
            List<Doctor> doc=new  ArrayList<Doctor>();
            doc.add(new Doctor("1","1","MALE","devg"));
            return doc;
        }
    }

    public Optional<Doctor> findByID(Integer id){
        return doctors.stream().filter(info -> id.equals(info.getNum())).findAny();
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}