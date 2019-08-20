/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.model;

/**
 *
 * @author sakib
 */
public class TestPrescriptionCart {
    int pid;
    int testid;
    int typeid;
    String description;
    double amount;

    public TestPrescriptionCart(int pid, int testid, int typeid, String description, double amount) {
        this.pid = pid;
        this.testid = testid;
        this.typeid = typeid;
        this.description = description;
        this.amount = amount;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    
    
    

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TestPrescriptionCart{" + "pid=" + pid + ", testid=" + testid + ", typeid=" + typeid + ", description=" + description + ", amount=" + amount + '}';
    }

    
   
    
    
}
