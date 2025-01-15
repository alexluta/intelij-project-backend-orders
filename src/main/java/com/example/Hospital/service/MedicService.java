package com.example.Hospital.service;

import com.example.Hospital.entity.Medic;

import java.util.List;

public interface MedicService {
    List<Medic> getAllMedic();
    Medic getMedicById(int id);
    Medic saveMedic(Medic medic);
    void deleteMedic(int id);
    void updateMedic(Medic medic);
}
