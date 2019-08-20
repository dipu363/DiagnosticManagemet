/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Addmission;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface AddmissionService {
    public String insertAddmission(Addmission add);
    
    public String updateAddmission(Addmission add);
    
    public String deleteAddmission(int id);
    
    public String showAddmission();
    
    public Addmission showOneAddmission(int id);
    
    public Addmission showPaymentAddmission(int id);
    
    public String showAddmissionBill();
}
