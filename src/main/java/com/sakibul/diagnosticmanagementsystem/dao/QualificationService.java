/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;


import com.sakibul.diagnosticmanagementsystem.model.Qualification;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface QualificationService {
    public String insertQualification(Qualification dept);
    
    public String updateQualification(Qualification dept);
    
    public String deleteQualification(int id);
    
    public String showQualification();
    
    public Qualification showOneQualification(int id);
}
