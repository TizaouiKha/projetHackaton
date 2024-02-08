package com.example.projetHackatonBack.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

@Entity
public class Communication implements Serializable{
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="idCareTeam")
    private Long idCareTeam;

    @Column(name="isEntrePro")
    private Long isEntrePro;

    @Column(name="idSender")
    private Long idSender;

    @Column(name="textMsg")
    private String textMsg;

    @Column(name="fileMsg")
    private String fileMsg;

    @Column(name="dateSent")
    private String dateSent;

    @Column(name="dateReceived")
    private String dateReceived;


    public Communication( Long idCareTeam, Long isEntrePro,  Long idSender, String txtMsg, String fileMsg, DateTime dateSent, DateTime dateReceived){
        this.idCareTeam = idCareTeam;
        this.isEntrePro = isEntrePro;
        this.idSender = idSender;
        this.textMsg = textMsg;
        this.fileMsg = fileMsg;
        this.dateSent = dateSent.toString();
        this.dateReceived = dateReceived.toString();
    }
    public Communication(){
        
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
     * @return Long return the idCareTeam
     */
    public Long getIdCareTeam() {
        return idCareTeam;
    }

    /**
     * @param idCareTeam the idCareTeam to set
     */
    public void setIdCareTeam(Long idCareTeam) {
        this.idCareTeam = idCareTeam;
    }

    /**
     * @return Long return the isEntrePro
     */
    public Long getIsEntrePro() {
        return isEntrePro;
    }

    /**
     * @param isEntrePro the isEntrePro to set
     */
    public void setIsEntrePro(Long isEntrePro) {
        this.isEntrePro = isEntrePro;
    }

    /**
     * @return Long return the idSender
     */
    public Long getIdSender() {
        return idSender;
    }

    /**
     * @param idSender the idSender to set
     */
    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    /**
     * @return String return the textMsg
     */
    public String getTextMsg() {
        return textMsg;
    }

    /**
     * @param textMsg the textMsg to set
     */
    public void setTextMsg(String textMsg) {
        this.textMsg = textMsg;
    }

    /**
     * @return String return the fileMsg
     */
    public String getFileMsg() {
        return fileMsg;
    }

    /**
     * @param fileMsg the fileMsg to set
     */
    public void setFileMsg(String fileMsg) {
        this.fileMsg = fileMsg;
    }

    /**
     * @return String return the dateSent
     */
    public String getDateSent() {
        return dateSent;
    }

    /**
     * @param dateSent the dateSent to set
     */
    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    /**
     * @return String return the dateReceived
     */
    public String getDateReceived() {
        return dateReceived;
    }

    /**
     * @param dateReceived the dateReceived to set
     */
    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

}