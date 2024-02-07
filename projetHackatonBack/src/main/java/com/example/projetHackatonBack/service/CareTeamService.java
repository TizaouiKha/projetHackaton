package com.example.projetHackatonBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetHackatonBack.interfaces.CareTeamInterface;
import com.example.projetHackatonBack.model.CareTeam;

@Service
public class CareTeamService {
    private CareTeamInterface careTeamInterface;
    
    @Autowired
    public CareTeamService(CareTeamInterface careTeamInterface){
        this.careTeamInterface = careTeamInterface;
    }
    
    public List<CareTeam> findAllCareTeams(){
        return careTeamInterface.findAll();
    }
    public CareTeam findCareTeamById(Long id){
        return careTeamInterface.findCareTeamById(id);
    }
    public CareTeam findCareTeamBySubjectId(Long id){
        return careTeamInterface.findBySubjectId(id);
    }
}