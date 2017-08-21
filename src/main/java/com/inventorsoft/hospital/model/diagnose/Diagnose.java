package com.inventorsoft.hospital.model.diagnose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Diagnose {

    @NotNull(message = "Description mast be given")
    @Size(min = 3, message = "Min description length mast be 3 characters")
    private String Description;

    private String date;

    public Diagnose(String description) {
        Description = description;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Description = " + Description + ", date = " + date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diagnose diagnose = (Diagnose) o;

        if (Description != null ? !Description.equals(diagnose.Description) : diagnose.Description != null)
            return false;
        return date != null ? date.equals(diagnose.date) : diagnose.date == null;
    }

    @Override
    public int hashCode() {
        int result = Description != null ? Description.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}