package co.inventorsoft.academy.hospital.model;

import co.inventorsoft.academy.hospital.service.CustomValidator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Validation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Patient extends Person {

    private int doctorID;

    @NotNull(message = "DOB mast be given")
    @Size(min = 3, message = "Min DOB length mast be 3 characters")
    private String DOB;

    private BloodType bloodType;
    private List<Diagnose> diagnoses;

    public Patient(String lastName, String firstName, String gender, String DOB, String bloodType) {
        super(lastName, firstName, gender);
        this.DOB = DOB;
        switch (bloodType) {
            case "I_P":
                this.bloodType = BloodType.I_P;
                break;
            case "I_N":
                this.bloodType = BloodType.I_N;
                break;
            case "II_P":
                this.bloodType = BloodType.II_P;
                break;
            case "II_N":
                this.bloodType = BloodType.II_N;
                break;
            case "III_P":
                this.bloodType = BloodType.III_P;
                break;
            case "III_N":
                this.bloodType = BloodType.III_N;
                break;
            case "IV_P":
                this.bloodType = BloodType.IV_P;
                break;
            default:
                this.bloodType = BloodType.IV_N;
        }
        diagnoses = new ArrayList<>();
    }

    public boolean addDiagnoses(Diagnose diagnose) {
        if (new CustomValidator().validate(diagnose, Validation.buildDefaultValidatorFactory().getValidator())) {
            for (Diagnose diagnos : diagnoses) {
                if (diagnose.equals(diagnos)) {
                    return false;
                }
            }
            diagnose.setPatientID(num);
            diagnoses.add(diagnose);
            return true;
        }
        return false;
    }

    public List<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public void setDiagnoses(List<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @Override
    public String toString() {
        return "id =" + num +
                ", doctorID=" + doctorID +
                ", lastName=" + lastName +
                ", firstName'" + firstName +
                ", DOB=" + DOB +
                ", bloodType=" + bloodType +
                ", gender=" + gender;
    }

    private enum BloodType {
        I_P,
        II_P,
        III_P,
        IV_P,
        I_N,
        II_N,
        III_N,
        IV_N
    }
}