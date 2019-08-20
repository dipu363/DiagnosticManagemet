/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.AddmissionService;
import com.sakibul.diagnosticmanagementsystem.dao.PatientService;
import com.sakibul.diagnosticmanagementsystem.dao.RoomService;
import com.sakibul.diagnosticmanagementsystem.model.Addmission;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class AddmissionController {
    
    @Autowired
    AddmissionService ads;
    
    @Autowired
    RoomService room;
    
    @Autowired
    PatientService ps;
    
   @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "addmissiondate", new CustomDateEditor(format, false));
       // binder.registerCustomEditor(Date.class, "schtime", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    
    @RequestMapping("/addmissionlist")
    public ModelAndView showappointmentlistpage() {
        String addmissiongsonlist = ads.showAddmission();
        String roomlist=room.viewAvailableRoom();
        String patientlist=ps.viewPatient();
        ModelAndView mv = new ModelAndView("receptionist/addmissionlist", "addAddmissionObject1", new Addmission());
        mv.addObject("addmissionlist", addmissiongsonlist);
        mv.addObject("roomlist", roomlist);
        mv.addObject("patientlist", patientlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/addmissionlists")
    public ModelAndView showadmissionlistpage() {
        String addmissiongsonlist = ads.showAddmission();
        String roomlist=room.viewAvailableRoom();
        String patientlist=ps.viewPatient();
        ModelAndView mv = new ModelAndView("admin/addmissionlist", "addAddmissionObject1", new Addmission());
        mv.addObject("addmissionlist", addmissiongsonlist);
        mv.addObject("roomlist", roomlist);
        mv.addObject("patientlist", patientlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    @RequestMapping("/addaddmission")
    public ModelAndView showmedecinelistpage() {
        String addmissionlist = ads.showAddmission();
        String patientlist=ps.viewPatient();
        String roomlist=room.viewAvailableRoom();
        ModelAndView mv = new ModelAndView("receptionist/addaddmission", "addAddmissionObject1", new Addmission());
        mv.addObject("addmissionlist", addmissionlist);
        mv.addObject("roomlist", roomlist);
        mv.addObject("patientlist", patientlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addmissionadd", params = "Add")
    public String addmedecinepage(@ModelAttribute("addAddmissionObject1") Addmission addmission, HttpServletRequest request) {
        System.out.println(addmission.getNumberofday()*addmission.getCost());
        addmission.setTotalcost(addmission.getNumberofday()*addmission.getCost());
        ads.insertAddmission(addmission);
        
        return "redirect:/addmissionlist";
    }
    
    @RequestMapping(value = "/addmissionadd", params = "Edit")
    public String editMedecine(@ModelAttribute("addAddmissionObject1") Addmission addmission, HttpServletRequest request) {
        ads.updateAddmission(addmission);
        
        return "redirect:/addmissionlist";
    }
    
    
    
    @RequestMapping("/editingaddmission")
    public ModelAndView editmedecinepage(@RequestParam("getaddid") int addid) {
        String addmissionlist = ads.showAddmission();
        String roomlist=room.viewAvailableRoom();
        String patientlist=ps.viewPatient();
        ModelAndView mv = new ModelAndView("addaddmission", "addAddmissionObject1", ads.showOneAddmission(addid));
         mv.addObject("addmissionlist", addmissionlist);
        mv.addObject("roomlist", roomlist);
        mv.addObject("patientlist", patientlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    @RequestMapping("removingaddmission/{Id}")
    public String removedoctor(@PathVariable("Id") int addid) {
        ads.deleteAddmission(addid);
        return "redirect:/showaddmissionpage";
    }
    
}
