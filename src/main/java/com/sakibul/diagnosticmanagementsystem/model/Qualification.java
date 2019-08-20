/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sakib
 */
@Entity
public class Qualification implements java.io.Serializable{
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    int qid;
    @Column
    int doctorid;
    @Column
    String degreetitle;
    @Column
    String subject;
    @Column
    String board;
    @Column
    String institute;
    @Column
    Date passingyear;
    @Column
    String result;
    @Column
    String courseduration;

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public String getDegreetitle() {
        return degreetitle;
    }

    public void setDegreetitle(String degreetitle) {
        this.degreetitle = degreetitle;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Date getPassingyear() {
        return passingyear;
    }

    public void setPassingyear(Date passingyear) {
        this.passingyear = passingyear;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCourseduration() {
        return courseduration;
    }

    public void setCourseduration(String courseduration) {
        this.courseduration = courseduration;
    }
    
    
    
}
