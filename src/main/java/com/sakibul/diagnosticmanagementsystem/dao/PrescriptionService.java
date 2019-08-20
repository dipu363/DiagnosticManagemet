/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Prescription;
import org.springframework.stereotype.Service;

/**
 *
 * @author Another User
 */
@Service
public interface PrescriptionService {
    public String insertPrescription(Prescription pres);
    
    public String updatePrescription(Prescription pres);
    
    public String deletePrescription(int id);
    
     public String patientPrescription(int id);
    
    public String showPrescription();
    
    public String showPenPrescription();
    
    public Prescription showOnePrescription(int id);
    
    public String updatePrescriptionstatus(int id);
}
