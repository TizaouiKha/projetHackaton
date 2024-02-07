package com.example.projetHackatonBack.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

@Entity
public class CareTeam implements Serializable{

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="subjectId")
    private Long subjectId;

    @Column(name="isActive")
    private boolean isActive;

    @Column(name="createdAt")
    private String createdAt;

    @Column(name="updatedAt")
    private String updatedAt;


    public CareTeam(Long id, Long subjectId, boolean isActive,DateTime createdAt, DateTime updatedAt){
        
        this.id = id;
        this.subjectId = subjectId;
        this.isActive = isActive;
        this.createdAt = createdAt.toString();
        this.updatedAt = updatedAt.toString();
    }
    public CareTeam(){
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
     * @return Long return the subjectId
     */
    public Long getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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
     * @return String return the createdAt
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
     * @return String return the updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}