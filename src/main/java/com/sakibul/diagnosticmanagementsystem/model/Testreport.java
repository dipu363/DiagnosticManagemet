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
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sakib
 */
@Entity
public class Testreport implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int reportid;
    @Column
    int presid;
    @Column
    int testid;
    @Column
    @Temporal(TemporalType.DATE)
    Date testdate;
    @Column
    @Temporal(TemporalType.DATE)
    Date reportdate;
    @Column
    String report;
    @Transient
    MultipartFile timage;
    int pid;

    public int getReportid() {
        return reportid;
    }

    public void setReportid(int reportid) {
        this.reportid = reportid;
    }

    public int getPresid() {
        return presid;
    }

    public void setPresid(int presid) {
        this.presid = presid;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
    }

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public MultipartFile getTimage() {
        return timage;
    }

    public void setTimage(MultipartFile timage) {
        this.timage = timage;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    
    
    
}
