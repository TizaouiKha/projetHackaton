package com.example.projetHackatonBack.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetHackatonBack.model.Practitioner;
import com.example.projetHackatonBack.service.PractitionerService;


@RestController
@RequestMapping("/practitioner")

@CrossOrigin(origins = "http://localhost:8080")
public class PractitionerController {
    private PractitionerService practitionerService;
    
    public PractitionerController(PractitionerService practitionerService){
        this.practitionerService = practitionerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Practitioner>> getAllPractitioner() {
        List<Practitioner> practitioners = practitionerService.findAllPractitioners();
        return new ResponseEntity<>(practitioners, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public  ResponseEntity <Practitioner> getPractitionerById(@PathVariable("id") Long id){
       Practitioner practitioner = practitionerService.findPractitionerById(id);
        return new ResponseEntity<>(practitioner, HttpStatus.OK);
    }
    
}
