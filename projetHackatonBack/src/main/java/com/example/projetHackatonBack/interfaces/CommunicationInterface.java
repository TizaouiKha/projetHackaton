package com.example.projetHackatonBack.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetHackatonBack.model.Communication;

public interface CommunicationInterface  extends JpaRepository<Communication, Long>{

    List<Communication> findByIdCareTeam(Long idCareTeam);
    

}