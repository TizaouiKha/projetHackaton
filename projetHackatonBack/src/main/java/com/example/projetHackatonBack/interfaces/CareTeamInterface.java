package com.example.projetHackatonBack.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetHackatonBack.model.CareTeam;


public interface CareTeamInterface  extends JpaRepository<CareTeam, Long>{

    CareTeam findBySubjectId(Long subjectId);
    
    CareTeam findCareTeamById(Long subjectId);
    
}