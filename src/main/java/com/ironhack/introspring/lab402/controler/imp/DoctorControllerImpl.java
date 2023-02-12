package com.ironhack.introspring.lab402.controler.imp;

import com.ironhack.introspring.lab402.controler.dto.DoctorDepartmentDTO;
import com.ironhack.introspring.lab402.controler.dto.DoctorStatusDTO;
import com.ironhack.introspring.lab402.controler.interfaces.DoctorController;
import com.ironhack.introspring.lab402.enums.Status;
import com.ironhack.introspring.lab402.model.Doctor;
import com.ironhack.introspring.lab402.repository.DoctorRepository;
import com.ironhack.introspring.lab402.service.interfaces.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorControllerImpl implements DoctorController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    @GetMapping("/doctors/{employeeId}")
    public Doctor getDoctorById(@PathVariable Long employeeId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(employeeId);
        if(!optionalDoctor.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor not found");
        }else {
            return optionalDoctor.get();
        }
    }

    @GetMapping("/doctors/status/{status}")
    public List<Doctor> findAllByStatus(@PathVariable String status){
      return  doctorRepository.findAllByStatus(Status.valueOf(status.toUpperCase()));
    }
    @GetMapping("/doctors/department/{department}")
    public List<Doctor> findByDepartment(@PathVariable (name = "department")String department){
        return doctorRepository.findAllByDepartment(department);
    }
    @PostMapping("/doctors/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor createDoctor(@RequestBody @Valid Doctor doctor){
        return doctorRepository.save(doctor);
    }
    @PatchMapping("/doctors/{employeeId}/status/new")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDoctorStatus(@PathVariable Long employeeId, @RequestBody @Valid DoctorStatusDTO doctorStatusDTO){
        doctorService.updateStatus(employeeId,doctorStatusDTO);
    }
    @PatchMapping("/doctors/{employeeId}/department/new")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment(@PathVariable Long employeeId, @RequestBody @Valid DoctorDepartmentDTO doctorDepartmentDTO){
        doctorService.updateDepartment(employeeId,doctorDepartmentDTO);
    }
}