package com.inventorsoft.hospital.model.diagnose;

import java.time.LocalDateTime;

public class Diagnose {
    private String Description;
    private LocalDateTime date;

    public Diagnose(String description) {
        Description = description;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Diagnose Description: " + Description + '\n' +
                ", date = " + date + '\n';
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
