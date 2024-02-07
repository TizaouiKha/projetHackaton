package com.example.projetHackatonBack.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

@Entity
public class CareTeamParticipant implements Serializable{

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="careTeamId")
    private Long careTeamId;

    @Column(name="memberid")
    private Long memberId;

    @Column(name="role")
    private String role;

    @Column(name="isActive")
    private boolean isActive;

    @Column(name="createdAt")
    private String createdAt;

    @Column(name="updatedAt")
    private String updatedAt;


    public CareTeamParticipant(Long id, Long careTeamId, Long memberId,String role ,boolean isActive,DateTime createdAt, DateTime updatedAt){
        
        this.id = id;
        this.careTeamId = careTeamId;
        this.memberId = memberId;
        this.role = role;
        this.isActive = isActive;
        this.createdAt = createdAt.toString();
        this.updatedAt = updatedAt.toString();
    }
    public CareTeamParticipant(){
        
    }
    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return boolean return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return DateTime return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return DateTime return the updatesAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatesAt the updatesAt to set
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    /**
     * @return Long return the careTeamId
     */
    public Long getCareTeamId() {
        return careTeamId;
    }

    /**
     * @param careTeamId the careTeamId to set
     */
    public void setCareTeamId(Long careTeamId) {
        this.careTeamId = careTeamId;
    }

    /**
     * @return Long return the memberId
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * @return String return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

}
