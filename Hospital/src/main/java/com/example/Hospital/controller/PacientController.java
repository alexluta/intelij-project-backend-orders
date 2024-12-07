package com.example.Hospital.controller;


import com.example.Hospital.entity.Pacient;
import com.example.Hospital.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
