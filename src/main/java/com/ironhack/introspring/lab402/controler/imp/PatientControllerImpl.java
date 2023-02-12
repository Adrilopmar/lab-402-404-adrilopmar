package com.ironhack.introspring.lab402.controler.imp;

import com.ironhack.introspring.lab402.controler.dto.PatientBirthDTO;
import com.ironhack.introspring.lab402.controler.dto.PatientNameDTO;
import com.ironhack.introspring.lab402.controler.interfaces.PatientController;
import com.ironhack.introspring.lab402.enums.Status;
import com.ironhack.introspring.lab402.model.Patient;
import com.ironhack.introspring.lab402.repository.PatientRepository;
import com.ironhack.introspring.lab402.service.interfaces.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientControllerImpl implements PatientController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.orElse(null);
    }
   @GetMapping("/patients/birthdate")
   public List<Patient> findByBirthRange(@RequestParam LocalDate from, @RequestParam LocalDate to) {
       return  patientRepository.findByDateOfBirthBetween(from,to);
   }
    @GetMapping("/patients/department/{department}")
    public List<Patient> findPatientsByDepartment(@PathVariable String department) {
        return  patientRepository.findAllPatientsByDoctorDepartment(department);
    }
    @GetMapping("/patients/doctor/off")
    public List<Patient> findPatientsByDoctorStatus(){
        return patientRepository.findAllPatientsByDoctorStatus(Status.OFF);
    }
    @PostMapping("/patients/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody @Valid Patient patient){
        return patientRepository.save(patient);
    }

    @PutMapping("/patients/{patientId}/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatient(@PathVariable Long patientId, @RequestParam (name = "name") Optional<String> optionalName, @RequestParam (name = "birth") Optional<LocalDate> optionalBirth){
        if (optionalName.isPresent()){
            patientService.updatePatientName(patientId,optionalName);
        }
        if(optionalBirth.isPresent()){
            patientService.updatePatientBirth(patientId,optionalBirth);
        }
    }
}
