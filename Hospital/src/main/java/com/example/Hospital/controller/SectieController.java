package com.example.Hospital.controller;

import com.example.Hospital.entity.Sectie;
import com.example.Hospital.service.SectieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/deleteSectie/{id}")
    public ResponseEntity<Void> deleteSectie(@PathVariable Long id) {
        sectieService.deleteSectie(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PutMapping("/modifySectie/{id}")
    public ResponseEntity<Void> updateSectie(@PathVariable Long id,@RequestBody Sectie sectie) {
        sectieService.updateSectie(id,sectie);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/selectSectie/{id}")
    public ResponseEntity<Sectie> getSectie(@PathVariable Long id) {
        Sectie sectie = sectieService.getSectieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(sectie);
    }

}
