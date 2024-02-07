package com.example.projetHackatonBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetHackatonBack.interfaces.CareTeamParticipantInterface;
import com.example.projetHackatonBack.model.CareTeamParticipant;

@Service
public class CareTeamParticipantService {
    private CareTeamParticipantInterface careTeamParticipantInterface;
    
    @Autowired
    public CareTeamParticipantService(CareTeamParticipantInterface careTeamParticipantInterface){
        this.careTeamParticipantInterface = careTeamParticipantInterface;
    }
    
    public List<CareTeamParticipant> findAllCareTeamParticipants(){
        return careTeamParticipantInterface.findAll();
    }
    public CareTeamParticipant findCareTeamByIdPractitioner(Long id){
        return careTeamParticipantInterface.findByMemberId(id);
    }
}