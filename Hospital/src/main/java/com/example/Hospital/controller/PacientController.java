package com.example.Hospital.controller;


import com.example.Hospital.entity.Pacient;
import com.example.Hospital.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PacientController {

    private PacientService pacientService;

    @Autowired
    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }


    @PostMapping("/savePacient")
    public ResponseEntity<Pacient> createPacient(@RequestBody Pacient pacient) {
        Pacient pacient1 = pacientService.savePacient(pacient);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacient);
    }


    @DeleteMapping("/deletePacient/{id}")
    public ResponseEntity<Void> deletePacien(@PathVariable Long id) {
        pacientService.deletePacient(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PutMapping("/modifyPacient/{id}")
    public ResponseEntity<Void> updatePacient(@PathVariable Long id,@RequestBody Pacient pacient) {
        pacientService.updatePacient(id,pacient);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/selectPacient/{id}")
    public ResponseEntity<Pacient> getPacient(@PathVariable Long id) {
        Pacient pacient = pacientService.getPacientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pacient);
    }
}
