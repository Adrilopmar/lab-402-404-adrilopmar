package com.ironhack.introspring.lab402.service.impl;

import com.ironhack.introspring.lab402.controler.dto.PatientBirthDTO;
import com.ironhack.introspring.lab402.controler.dto.PatientNameDTO;
import com.ironhack.introspring.lab402.model.Patient;
import com.ironhack.introspring.lab402.repository.PatientRepository;
import com.ironhack.introspring.lab402.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    public void updatePatientName(Long patientId, Optional<String> name) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()){
            PatientNameDTO patientNameDTO = new PatientNameDTO();
            patientNameDTO.setName(name.get());
            optionalPatient.get().setName(patientNameDTO.getName());
            patientRepository.save(optionalPatient.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient not found");
        }
    }

    public void updatePatientBirth(Long patientId, Optional<LocalDate> birth) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if(optionalPatient.isPresent()){
            PatientBirthDTO patientBirthDTO = new PatientBirthDTO();
            patientBirthDTO.setDateOfBirth(birth.get());
            optionalPatient.get().setDateOfBirth(patientBirthDTO.getDateOfBirth());
            patientRepository.save(optionalPatient.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient not found");
        }
    }
}
