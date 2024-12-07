package com.example.Hospital.controller;

import com.example.Hospital.entity.Salon;
import com.example.Hospital.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
