package com.example.Hospital.controller;

import com.example.Hospital.entity.Medic;
import com.example.Hospital.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
