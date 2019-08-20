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

/**
 *
 * @author Another User
 */
@Entity
public class Paymentinfo implements java.io.Serializable{
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    int payid;
    int pid;
    @Column
    int appointid;
    @Column
    int addid;
    @Column
    double appointfees;
    @Column
    Date paymentdate;
    @Column
    String status;
    double admissionfees;
    double testcost;
    double total;
    int testid;

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }
    
    
    

    
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPayid() {
        return payid;
    }

    public void setPayid(int payid) {
        this.payid = payid;
    }

    public int getAppointid() {
        return appointid;
    }

    public void setAppointid(int appointid) {
        this.appointid = appointid;
    }

    

    public int getAddid() {
        return addid;
    }

    public void setAddid(int addid) {
        this.addid = addid;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAppointfees() {
        return appointfees;
    }

    public void setAppointfees(double appointfees) {
        this.appointfees = appointfees;
    }

    public double getAdmissionfees() {
        return admissionfees;
    }

    public void setAdmissionfees(double admissionfees) {
        this.admissionfees = admissionfees;
    }

    public double getTestcost() {
        return testcost;
    }

    public void setTestcost(double testcost) {
        this.testcost = testcost;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
