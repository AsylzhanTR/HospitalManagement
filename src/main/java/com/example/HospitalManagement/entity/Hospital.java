package com.example.HospitalManagement.entity;

import java.util.List;

public class Hospital {
    private int id;
    private String name;
    private String address;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }



    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "Hospital" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", doctors=" + doctors +
                ", patients=" + patients;
    }
}
