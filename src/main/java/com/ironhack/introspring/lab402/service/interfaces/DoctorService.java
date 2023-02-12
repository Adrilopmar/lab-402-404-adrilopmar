package com.ironhack.introspring.lab402.service.interfaces;

import com.ironhack.introspring.lab402.controler.dto.DoctorDepartmentDTO;
import com.ironhack.introspring.lab402.controler.dto.DoctorStatusDTO;

public interface DoctorService {

    void updateStatus(Long employeeId, DoctorStatusDTO doctorStatusDTO);
    void updateDepartment(Long employeeId, DoctorDepartmentDTO doctorDepartmentDTO);

}
