package com.example.projetHackatonBack.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetHackatonBack.model.Practitioner;


public interface PractitionerInterface  extends JpaRepository<Practitioner, Long>{
    
 Optional<Practitioner> findById(Long id);

}  