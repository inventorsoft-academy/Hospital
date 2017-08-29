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
        return hospitalRepository.findAll();
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return hospitalRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> findById(Integer id) {
        return hospitalRepository.findById(id);
    }
}
