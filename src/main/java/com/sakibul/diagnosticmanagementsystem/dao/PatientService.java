/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;


import com.sakibul.diagnosticmanagementsystem.model.Patient;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface PatientService {
    public String insertPatient(Patient patient);

    public String updatePatient(Patient cm);

    public String deletePatient(int id);

    public String viewPatient();
    
    public String viewTestPatient();

    public Patient viewOnePatient(int id);
    
    public Patient viewOnePatentmail(String email);
    
   public int showallPatient();
}
