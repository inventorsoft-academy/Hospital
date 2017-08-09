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
}
