/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.MedecinegroupService;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinelistService;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinetypeService;
import com.sakibul.diagnosticmanagementsystem.dao.PrescriptiondrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Another User
 */
@Controller
public class CartController {
    
    @Autowired
    MedecinegroupService mgs;
    @Autowired
    MedecinetypeService mts;
    @Autowired
    MedecinelistService mls;
    @Autowired
    PrescriptiondrugService pds;
    
}
