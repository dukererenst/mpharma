/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.mpharma.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ernest
 */
@Entity
@Table(name = "code")
public class Code implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    
    @JoinColumn(name = "category")
    @ManyToOne
    private Category categeory;

    @Column(name = "diagnosis_code")
    private String diagnosisCode;

    @Column(name = "full_code")
    private String fullCode;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "short_description")
   private String shortDescription;

    public Code() {
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategeory() {
        return categeory;
    }

    public void setCategeory(Category categeory) {
        this.categeory = categeory;
    }

  

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    
    
}
