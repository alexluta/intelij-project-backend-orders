package com.example.Hospital.repository;

import com.example.Hospital.entity.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<Medic, Long> {
}
