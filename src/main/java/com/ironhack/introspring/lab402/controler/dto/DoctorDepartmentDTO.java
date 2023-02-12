package com.ironhack.introspring.lab402.controler.dto;

import jakarta.validation.constraints.NotEmpty;

public class DoctorDepartmentDTO {
    @NotEmpty
    private String doctorDepartment;

    public String getDoctorDepartment() {
        return doctorDepartment;
    }

    public void setDoctorDepartment(String doctorDepartment) {
        this.doctorDepartment = doctorDepartment;
    }
}
