package com.ironhack.introspring.lab402.service.impl;

import com.ironhack.introspring.lab402.controler.dto.DoctorDepartmentDTO;
import com.ironhack.introspring.lab402.controler.dto.DoctorStatusDTO;
import com.ironhack.introspring.lab402.enums.Status;
import com.ironhack.introspring.lab402.model.Doctor;
import com.ironhack.introspring.lab402.repository.DoctorRepository;
import com.ironhack.introspring.lab402.service.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public void updateStatus(Long employeeId, DoctorStatusDTO doctorStatusDTO) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(employeeId);
        if(optionalDoctor.isPresent()){
            optionalDoctor.get().setStatus(doctorStatusDTO.getDoctorStatus());
            doctorRepository.save(optionalDoctor.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor not found");
        }
    }
    public void updateDepartment(Long employeeId, DoctorDepartmentDTO doctorDepartmentDTO) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(employeeId);
        if(optionalDoctor.isPresent()){
            optionalDoctor.get().setDepartment(doctorDepartmentDTO.getDoctorDepartment());
            doctorRepository.save(optionalDoctor.get());
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor not found");
        }
    }
}
