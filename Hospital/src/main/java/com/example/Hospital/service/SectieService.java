package com.example.Hospital.service;

import com.example.Hospital.entity.Sectie;

import java.util.List;

public interface SectieService {
    List<Sectie> Sectie();
    Sectie getSalonById(int id);
    Sectie saveSectie(Sectie sectie);
    void deleteSectie(int id);
    void updateSectie(Sectie sectie);
}
