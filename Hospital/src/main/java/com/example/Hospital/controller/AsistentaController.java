package com.example.Hospital.controller;

import com.example.Hospital.entity.Asistenta;
import com.example.Hospital.service.AsistentaService;
import org.hibernate.internal.build.AllowNonPortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsistentaController {

    //Http verbs: GET,PUT,DELETE,UPDATE,PATCH
    //Status code: 404 not found, 200 ok, 201 created,

    private AsistentaService asistentaService;

    @Autowired
    public AsistentaController(AsistentaService asistentaService) {
        this.asistentaService = asistentaService;
    }

    @PostMapping("/saveAsistenta")
    public ResponseEntity<Asistenta> createAsistenta(@RequestBody Asistenta asistenta) {
        Asistenta asistenta1 = asistentaService.saveAsistenta(asistenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(asistenta1);
    }

}
