package com.inventorsoft.hospital.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventorsoft.hospital.model.hospital.Hospital;

import java.io.File;
import java.io.IOException;

public class JSONFormat implements HospitalServices {
    private final static File file = new File("src\\main\\resources\\data.json");

    @Override
    public boolean save(final Hospital hospital) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, hospital);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean load(Hospital hospital) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            hospital=mapper.readValue(file, Hospital.class);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
