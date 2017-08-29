package co.inventorsoft.academy.hospital.repository;

import co.inventorsoft.academy.hospital.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HospitalDefaultRepository implements HospitalRepository {
    private static final List<Doctor> storage;

    static {
        storage = new ArrayList<>();

        storage.add(new Doctor("ytyt", "oip-]-", "MALE", "erhytrt"));
        storage.add(new Doctor("ytiyui", "t6745", "MALE", "ty54ytry"));
        storage.add(new Doctor("4355", "esfdfgb", "FEMALE", "trytrutyu"));
        storage.add(new Doctor("rttuyi", "5464ty", "MALE", "tutyutyu"));
        storage.add(new Doctor("po[-", "yrty56", "FEMALE", "tutrurtu"));
    }

    @Override
    public List<Doctor> findAll() {
        return storage;
    }

    @Override
    public Doctor save(Doctor doctor) {
        storage.add(doctor);
        return doctor;
    }

    @Override
    public Optional<Doctor> findById(Integer id) {
        return storage.stream().filter(info -> id.equals(info.getNum())).findAny();
    }
}