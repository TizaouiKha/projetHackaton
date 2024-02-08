package com.example.projetHackatonBack.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

@Entity
public class Practitioner implements Serializable{
    

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="isActive")
    private boolean isActive;

    @Column(name="createdAt")
    private String createdAt;

    @Column(name="updatesAt")
    private String updatesAt;


    public Practitioner(Long id, String firstName, String lastName, boolean isActive,DateTime createdAt, DateTime updatesAt){
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.createdAt = createdAt.toString();
        this.updatesAt = updatesAt.toString();
    }
    public Practitioner(){
        
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
     * @return String return the name
     */
  

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public String getUpdatesAt() {
        return updatesAt;
    }

    /**
     * @param updatesAt the updatesAt to set
     */
    public void setUpdatesAt(String updatesAt) {
        this.updatesAt = updatesAt;
    }

}
