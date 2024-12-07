package com.example.Hospital.controller;

import com.example.Hospital.entity.Tratament;
import com.example.Hospital.service.TratamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TratamentController {

    private TratamentService tratamentService;

    @Autowired
    public TratamentController(TratamentService tratamentService){this.tratamentService=tratamentService;}

    public ResponseEntity<Tratament> createTratament(@RequestBody Tratament tratament){
        Tratament tratament1 = tratamentService.saveTratament(tratament);
        return ResponseEntity.status(HttpStatus.CREATED).body(tratament);
    }
}
