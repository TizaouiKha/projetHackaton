package com.example.projetHackatonBack.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetHackatonBack.model.CareTeamParticipant;
import com.example.projetHackatonBack.service.CareTeamParticipantService;



@RestController
@RequestMapping("/careTeamParticipant")

@CrossOrigin(origins = "http://localhost:8080")
public class CareTeamParticipantController {
    private CareTeamParticipantService careTeamParticipantService;
    
    public CareTeamParticipantController(CareTeamParticipantService careTeamParticipantService){
        this.careTeamParticipantService = careTeamParticipantService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CareTeamParticipant>> getAllCareTeamParticipant() {
        List<CareTeamParticipant> careTeamParticipants = careTeamParticipantService.findAllCareTeamParticipants();
        return new ResponseEntity<>(careTeamParticipants, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public  ResponseEntity <CareTeamParticipant> getCareTeamParticipantByIdCareTeam(@PathVariable("id") Long id){
       CareTeamParticipant careTeamParticipant = careTeamParticipantService.findCareTeamParticipantByIdPractitioner(id);
        return new ResponseEntity<>(careTeamParticipant, HttpStatus.OK);
    }
    }
    

