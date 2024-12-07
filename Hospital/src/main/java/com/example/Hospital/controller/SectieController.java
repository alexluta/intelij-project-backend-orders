package com.example.Hospital.controller;

import com.example.Hospital.entity.Salon;
import com.example.Hospital.entity.Sectie;
import com.example.Hospital.service.SalonService;
import com.example.Hospital.service.SectieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectieController {

    private SectieService sectieService;

    @Autowired
    public SectieController(SectieService sectieService) {
        this.sectieService = sectieService;
    }

    @PostMapping("/saveSectie")
    public ResponseEntity<Sectie> createSectie(@RequestBody Sectie sectie) {
        Sectie sectie1 = sectieService.saveSectie(sectie);
        return ResponseEntity.status(HttpStatus.CREATED).body(sectie);
    }

}
