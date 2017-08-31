package co.inventorsoft.academy.hospital.repository;

import co.inventorsoft.academy.hospital.doa.DataManager;
import co.inventorsoft.academy.hospital.model.Doctor;
import co.inventorsoft.academy.hospital.model.Hospital;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Repository
public class HospitalDefaultRepository implements HospitalRepository {
    private Hospital storage;
    private DataManager dataManager;

    public HospitalDefaultRepository(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @PostConstruct
    public void init(){
        Hospital hospital=new Hospital();
        dataManager.load(hospital);
        storage=hospital;
    }

    @Override
    public List<Doctor> findAllDoctor() {
        return storage.getDoctors();
    }

    @Override
    public Doctor saveDoctors(Doctor doctor) {
        storage.addDoctor(doctor);
        dataManager.save(storage);
        return doctor;
    }

    @Override
    public String deleteDoctor(Integer id) {
        int i = -1;
        boolean isDeleted = false;
        for (Doctor doctor : storage.getDoctors()) {
            i++;
            if (id.equals(doctor.getNum())) {
                isDeleted = true;
                break;
            }
        }
        if (isDeleted && i > -1) {
            storage.getDoctors().remove(i);
            dataManager.save(storage);
            return "deleteDoctor successful";
        } else {
            return "doctor not found";
        }
    }

    @Override
    public Optional<Doctor> findByIdDoctor(Integer id) {
        return storage.getDoctors().stream().filter(info -> id.equals(info.getNum())).findAny();
    }
}