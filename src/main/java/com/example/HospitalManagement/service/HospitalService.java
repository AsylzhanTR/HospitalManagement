package com.example.HospitalManagement.service;

import com.example.HospitalManagement.entity.Doctor;
import com.example.HospitalManagement.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    private final List<Hospital> hospitals = new ArrayList<>();
    @Autowired
    DoctorService doctorService;

    public Hospital addHospital(Hospital hospital) {
        hospitals.add(hospital);
        return hospital;
    }

    public List<Hospital> getAllHospitals() {
        return hospitals;
    }

    public Hospital getHospitalById(int id) {
        return hospitals.stream()
                .filter(hospital -> hospital.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Doctor> getDoctorsByHospitalId(int id) {
        return hospitals.stream()
                .filter(hospital -> hospital.getId() == id)
                .map(Hospital::getDoctors)
                .findFirst()
                .orElse(new ArrayList<>());
    }

    public boolean assignDoctorToHospital(int hospitalId, int doctorId) {
        Optional<Hospital> hospitalOpt = hospitals.stream().filter(h -> h.getId() == hospitalId).findFirst();
        Optional<Doctor> doctorOpt = doctorService.getDoctorById(doctorId);
        if (hospitalOpt.isPresent() && doctorOpt.isPresent()) {
            hospitalOpt.get().getDoctors().add(doctorOpt.get());
            return true;
        }
        return false;
    }
}
