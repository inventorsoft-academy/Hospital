package co.inventorsoft.academy.hospital.repository;

import co.inventorsoft.academy.hospital.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository {

    List<Doctor> findAllDoctor();

    Doctor saveDoctors(final Doctor doctor);

    String deleteDoctor(final Integer id);

    Optional<Doctor> findByIdDoctor(final Integer id);
}
