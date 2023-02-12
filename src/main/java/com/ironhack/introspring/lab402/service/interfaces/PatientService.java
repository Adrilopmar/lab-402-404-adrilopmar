package com.ironhack.introspring.lab402.service.interfaces;

import com.ironhack.introspring.lab402.controler.dto.PatientBirthDTO;

import java.time.LocalDate;
import java.util.Optional;

public interface PatientService {
    void updatePatientName(Long patientId, Optional<String> name);
    void updatePatientBirth(Long patientId, Optional<LocalDate> birth);
}
