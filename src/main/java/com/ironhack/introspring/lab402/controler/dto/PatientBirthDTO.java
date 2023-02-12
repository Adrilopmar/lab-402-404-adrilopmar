package com.ironhack.introspring.lab402.controler.dto;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class PatientBirthDTO {
    @NotEmpty
    private LocalDate dateOfBirth;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
