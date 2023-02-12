package com.ironhack.introspring.lab402.repository;

import com.ironhack.introspring.lab402.enums.Status;
import com.ironhack.introspring.lab402.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findAllByStatus(Status status);
    List<Doctor> findAllByDepartment(String department);
}
