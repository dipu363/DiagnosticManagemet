/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Another User
 */
@Entity
public class Prescription implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int presid;
    @Column
    int doctorid;
    @Column
    int pid;
    @Column
    @Temporal(TemporalType.DATE)
    Date presdate;
    @Column
    @Temporal(TemporalType.DATE)
    Date nextconsultdate;
    @Column
    String remarks;
    @Column
    int appointid;
    String reportstatus="True";
    @Transient
    int listid;
    @Transient
    int typeid;
    @Transient
    int groupid;
    @Transient
    String dose;
    @Transient
    String doseschedule;
    @Transient
    String doseadvice;
    @Transient
    int testid;
    @Transient
    String description;
    @Transient
    String status="Pending";
    @Transient
    double amount;
    
    
     
    @Transient
    List<Prescriptiondrug> presdrug;
    

    public int getPresid() {
        return presid;
    }

    public void setPresid(int presid) {
        this.presid = presid;
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

    public Date getPresdate() {
        return presdate;
    }

    public void setPresdate(Date presdate) {
        this.presdate = presdate;
    }

    public Date getNextconsultdate() {
        return nextconsultdate;
    }

    public void setNextconsultdate(Date nextconsultdate) {
        this.nextconsultdate = nextconsultdate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getAppointid() {
        return appointid;
    }

    public void setAppointid(int appointid) {
        this.appointid = appointid;
    }

    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
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

    public List<Prescriptiondrug> getPresdrug() {
        return presdrug;
    }

    public void setPresdrug(List<Prescriptiondrug> presdrug) {
        this.presdrug = presdrug;
    }

    public String getReportstatus() {
        return reportstatus;
    }

    public void setReportstatus(String reportstatus) {
        this.reportstatus = reportstatus;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    
    
    
}
