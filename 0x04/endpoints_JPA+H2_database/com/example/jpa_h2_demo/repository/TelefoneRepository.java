package com.example.jpa_h2_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jpa_h2_demo.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    // ...existing code...
}