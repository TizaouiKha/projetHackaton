package com.example.projetHackatonBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetHackatonBack.interfaces.CommunicationInterface;
import com.example.projetHackatonBack.model.Communication;

@Service
public class CommunicationService {
    private CommunicationInterface communicationInterface;
    
    @Autowired
    public CommunicationService(CommunicationInterface communicationInterface){
        this.communicationInterface = communicationInterface;
    }
    
    public List<Communication> findAllCommunications(){
        return communicationInterface.findAll();
    }
    public List<Communication> findCommunicationsByIdCareTeam(Long idCareTeam){
        return communicationInterface.findByIdCareTeam(idCareTeam);
    }
}