package com.ironhack.introspring.lab402.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;
    private String name;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @ManyToOne
//  (fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "admitted_by")
    private Doctor doctor;

    public Patient() {
    }

    public Patient(String name, LocalDate dateOfBirth, Doctor doctor) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.doctor = doctor;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
