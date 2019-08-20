/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.DepartmentService;
import com.sakibul.diagnosticmanagementsystem.dao.DoctorService;
import com.sakibul.diagnosticmanagementsystem.dao.RoomService;
import com.sakibul.diagnosticmanagementsystem.model.Doctor;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */
@Controller
public class IndexController {

    @Autowired
    DoctorService ds;
    
    @Autowired
    RoomService rs;
    
    @Autowired
    DepartmentService dps;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome(HttpSession session) {
        
        String doctorgsonlist = ds.showDoctor();
        ModelAndView mv = new ModelAndView("index", "addDoctorObject1", new Doctor());
        mv.addObject("doctormodelobject", doctorgsonlist);
        session.setAttribute("totaldoc", ds.showallDoctor());
        session.setAttribute("totalroom", rs.viewAllRoom());
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView welcomeHome(HttpSession session) {

        String doctorgsonlist = ds.showDoctor();
        ModelAndView mv = new ModelAndView("index", "addDoctorObject1", new Doctor());
        mv.addObject("doctormodelobject", doctorgsonlist);
        session.setAttribute("totaldoc", ds.showallDoctor());
        session.setAttribute("totalroom", rs.viewAllRoom());
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/patientprofile", method = RequestMethod.GET)
    public String showPatient() {
        return "patient/patientprofile";
    }

    @RequestMapping(value = "/doctorprofile", method = RequestMethod.GET)
    public String showDoctor() {
        return "doctor/doctorprofile";
    }

    @RequestMapping(value = "/receptionistprofile", method = RequestMethod.GET)
    public String showReceptionist() {
        return "receptionist/receptionistprofile";
    }

    @RequestMapping(value = "/pharmachistprofile", method = RequestMethod.GET)
    public String showPharmacist() {
        return "pharmacist/pharmacistprofile";
    }

    @RequestMapping(value = "/accountantprofile", method = RequestMethod.GET)
    public String showAccountant() {
        return "accountant/accountantprofile";
    }

    @RequestMapping(value = "viewappointment", method = RequestMethod.GET)
    public ModelAndView viewappointment() {
        String doctorgsonlist = ds.showDoctor();
        ModelAndView mv = new ModelAndView("viewappointment", "addDoctorObject1", new Doctor());
        mv.addObject("doctormodelobject", doctorgsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "appointdoctorlist", method = RequestMethod.GET)
    public ModelAndView viewappointments() {
        String doctorgsonlist = ds.showDoctor();
        String departmentgsonlist = dps.showDepartment();
        ModelAndView mv = new ModelAndView("patient/doctorlist", "addDoctorObject1", new Doctor());
        mv.addObject("doctormodelobject", doctorgsonlist);
        mv.addObject("departmentmodelobject", departmentgsonlist);
        mv.addObject("check", "true");
        return mv;
        
    }
    
    @RequestMapping(value = "showdoctorlist", method = RequestMethod.GET)
    public ModelAndView viewdoctorlist() {
        String doctorgsonlist = ds.showDoctor();
        String departmentgsonlist = dps.showDepartment();
        ModelAndView mv = new ModelAndView("showdoctorlist", "addDoctorObject1", new Doctor());
        mv.addObject("doctormodelobject", doctorgsonlist);
        mv.addObject("departmentmodelobject", departmentgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    

}
