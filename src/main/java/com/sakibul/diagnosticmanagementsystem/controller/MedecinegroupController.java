/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.MedecinegroupService;
import com.sakibul.diagnosticmanagementsystem.model.Medecinegroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sakib
 */
@Controller
public class MedecinegroupController {
    @Autowired
     MedecinegroupService ds;

    @RequestMapping("/addmedecinegroup")
    public ModelAndView showmedecinetypepage() {
        String medecinetypegsonlist = ds.showMedecinegroup();
        ModelAndView mv = new ModelAndView("doctor/addmedicinegroup", "addMedecinegroupObject1", new Medecinegroup());
        mv.addObject("medecinegroupmodelobject", medecinetypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/medicinegrouplist")
    public ModelAndView showmedecinetypepages() {
        String medecinetypegsonlist = ds.showMedecinegroup();
        ModelAndView mv = new ModelAndView("doctor/medicinegrouplist", "addMedecinegroupObject1", new Medecinegroup());
        mv.addObject("medecinegroupmodelobject", medecinetypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingmedecinegroup", params = "Addmedecinegroup")
    public String addmedecinetype(@ModelAttribute("addMedecinegroupObject1") Medecinegroup cm) {
        
        ds.insertMedecinegroup(cm);
       
        return "redirect:/medicinegrouplist";
    }

    @RequestMapping(value = "/addingmedecinegroup", params = "Editmedecinegroup")
    public String editmedecinetype(@ModelAttribute("addMedecinetypeObject1") Medecinegroup dept) {

        
        ds.updateMedecinegroup(dept);
        return "redirect:/medicinegrouplist";
    }

    @RequestMapping("removemedecinegroup/{Id}")
    public String removemedecinetype(@PathVariable("Id") int deptId) {
        ds.deleteMedecinegroup(deptId);
        return "redirect:/medicinegrouplist";
    }

    @RequestMapping("/editmedecinegroupbutton")
    public ModelAndView passingonedepartment(@RequestParam("getdeptid") int deptid) {

        Medecinegroup onedepartment = ds.showOneMedecinegroup(deptid);
        String medecinetypegsonlist = ds.showMedecinegroup();
        ModelAndView mv = new ModelAndView("doctor/addmedicinegroup", "addMedecinegroupObject1", onedepartment);
        mv.addObject("medecinegroupmodelobject", medecinetypegsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
