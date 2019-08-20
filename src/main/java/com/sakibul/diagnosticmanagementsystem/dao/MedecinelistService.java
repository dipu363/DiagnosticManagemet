/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Medecinelist;
import org.springframework.stereotype.Service;

/**
 *
 * @author Another User
 */
@Service
public interface MedecinelistService {
    public String insertMedecine(Medecinelist ml);

    public String updateMedecine(int listid, Medecinelist ml);

    public String deleteMedecine(int listid);

    public String viewMedecine();

    public Medecinelist viewOneMedecine(int listid);
}
