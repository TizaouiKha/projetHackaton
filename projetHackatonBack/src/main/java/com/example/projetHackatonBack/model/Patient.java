package com.example.projetHackatonBack.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

@Entity
public class Patient implements Serializable{
    

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="diabetesType")
    private String diabetesType;

    @Column(name="insulinScheme")
    private String insulinScheme;

    @Column(name="isActive")
    private boolean isActive;

    @Column(name="createdAt")
    private String createdAt;

    @Column(name="updatesAt")
    private String updatesAt;


    public Patient(Long id, String firstName, String lastName,  String email, String diabetesType, String insulinScheme, boolean isActive,DateTime createdAt, DateTime updatesAt){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.diabetesType = diabetesType;
        this.insulinScheme = insulinScheme;
        this.isActive = isActive;
        this.createdAt = createdAt.toString();
        this.updatesAt = updatesAt.toString();
    }
    public Patient(){
        
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
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the diabetesType
     */
    public String getDiabetesType() {
        return diabetesType;
    }

    /**
     * @param diabetesType the diabetesType to set
     */
    public void setDiabetesType(String diabetesType) {
        this.diabetesType = diabetesType;
    }

    /**
     * @return String return the insulinScheme
     */
    public String getInsulinScheme() {
        return insulinScheme;
    }

    /**
     * @param insulinScheme the insulinScheme to set
     */
    public void setInsulinScheme(String insulinScheme) {
        this.insulinScheme = insulinScheme;
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
     * @return String return the updatesAt
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
