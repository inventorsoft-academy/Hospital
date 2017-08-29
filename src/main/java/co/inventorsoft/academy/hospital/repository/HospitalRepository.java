package co.inventorsoft.academy.hospital.repository;

import co.inventorsoft.academy.hospital.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository {

    List<Doctor> findAll();

    Doctor save(final Doctor doctor);

    Optional<Doctor> findById(final Integer id);
}
