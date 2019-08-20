/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Doctor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Another User
 */
@Service
public interface DoctorService {

    public String insertDoctor(Doctor doc);

    public String updateDoctor(Doctor doc);

    public String deleteDoctor(int id);

    public String showDoctor();

    public Doctor showOneDoctor(int id);

    public Doctor showOneDoctorbyEmail(String email);

    public int showallDoctor();
    
    public String viewdepratmentDoctor(String deptname);
    
    public Doctor showDocDepartment(int id);
    

}
