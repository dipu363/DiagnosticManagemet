/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;



import com.sakibul.diagnosticmanagementsystem.dao.DepartmentService;
import com.sakibul.diagnosticmanagementsystem.model.Department;
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
public class DepartmentController {
    @Autowired
     DepartmentService ds;

    @RequestMapping("/adddepartment")
    public ModelAndView showdepartmentpage() {
        String departmentgsonlist = ds.showDepartment();
        ModelAndView mv = new ModelAndView("admin/adddepartment", "addDepartmentObject1", new Department());
        mv.addObject("departmentmodelobject", departmentgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/departmentlist")
    public ModelAndView showdepartmentlistpage() {
        String departmentgsonlist = ds.showDepartment();
        ModelAndView mv = new ModelAndView("admin/departmentlist", "addDepartmentObject1", new Department());
        mv.addObject("departmentmodelobject", departmentgsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingdepartment", params = "Adddepartment")
    public String adddepartment(@ModelAttribute("addCategoryObject1") Department cm) {
        
        ds.insertDepartment(cm);
       
        return "redirect:/adddepartment";
    }

    @RequestMapping(value = "/addingdepartment", params = "EditDepartment")
    public String editDepartment(@ModelAttribute("addDepartmentObject1") Department dept) {

        
        ds.updateDepartment(dept);
        return "redirect:/adddepartment";
    }

    @RequestMapping("removedepartment/{Id}")
    public String removedepartment(@PathVariable("Id") int deptId) {
        ds.deleteDepartment(deptId);
        return "redirect:/adddepartment";
    }

    @RequestMapping("/editdepartmentbutton")
    public ModelAndView passingonedepartment(@RequestParam("getdeptid") int deptid) {

        Department onedepartment = ds.showOneDepartment(deptid);
        String departmentgsonlist = ds.showDepartment();
        ModelAndView mv = new ModelAndView("admin/adddepartment", "addDepartmentObject1", onedepartment);
        mv.addObject("departmentmodelobject", departmentgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
