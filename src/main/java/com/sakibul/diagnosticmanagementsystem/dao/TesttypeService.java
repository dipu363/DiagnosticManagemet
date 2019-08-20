/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Testtype;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface TesttypeService {
    public String insertTesttype(Testtype ttype);
    
    public String updateTesttype(Testtype ttype);
    
    public String deleteTesttype(int id);
    
    public String showTesttype();
    
    public Testtype showOneTesttype(int id);
}
