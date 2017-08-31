package co.inventorsoft.academy.hospital.service;

import co.inventorsoft.academy.hospital.model.Doctor;
import co.inventorsoft.academy.hospital.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DefaultHospitalService implements HospitalService {
    private HospitalRepository hospitalRepository;

    @Override
    public List<Doctor> getDoctor() {
        return hospitalRepository.findAllDoctor();
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return hospitalRepository.saveDoctors(doctor);
    }

    @Override
    public String deleteDoctor(final Integer id) {
        return hospitalRepository.deleteDoctor(id);
    }

    @Override
    public Optional<Doctor> findByIdDoctor(Integer id) {
        return hospitalRepository.findByIdDoctor(id);
    }
}
