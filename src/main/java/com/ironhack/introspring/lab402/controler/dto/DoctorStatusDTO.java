package com.ironhack.introspring.lab402.controler.dto;

import com.ironhack.introspring.lab402.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class DoctorStatusDTO {

    @Enumerated(EnumType.STRING)
    private Status doctorStatus;

    public Status getDoctorStatus() {
        return doctorStatus;
    }
    public void setDoctorStatus(Status doctorStatus) {
        this.doctorStatus = doctorStatus;
    }
}
