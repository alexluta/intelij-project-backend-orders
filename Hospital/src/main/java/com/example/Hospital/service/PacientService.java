package com.example.Hospital.service;

import com.example.Hospital.entity.Pacient;

import java.util.List;

public interface PacientService {
    List<Pacient> Pacient();
    Pacient getPacientById(int id);
    Pacient savePacient(Pacient pacient);
    void deletePacient(int id);
    void updatePacient(Pacient pacient);
}
