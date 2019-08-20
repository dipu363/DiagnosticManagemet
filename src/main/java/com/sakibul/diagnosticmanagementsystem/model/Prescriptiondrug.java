/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.model;

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
public class Prescriptiondrug implements java.io.Serializable{
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    int drugid;
    @Column
    int presid;
    int listid;
    String dose;
    String doseschedule;
    String doseadvice;
    int groupid;
    int typeid;
    int appointid;
    int doctorid;
    int pid;
    

    public int getDrugid() {
        return drugid;
    }

    public void setDrugid(int drugid) {
        this.drugid = drugid;
    }

    public int getPresid() {
        return presid;
    }

    public void setPresid(int presid) {
        this.presid = presid;
    }

    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDoseschedule() {
        return doseschedule;
    }

    public void setDoseschedule(String doseschedule) {
        this.doseschedule = doseschedule;
    }

    public String getDoseadvice() {
        return doseadvice;
    }

    public void setDoseadvice(String doseadvice) {
        this.doseadvice = doseadvice;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getAppointid() {
        return appointid;
    }

    public void setAppointid(int appointid) {
        this.appointid = appointid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    
}
