/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Receptionist;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface ReceptionistService {
    public String insertReceptionist(Receptionist rcp);
    
    public String updateReceptionist(Receptionist rcp);
    
    public String deleteReceptionist(int id);
    
    public String showReceptionist();
    
    public Receptionist showOneReceptionist(int id);
    
    public Receptionist showOneReceptionistbyEmail(String email);
    
    public int showallReceptionist();
}
