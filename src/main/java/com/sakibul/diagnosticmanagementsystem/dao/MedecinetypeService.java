/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;


import com.sakibul.diagnosticmanagementsystem.model.Medecinetype;
import org.springframework.stereotype.Service;

/**
 *
 * @author Another User
 */
@Service
public interface MedecinetypeService {
    public String insertMedecinetype(Medecinetype mdc);
    
    public String updateMedecinetype(Medecinetype mdc);
    
    public String deleteMedecinetype(int id);
    
    public String showMedecinetype();
    
    public Medecinetype showOneMedecinetype(int id);
}
