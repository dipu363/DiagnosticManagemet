/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.model;

/**
 *
 * @author Another User
 */
public class Cart {
    int listid;
    int typeid;
    int groupid;
    String dose;
    String doseschedule;
    String doseadvice;

    public Cart(int groupid, int typeid, int listid, String dose, String doseschedule, String doseadvice) {
        this.groupid = groupid;
        this.typeid = typeid;
        this.listid = listid;
        this.dose = dose;
        this.doseschedule = doseschedule;
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

    @Override
    public String toString() {
        return "Cart{" + "groupid=" + groupid + ", typeid=" + typeid + ", listid=" + listid + ", dose=" + dose + ", doseschedule=" + doseschedule + ", doseadvice=" + doseadvice + '}';
    }
    
    
    
}
