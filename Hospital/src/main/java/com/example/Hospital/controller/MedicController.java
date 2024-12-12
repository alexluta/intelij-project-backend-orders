package com.example.Hospital.controller;

import com.example.Hospital.entity.Medic;
import com.example.Hospital.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicController {

    private MedicService medicService;

    @Autowired
    public MedicController(MedicService medicService) {
        this.medicService = medicService;
    }

    @PostMapping("/saveMedic")
    public ResponseEntity<Medic> createMedic(@RequestBody Medic medic) {
        Medic medic1 = medicService.saveMedic(medic);
        return ResponseEntity.status(HttpStatus.CREATED).body(medic);
    }


    @DeleteMapping("/deleteMedic/{id}")
    public ResponseEntity<Void> deleteMedic(@PathVariable Long id) {
        medicService.deleteMedic(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PutMapping("/modifyMedic/{id}")
    public ResponseEntity<Void> updateMedic(@PathVariable Long id,@RequestBody Medic medic) {
        medicService.updateMedic(id,medic);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/selectMedic/{id}")
    public ResponseEntity<Medic> getMedic(@PathVariable Long id) {
        Medic medic = medicService.getMedicById(id);
        return ResponseEntity.status(HttpStatus.OK).body(medic);
    }
}
