/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Prescriptiondrug;
import org.springframework.stereotype.Service;

/**
 *
 * @author Another User
 */
@Service
public interface ViewPrescriptiondrugService {

    public String updatePrescriptiondrug(int presid, Prescriptiondrug presdrug);

    public String deletePrescriptiondrug(int presid);

    public String viewPrescriptiondrug(int id);
    
    public String viewPrescriptiondrug();

    public Prescriptiondrug viewOnePrescriptiondrug(int presid);
}
