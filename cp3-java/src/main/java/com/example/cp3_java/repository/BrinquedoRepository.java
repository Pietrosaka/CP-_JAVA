package com.example.cp3_java.repository;

import com.example.cp3_java.model.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
}
