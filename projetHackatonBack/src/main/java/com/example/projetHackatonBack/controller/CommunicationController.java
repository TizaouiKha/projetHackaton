package com.example.projetHackatonBack.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetHackatonBack.model.Communication;
import com.example.projetHackatonBack.service.CommunicationService;




@RestController
@RequestMapping("/communication")

@CrossOrigin(origins = "http://localhost:8080")
public class CommunicationController {
    private CommunicationService communicationService;
    
    public CommunicationController(CommunicationService communicationService){
        this.communicationService = communicationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Communication>> getAllCommunication() {
        List<Communication> communications = communicationService.findAllCommunications();
        return new ResponseEntity<>(communications, HttpStatus.OK);
    }
    
    @GetMapping("/find/{idCareTeam}")
    public  ResponseEntity <List<Communication>> 
    getCommunicationByIdCareTeam(@PathVariable("idCareTeam") Long idCareTeam){
        List<Communication> communications = communicationService.findCommunicationsByIdCareTeam(idCareTeam);
        return new ResponseEntity<>(communications, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Communication> addCommunication(@RequestBody Communication communication) {
        Communication newCommunication = communicationService.addCommunication(communication);
        return new ResponseEntity<>(newCommunication, HttpStatus.CREATED);
    }
    
    }
    

