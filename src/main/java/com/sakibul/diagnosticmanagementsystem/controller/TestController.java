/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.TestService;
import com.sakibul.diagnosticmanagementsystem.dao.TesttypeService;
import com.sakibul.diagnosticmanagementsystem.model.Test;
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
public class TestController {
    
    @Autowired
     TesttypeService ds;
    @Autowired
     TestService ts;
    
    @RequestMapping("/addtest")
    public ModelAndView showtestpage() {
        String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        ModelAndView mv = new ModelAndView("admin/addtest", "addTestObject1", new Test());
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
     @RequestMapping("/testlist")
    public ModelAndView showmedecinetypepages() {
         String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        ModelAndView mv = new ModelAndView("admin/testlist", "addTestObject1", new Test());
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingtest", params = "Addtest")
    public String addmedecinetype(@ModelAttribute("addTestObject1") Test cm) {
        
        ts.insertTes(cm);
       
        return "redirect:/testlist";
    }

    @RequestMapping(value = "/addingtest", params = "EditTest")
    public String editmedecinetype(@ModelAttribute("addTestObject1") Test dept) {

        
        ts.updateTest(dept);
        return "redirect:/testlist";
    }

    @RequestMapping("removetest/{Id}")
    public String removemedecinetype(@PathVariable("Id") int deptId) {
        ts.deleteTest(deptId);
        return "redirect:/testlist";
    }

    @RequestMapping("/edittestbutton")
    public ModelAndView passingonedepartment(@RequestParam("getdeptid") int deptid) {
    Test onedepartment = ts.showOneTest(deptid);
        String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        
        ModelAndView mv = new ModelAndView("admin/addtest", "addTestObject1", onedepartment);
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
}
