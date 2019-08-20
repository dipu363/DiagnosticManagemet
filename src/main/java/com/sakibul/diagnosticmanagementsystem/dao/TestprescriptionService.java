/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Prescription;
import com.sakibul.diagnosticmanagementsystem.model.Testprescription;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface TestprescriptionService {
    
    public String insertPrescriptiondrug(ArrayList<Testprescription> presdetail);
    public String insertTestpres(Testprescription tp);
    
    public String updateTestpres(Testprescription tp);
    
    public String deleteTestpres(int id);
    
    public String showTestpres();
    
    public String showPatientTestpres(int id);
    
    public Testprescription showOneTestpres(int id);
    
    public String showAvailableTest();
    
    public Testprescription showBillTest(int id);
    
    public String updatepayinfo(double total, Prescription ps);
}
