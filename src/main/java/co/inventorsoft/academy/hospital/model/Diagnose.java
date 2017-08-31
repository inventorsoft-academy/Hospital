package co.inventorsoft.academy.hospital.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@EqualsAndHashCode
public class Diagnose {
    private int id;

    private int patientID;

    @NotNull(message = "Description mast be given")
    @Size(min = 3, message = "Min description length mast be 3 characters")
    private String Description;

    private String date;

    public Diagnose(String description) {
        Description = description;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "patient ID=" + patientID + ", Description= " + Description+ ", date='" + date;
    }
}