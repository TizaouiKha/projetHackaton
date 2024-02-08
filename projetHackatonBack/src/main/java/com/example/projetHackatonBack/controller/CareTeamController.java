package com.example.projetHackatonBack.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetHackatonBack.model.CareTeam;
import com.example.projetHackatonBack.service.CareTeamService;



@RestController
@RequestMapping("/careTeam")

@CrossOrigin(origins = "http://localhost:8080")
public class CareTeamController {
    private CareTeamService careTeamService;
    
    public CareTeamController(CareTeamService careTeamService){
        this.careTeamService = careTeamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CareTeam>> getAllCareTeam() {
        List<CareTeam> careTeams = careTeamService.findAllCareTeams();
        return new ResponseEntity<>(careTeams, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public  ResponseEntity <CareTeam> getCareTeamByIdSubject(@PathVariable("id") Long id){
       CareTeam careTeam = careTeamService.findCareTeamBySubjectId(id);
        return new ResponseEntity<>(careTeam, HttpStatus.OK);
    }
    }
    

