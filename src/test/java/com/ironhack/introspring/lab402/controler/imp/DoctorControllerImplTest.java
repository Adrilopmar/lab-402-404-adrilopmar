package com.ironhack.introspring.lab402.controler.imp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DoctorControllerImplTest {

    @Autowired
   private DoctorControllerImpl doctorController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllDoctors_CorrectDataToFind_DoctorsList() {
    assertEquals(6,doctorController.getAllDoctors().size());
    }
}