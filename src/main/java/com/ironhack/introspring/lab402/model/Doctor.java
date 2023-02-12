package com.ironhack.introspring.lab402.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.introspring.lab402.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @Column(name = "employee_id")
    private Long employeeId;
    @NotEmpty
    private String department;
    @NotEmpty
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Patient> patientList;

    public Doctor() {
    }

    public Doctor(String department, String name, Status status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
