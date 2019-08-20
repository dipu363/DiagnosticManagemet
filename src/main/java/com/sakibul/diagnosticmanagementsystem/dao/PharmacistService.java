/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Pharmacist;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface PharmacistService {
    public String insertpharmacist(Pharmacist ph);
    
    public String updatePharmacist(Pharmacist ph);
    
    public String deletePharmacist(int id);
    
    public String showPharmacist();
    
    public Pharmacist showOnePharmacist(int id);
    
    public Pharmacist showOnePharmacistbyEmail(String email);
    
     public int showallPharmacist();
}
