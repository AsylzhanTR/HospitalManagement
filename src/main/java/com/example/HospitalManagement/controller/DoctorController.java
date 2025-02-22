package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.service.DoctorService;
import com.example.HospitalManagement.entity.Doctor;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    HospitalService hospitalService;

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorService.getDoctorById(id).orElse(null);
    }

    @GetMapping("/doctors/{id}/patients")
    public List<Patient> getPatientsByDoctorId(@PathVariable int id) {
        return doctorService.getPatientsByDoctorId(id);
    }

    @PostMapping("/doctors/{id}/{patientId}")
    public String assignPatientToDoctor(@PathVariable("id") int id, @PathVariable("patientId") int patientId) {
        return doctorService.assignPatientToDoctor(id, patientId);
    }

}
