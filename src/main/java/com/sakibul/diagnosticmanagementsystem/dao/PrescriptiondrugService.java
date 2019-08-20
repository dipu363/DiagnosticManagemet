/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Prescriptiondrug;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface PrescriptiondrugService {
    
    public String insertPrescriptiondrug(ArrayList<Prescriptiondrug> presdetail);
    
    public String insertPrescriptiondrug(Prescriptiondrug pres);
    
    public String updatePrescriptiondrug(int prid, Prescriptiondrug pres);
    
    public String deletePrescriptiondrug(int id);
    
    public String showPrescriptiondrug();
    
    public Prescriptiondrug showOnePrescriptiondrug(int id);
    
    public String showPatientPrescriptiondrug(int id);
}
