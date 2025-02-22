package com.example.HospitalManagement.service;

import com.example.HospitalManagement.entity.Doctor;
import com.example.HospitalManagement.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final List<Doctor> doctors = new ArrayList<Doctor>();
    @Autowired
    PatientService patientService;
    public Doctor addDoctor(Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public Optional<Doctor> getDoctorById(int id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId() == id)
                .findFirst();
    }

    public List<Patient> getPatientsByDoctorId(int id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId() == id)
                .map(Doctor::getAssignedPatients)
                .findFirst()
                .orElse(new ArrayList<>());
    }

    public String assignPatientToDoctor(int doctorId, int patientId) {
        Optional<Doctor> doctorOpt = doctors.stream().filter(d -> d.getId() == doctorId).findFirst();
        Optional<Patient> patientOpt = patientService.getPatientById(patientId);
        if (doctorOpt.isPresent() && patientOpt.isPresent()) {
            doctorOpt.get().getAssignedPatients().add(patientOpt.get());
            return "assign patient successfully";
        }
        return "Error";
    }
}
