/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;


import com.sakibul.diagnosticmanagementsystem.model.Timeschedule;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface TimescheduleService {
    public String insertTimeschedule(Timeschedule timesch);
    
    public String updateTimeschedule(Timeschedule timesch);
    
    public String deleteTimeschedule(int id);
    
    public String showTimeschedule();
    
    public Timeschedule showOneTimeschedule(int id);
}
