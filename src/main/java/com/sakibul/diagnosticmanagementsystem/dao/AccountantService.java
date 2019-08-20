/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Accountant;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface AccountantService {
    public String insertAccountant(Accountant ac);
    
    public String updateAccountant(Accountant ac);
    
    public String deleteAccountant(int id);
    
    public String showAccountant();
    
    public Accountant showOneAccountant(int id);
    
    public Accountant showOneAccountantbyEmail(String email);
    
    public int showallAccountant();
}
