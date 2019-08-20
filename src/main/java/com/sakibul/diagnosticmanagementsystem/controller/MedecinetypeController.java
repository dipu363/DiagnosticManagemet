/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;


import com.sakibul.diagnosticmanagementsystem.dao.MedecinetypeService;
import com.sakibul.diagnosticmanagementsystem.model.Medecinetype;
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
public class MedecinetypeController {
    
    @Autowired
     MedecinetypeService ds;

    @RequestMapping("/addmedecinetype")
    public ModelAndView showmedecinetypepage() {
        String medecinetypegsonlist = ds.showMedecinetype();
        ModelAndView mv = new ModelAndView("doctor/addmedicinetype", "addMedecinetypeObject1", new Medecinetype());
        mv.addObject("medecinetypemodelobject", medecinetypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/medicinetypelist")
    public ModelAndView showmedecinetypepages() {
        String medecinetypegsonlist = ds.showMedecinetype();
        ModelAndView mv = new ModelAndView("doctor/medicinetypelist", "addMedecinetypeObject1", new Medecinetype());
        mv.addObject("medecinetypemodelobject", medecinetypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingmedecinetype", params = "Addmedecinetype")
    public String addmedecinetype(@ModelAttribute("addMedecinetypeObject1") Medecinetype cm) {
        
        ds.insertMedecinetype(cm);
       
        return "redirect:/medicinetypelist";
    }

    @RequestMapping(value = "/addingmedecinetype", params = "EditMedecinetype")
    public String editmedecinetype(@ModelAttribute("addMedecinetypeObject1") Medecinetype dept) {

        
        ds.updateMedecinetype(dept);
        return "redirect:/medicinetypelist";
    }

    @RequestMapping("removemedecinetype/{Id}")
    public String removemedecinetype(@PathVariable("Id") int deptId) {
        ds.deleteMedecinetype(deptId);
        return "redirect:/medicinetypelist";
    }

    @RequestMapping("/editmedecinetypebutton")
    public ModelAndView passingonedepartment(@RequestParam("getdeptid") int deptid) {

        Medecinetype onedepartment = ds.showOneMedecinetype(deptid);
        String medecinetypegsonlist = ds.showMedecinetype();
        ModelAndView mv = new ModelAndView("doctor/addmedicinetype", "addMedecinetypeObject1", onedepartment);
        mv.addObject("medecinetypemodelobject", medecinetypegsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
