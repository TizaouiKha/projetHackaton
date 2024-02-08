package com.example.projetHackatonBack.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetHackatonBack.model.CareTeamParticipant;


public interface CareTeamParticipantInterface  extends JpaRepository<CareTeamParticipant, Long>{

    CareTeamParticipant  findByMemberId(Long memberId);

}