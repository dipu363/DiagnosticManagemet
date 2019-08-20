/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Medecinegroup;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface MedecinegroupService {
    public String insertMedecinegroup(Medecinegroup mdg);
    
    public String updateMedecinegroup(Medecinegroup mdg);
    
    public String deleteMedecinegroup(int id);
    
    public String showMedecinegroup();
    
    public Medecinegroup showOneMedecinegroup(int id);
}
