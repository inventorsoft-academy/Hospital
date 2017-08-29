package co.inventorsoft.academy.hospital.web;

import co.inventorsoft.academy.hospital.model.Doctor;
import co.inventorsoft.academy.hospital.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/hospital")
public class HospitalController {
    private HospitalService hospitalService;

    @GetMapping(value = "/show-all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Doctor> getDoctors(){
        return hospitalService.getDoctor();
    }

    @GetMapping(value = "/index.php")
    public ModelAndView showDoctors(final ModelAndView modelAndView) {
        modelAndView.addObject("doctors", hospitalService.getDoctor());
        modelAndView.setViewName("doctors");
        return modelAndView;
    }

    @GetMapping("/{doctorId:\\d+}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer doctorId) {
        return hospitalService.findById(doctorId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Doctor> createDoctorFromUrlEncoded(@ModelAttribute Doctor doctorInfo) {
        final Doctor createdDoctor = hospitalService.saveDoctor(doctorInfo);
        return renderResponseWithLocation(createdDoctor);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Doctor> createDoctorFromJson(@RequestBody Doctor doctorInfo) {
        final Doctor createdDoctor = hospitalService.saveDoctor(doctorInfo);
        return renderResponseWithLocation(createdDoctor);
    }



    private ResponseEntity<Doctor> renderResponseWithLocation(Doctor createdDoctor) {
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", createdDoctor.getNum()))).body(createdDoctor);
    }
}
