package co.inventorsoft.academy.hospital.web;

import co.inventorsoft.academy.hospital.model.Doctor;
import co.inventorsoft.academy.hospital.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/hospital")
@CrossOrigin(value = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class HospitalController {
    private HospitalService hospitalService;

    @GetMapping(value = "/show-all-doctor",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Doctor> getDoctors(){
        return hospitalService.getDoctor();
    }

    @GetMapping("/{doctorId:\\d+}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer doctorId) {
        return hospitalService.findByIdDoctor(doctorId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @RequestMapping(value = "/create-doctor", method = RequestMethod.POST)
    public @ResponseBody Doctor createDoctor(@RequestParam String lastName,@RequestParam String firstName,
                                                @RequestParam String gender, @RequestParam String specialisation){
        Doctor doctor=new Doctor(lastName,firstName,gender,specialisation);
        return hospitalService.saveDoctor(doctor);
    }

    @RequestMapping(value = "/delete-doctor", method = RequestMethod.DELETE)
    public @ResponseBody String deleteDoctor(@RequestParam int doctorId) {
        return hospitalService.deleteDoctor(doctorId);
    }

}
