package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.entity.Doctor;
import com.example.HospitalManagement.entity.Hospital;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.service.DoctorService;
import com.example.HospitalManagement.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @Autowired
    DoctorService doctorService;

    @PostMapping("/hospitals")
    public Hospital addHospital(@RequestBody Hospital hospital) {
        return hospitalService.addHospital(hospital);
    }

    @GetMapping("/hospitals")
    public List<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }

    @GetMapping("/hospitals/{id}")
    public Hospital getHospitalById(@PathVariable int id) {
        return hospitalService.getHospitalById(id);
    }

    @GetMapping("/hospitals/{id}/doctors")
    public List<Doctor> getDoctorsByHospital(@PathVariable int id) {
        return hospitalService.getDoctorsByHospitalId(id);
    }

    @PostMapping("/hospitals/{id}/{doctorId}")
    public boolean assignDoctorToHospital(@PathVariable int id, @PathVariable int doctorId) {
        return hospitalService.assignDoctorToHospital(id, doctorId);
    }
}
