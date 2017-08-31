package co.inventorsoft.academy.hospital.service;

import co.inventorsoft.academy.hospital.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface HospitalService {

    List<Doctor> getDoctor();

    Doctor saveDoctor(final Doctor doctor);

    String deleteDoctor(final Integer id);

    Optional<Doctor> findByIdDoctor(final Integer id);
}
