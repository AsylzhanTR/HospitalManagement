package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.entity.Doctor;
import com.example.HospitalManagement.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.HospitalManagement.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceptionController {

@Autowired
PatientService patientService;

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
    return patientService.addPatient(patient);
}

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id).orElse(null);
    }
}
