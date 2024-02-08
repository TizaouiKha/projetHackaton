package com.example.projetHackatonBack.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetHackatonBack.model.Practitioner;

public interface PractitionerInterface  extends JpaRepository<Practitioner, Long>{
    
    // Optional<Practitioner> findPractitionerByCareTeamPractitionerId(Long careTeamPractitionerId);

}