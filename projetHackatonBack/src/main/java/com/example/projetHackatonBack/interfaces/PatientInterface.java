package com.example.projetHackatonBack.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetHackatonBack.model.Patient;

public interface PatientInterface  extends JpaRepository<Patient, Long>{
    

}