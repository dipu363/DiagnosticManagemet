/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Testprescription;
import com.sakibul.diagnosticmanagementsystem.model.Testreport;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface TestreportService {
    public String insertTestreport(Testreport treport);
    
    public String updateTestreport(Testreport treport);
    
    public String deleteTestreport(int id);
    
    public String showTestreport();
    
    public String showPatientTestreport(int id);
    
    public Testreport showOneTestreport(int id);
    
    public String updateTestpres(int presid);
    
}
