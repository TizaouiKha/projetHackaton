package com.example.projetHackatonBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetHackatonBack.exception.UserNotFoundException;
import com.example.projetHackatonBack.interfaces.PatientInterface;
import com.example.projetHackatonBack.model.Patient;

@Service
public class PatientService {
    private PatientInterface patientInterface;
    
    @Autowired
    public PatientService(PatientInterface patientInterface){
        this.patientInterface = patientInterface;
    }
    
    public List<Patient> findAllPatients(){
        return patientInterface.findAll();
    }
    public Patient findPatientById(Long id){
        return patientInterface.findPatientById(id).orElseThrow(()-> new UserNotFoundException("Patient by id "+ id));
    }
}