package com.ironhack.introspring.lab402.controler.dto;

import jakarta.validation.constraints.NotEmpty;

public class PatientNameDTO {
    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
