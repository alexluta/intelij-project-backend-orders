package com.example.Hospital.controller;

import com.example.Hospital.entity.Salon;
import com.example.Hospital.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalonController {

    private SalonService salonService;

    @Autowired
    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    @PostMapping("/saveSalon")
    public ResponseEntity<Salon> createSalon(@RequestBody Salon salon) {
        Salon salon1 = salonService.saveSalon(salon);
        return ResponseEntity.status(HttpStatus.CREATED).body(salon);
    }


    @DeleteMapping("/deleteSalon/{id}")
    public ResponseEntity<Void> deleteSalon(@PathVariable Long id) {
        salonService.deleteSalon(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PutMapping("/modifySalon/{id}")
    public ResponseEntity<Void> updateSalon(@PathVariable Long id,@RequestBody Salon salon) {
        salonService.updateSalon(id,salon);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/selectSalon/{id}")
    public ResponseEntity<Salon> getSalon(@PathVariable Long id) {
        Salon salon = salonService.getSalonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(salon);
    }
}
