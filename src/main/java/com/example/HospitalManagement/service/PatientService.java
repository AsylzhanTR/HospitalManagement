package com.example.HospitalManagement.service;

import com.example.HospitalManagement.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final List<Patient> patients = new ArrayList<>();

    public Patient addPatient(Patient patient) {
        patients.add(patient);
        return patient;
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Optional<Patient> getPatientById(int id) {
        return patients.stream()
                .filter(patient -> patient.getId() == id)
                .findFirst();
    }
}
