/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sakib
 */
@Entity
public class Appointments implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int appointid;
    @Column
    int pid;
    @Column
    int doctorid;
    @Column
    @Temporal(TemporalType.DATE)
    Date appointdate;
    @Column
    String appointstatus="Pending";
    String problem;
    String deptname;
    double fees;
    String billstatus="True";
    int serialno;
    
    

    public int getAppointid() {
        return appointid;
    }

    public void setAppointid(int appointid) {
        this.appointid = appointid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public Date getAppointdate() {
        return appointdate;
    }

    public void setAppointdate(Date appointdate) {
        this.appointdate = appointdate;
    }

    public String getAppointstatus() {
        return appointstatus;
    }

    public void setAppointstatus(String appointstatus) {
        this.appointstatus = appointstatus;
    }

   

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(String billstatus) {
        this.billstatus = billstatus;
    }

    public int getSerialno() {
        return serialno;
    }

    public void setSerialno(int serialno) {
        this.serialno = serialno;
    }
    
    
    
    
}
