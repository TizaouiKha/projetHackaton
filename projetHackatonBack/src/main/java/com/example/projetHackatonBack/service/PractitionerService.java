package com.example.projetHackatonBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetHackatonBack.interfaces.PractitionerInterface;
import com.example.projetHackatonBack.model.Practitioner;

@Service
public class PractitionerService {
    private PractitionerInterface practitionerInterface;
    
    @Autowired
    public PractitionerService(PractitionerInterface practitionerInterface){
        this.practitionerInterface = practitionerInterface;
    }
    
    public List<Practitioner> findAllPractitioners(){
        return practitionerInterface.findAll();
    }
}