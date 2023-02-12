package com.ironhack.introspring.lab402.repository;

import com.ironhack.introspring.lab402.enums.Status;
import com.ironhack.introspring.lab402.model.Patient;
import jakarta.persistence.Enumerated;
import org.hibernate.type.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByDateOfBirthBetween(LocalDate from, LocalDate to);

    List<Patient> findAllPatientsByDoctorDepartment(String department);
    List<Patient> findAllPatientsByDoctorStatus(Status status);
}
