package com.example.projetHackatonBack.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetHackatonBack.model.Patient;
import com.example.projetHackatonBack.service.PatientService;


@RestController
@RequestMapping("/patient")

@CrossOrigin(origins = "http://localhost:8080")
public class PatientController {
    private PatientService patientService;
    
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllpatient() {
        List<Patient> patients = patientService.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public  ResponseEntity <Patient> getPatientById(@PathVariable("id") Long id){
       Patient patient = patientService.findPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
    
}
