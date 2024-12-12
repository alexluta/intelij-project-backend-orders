package com.example.Hospital.controller;

import com.example.Hospital.entity.Asistenta;
import com.example.Hospital.service.AsistentaService;
import org.hibernate.internal.build.AllowNonPortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @DeleteMapping("/deleteAsistenta/{id}")
    public ResponseEntity<Void> deleteAsistenta(@PathVariable Long id) {
        asistentaService.deleteAsistenta(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PutMapping("/modifyAsistenta/{id}")
    public ResponseEntity<Void> updateAsistenta(@PathVariable Long id,@RequestBody Asistenta asistenta) {
        asistentaService.updateAsistenta(id,asistenta);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/selectAsistenta/{id}")
    public ResponseEntity<Asistenta> getAsistenta(@PathVariable Long id) {
        Asistenta asistenta = asistentaService.getAsistentaById(id);
        return ResponseEntity.status(HttpStatus.OK).body(asistenta);
    }

}
