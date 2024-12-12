package com.example.Hospital.controller;

import com.example.Hospital.entity.Tratament;
import com.example.Hospital.service.TratamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TratamentController {

    private TratamentService tratamentService;

    @Autowired
    public TratamentController(TratamentService tratamentService){this.tratamentService=tratamentService;}

    public ResponseEntity<Tratament> createTratament(@RequestBody Tratament tratament){
        Tratament tratament1 = tratamentService.saveTratament(tratament);
        return ResponseEntity.status(HttpStatus.CREATED).body(tratament);
    }
    @DeleteMapping("/deleteTratament/{id}")
    public ResponseEntity<Void> deleteTratament(@PathVariable Long id) {
        tratamentService.deleteTratament(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/modifyTratament/{id}")
    public ResponseEntity<Void> updateTratament(@PathVariable Long id,@RequestBody Tratament tratament) {
        tratamentService.updateTratament(id,tratament);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/selectTratament/{id}")
    public ResponseEntity<Tratament> getATratament(@PathVariable Long id) {
        Tratament tratament = tratamentService.getTratamentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(tratament);
    }
}
