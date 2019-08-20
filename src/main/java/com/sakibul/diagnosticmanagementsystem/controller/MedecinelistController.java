/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.MedecinegroupService;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinelistService;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinetypeService;
import com.sakibul.diagnosticmanagementsystem.model.Medecinelist;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Another User
 */
@Controller
public class MedecinelistController {
    @Autowired
    MedecinelistService milist;
    @Autowired
    MedecinegroupService mg;
    @Autowired
    MedecinetypeService mt;
    
    @RequestMapping("/addmedicine")
    public ModelAndView showmedecinelistpage() {
        String medecinelist = milist.viewMedecine();
        String grouplist = mg.showMedecinegroup();
        String typelist = mt.showMedecinetype();

        ModelAndView mv = new ModelAndView("doctor/addmedicine", "newMedecineObject", new Medecinelist());
        mv.addObject("medecinelist", medecinelist);
        mv.addObject("grouplist", grouplist);
        mv.addObject("typelist", typelist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/medicinelist")
    public ModelAndView showmedecinelistpages() {
        String medecinelist = milist.viewMedecine();
        String grouplist = mg.showMedecinegroup();
        String typelist = mt.showMedecinetype();

        ModelAndView mv = new ModelAndView("doctor/medicinelist", "newMedecineObject", new Medecinelist());
        mv.addObject("medecinelist", medecinelist);
        mv.addObject("grouplist", grouplist);
        mv.addObject("typelist", typelist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    @RequestMapping(value = "/medecineadd", params = "Add")
    public String addmedecinepage(@ModelAttribute("newMedecineObject") Medecinelist medecine, HttpServletRequest request) {
        milist.insertMedecine(medecine);

        return "redirect:/medicinelist";
    }
    
    @RequestMapping(value = "/medecineadd", params = "Edit")
    public String editMedecine(@ModelAttribute("newMedecineObject") Medecinelist medecine, HttpServletRequest request) {
        milist.updateMedecine(medecine.getListid(), medecine);
        
        return "redirect:/medicinelist";
    }
    
    
    
    @RequestMapping("/editingmedecine")
    public ModelAndView editmedecinepage(@RequestParam("getpid") int pid) {
        String medecinelist = milist.viewMedecine();
        String grouplist = mg.showMedecinegroup();
        String typelist = mt.showMedecinetype();
        ModelAndView mv = new ModelAndView("doctor/addmedicine", "newMedecineObject", milist.viewOneMedecine(pid));
         mv.addObject("medecinelist", medecinelist);
        mv.addObject("grouplist", grouplist);
        mv.addObject("typelist", typelist);
        mv.addObject("check", "false");
        return mv;
    }
    
    @RequestMapping("removingmedecine/{Id}")
    public String removedoctor(@PathVariable("Id") int docId) {
        milist.deleteMedecine(docId);
        return "redirect:/medicinelist";
    }
    
}
