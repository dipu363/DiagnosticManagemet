/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Test;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface TestService {
    public String insertTes(Test ttype);
    
    public String updateTest(Test ttype);
    
    public String deleteTest(int id);
    
    public String showTest();
    
    public Test showOneTest(int id);
}
