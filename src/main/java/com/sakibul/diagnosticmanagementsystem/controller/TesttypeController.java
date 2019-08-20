/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.TesttypeService;
import com.sakibul.diagnosticmanagementsystem.model.Testtype;
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
public class TesttypeController {
    @Autowired
     TesttypeService ds;

    @RequestMapping("/addtesttype")
    public ModelAndView showmedecinetypepage() {
        String medecinetypegsonlist = ds.showTesttype();
        ModelAndView mv = new ModelAndView("admin/addtesttype", "addTesttypeObject1", new Testtype());
        mv.addObject("testtypemodelobject", medecinetypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
     @RequestMapping("/testtypelist")
    public ModelAndView showmedecinetypepages() {
        String medecinetypegsonlist = ds.showTesttype();
        ModelAndView mv = new ModelAndView("admin/testtypelist", "addTesttypeObject1", new Testtype());
        mv.addObject("testtypemodelobject", medecinetypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingtesttype", params = "Addtesttype")
    public String addmedecinetype(@ModelAttribute("addTesttypeObject1") Testtype cm) {
        
        ds.insertTesttype(cm);
       
        return "redirect:/testtypelist";
    }

    @RequestMapping(value = "/addingtesttype", params = "EditTesttype")
    public String editmedecinetype(@ModelAttribute("addTesttypeObject1") Testtype dept) {

        
        ds.updateTesttype(dept);
        return "redirect:/testtypelist";
    }

    @RequestMapping("removetesttype/{Id}")
    public String removemedecinetype(@PathVariable("Id") int deptId) {
        ds.deleteTesttype(deptId);
        return "redirect:/testtypelist";
    }

    @RequestMapping("/edittesttypebutton")
    public ModelAndView passingonedepartment(@RequestParam("getdeptid") int deptid) {

        Testtype onedepartment = ds.showOneTesttype(deptid);
        String medecinetypegsonlist = ds.showTesttype();
        ModelAndView mv = new ModelAndView("admin/addtesttype", "addTesttypeObject1", onedepartment);
        mv.addObject("testtypemodelobject", medecinetypegsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
