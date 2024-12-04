package com.example.Hospital.service;

import com.example.Hospital.entity.Tratament;

import java.util.List;

public interface TratamentService {
    List<Tratament> Tratament();
    Tratament getTratamentById(int id);
    Tratament saveTratament(Tratament tratament);
    void deleteTratament(int id);
    void updateTratament(Tratament tratament);
}
