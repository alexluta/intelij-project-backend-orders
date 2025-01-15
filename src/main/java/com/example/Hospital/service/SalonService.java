package com.example.Hospital.service;

import com.example.Hospital.entity.Salon;

import java.util.List;

public interface SalonService {
    List<Salon> Salon();
    Salon getSalonById(int id);
    Salon saveSalon(Salon salon);
    void deleteSalon(int id);
    void updateSalon(Salon salon);
}
