package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.AccountantService;
import com.sakibul.diagnosticmanagementsystem.dao.DoctorService;
import com.sakibul.diagnosticmanagementsystem.dao.PatientService;
import com.sakibul.diagnosticmanagementsystem.dao.PharmacistService;
import com.sakibul.diagnosticmanagementsystem.dao.ReceptionistService;
import com.sakibul.diagnosticmanagementsystem.dao.RoomService;
import com.sakibul.diagnosticmanagementsystem.dao.Userservice;
import com.sakibul.diagnosticmanagementsystem.model.Cart;
import com.sakibul.diagnosticmanagementsystem.model.TestPrescriptionCart;
import com.sakibul.diagnosticmanagementsystem.model.User;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    Userservice user;

    @Autowired
    PatientService pservice;

    @Autowired
    DoctorService ds;

    @Autowired
    ReceptionistService rs;
    
    @Autowired
    RoomService rss;

    @Autowired
    PharmacistService ph;
    
    @Autowired
    AccountantService acs;
    
    @Autowired
    PatientService ps;
    
    @Autowired
    AccountantService ac;
    
    
    

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcome() {
        return "admin/welcome";
    }

    @RequestMapping(value = "/loginsuccess")
    public String loginsuccess(HttpSession session) {
        System.out.println("success..........");

        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
        User us = user.viewUser(userid);
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String page = "";
        String role = "ROLE_USER";

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals(role)) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("totaldoc", ds.showallDoctor());
                session.setAttribute("totalroom", rss.viewAllRoom());
                session.setAttribute("totalpatient", ps.showallPatient());
                session.setAttribute("totalaccountant", ac.showallAccountant());
                session.setAttribute("totallaboratorist", ph.showallPharmacist());
                session.setAttribute("totalreceptionist", rs.showallReceptionist());
                page = "redirect:/welcome";
            } else if (authority.getAuthority().equals("ROLE_PATIENT")) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("patientinfo", pservice.viewOnePatentmail(userid));
                page = "redirect:patientprofile";
            } else if (authority.getAuthority().equals("ROLE_DOCTOR")) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("docinfo", ds.showOneDoctorbyEmail(userid));
                session.setAttribute("usercart", new ArrayList<Cart>());
                session.setAttribute("testcart", new ArrayList<TestPrescriptionCart>());
                page = "redirect:/doctorprofile";
            } else if (authority.getAuthority().equals("ROLE_RECEPTIONIST")) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("rinfo", rs.showOneReceptionistbyEmail(userid));
                page = "redirect:/receptionistprofile";
            } else if (authority.getAuthority().equals("ROLE_PHARMACIST")) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("phinfo", ph.showOnePharmacistbyEmail(userid));
                page = "redirect:/pharmachistprofile";
            } else if (authority.getAuthority().equals("ROLE_ACCOUNTANT")) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("acinfo", acs.showOneAccountantbyEmail(userid));
                page = "redirect:/accountantprofile";
            }else {
                page = "redirect:/";
            }
        }
        return page;
    }
}
