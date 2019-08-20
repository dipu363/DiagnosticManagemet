/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.AppointmentsService;
import com.sakibul.diagnosticmanagementsystem.dao.DepartmentService;
import com.sakibul.diagnosticmanagementsystem.dao.DoctorService;
import com.sakibul.diagnosticmanagementsystem.dao.PrescriptionService;
import com.sakibul.diagnosticmanagementsystem.model.Appointments;
import com.sakibul.diagnosticmanagementsystem.model.Doctor;
import com.sakibul.diagnosticmanagementsystem.model.Patient;
import com.sakibul.diagnosticmanagementsystem.model.Prescription;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class AppointmentsController {
    @Autowired
    AppointmentsService milist;
    
    @Autowired
    DepartmentService depts;
    
    @Autowired
    DoctorService ds;
    
    @Autowired
    PrescriptionService ps;
    
   @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "pdate", new CustomDateEditor(format, false));
       // binder.registerCustomEditor(Date.class, "schtime", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    
     @RequestMapping("/pendingappointment")
    public ModelAndView showappointmentlistpages(HttpSession session) {
        String a= session.getAttribute("UserId").toString();
       Doctor d=ds.showOneDoctorbyEmail(a);
         System.out.println(a);
         System.out.println(d.getDoctorid());
         int doc=d.getDoctorid();
        String appointmentgsonlist = milist.viewPatientAppointment(doc);
        ModelAndView mv = new ModelAndView("doctor/appointmentlist", "addAppointmentObject1", new Appointments());
        mv.addObject("appointmentlist", appointmentgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/pendingappointments")
    public ModelAndView showappointmentlistpage(HttpSession session) {
       
        String appointmentgsonlist = milist.viewAppointmentsPatient();
        ModelAndView mv = new ModelAndView("receptionist/appointmentlist", "addAppointmentObject1", new Appointments());
        mv.addObject("appointmentlist", appointmentgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/appointmentlist")
    public ModelAndView showappointmentlistpage() {
        String appointmentgsonlist = milist.viewAppointments();
        ModelAndView mv = new ModelAndView("receptionist/viewappointments", "addAppointmentObject1", new Appointments());
        mv.addObject("appointmentlist", appointmentgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/viewappointmentlist")
    public ModelAndView showappointmentadminpage() {
        String appointmentgsonlist = milist.viewAppointments();
        ModelAndView mv = new ModelAndView("admin/viewappointments", "addAppointmentObject1", new Appointments());
        mv.addObject("appointmentlist", appointmentgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping("/showappointment")
    public ModelAndView showappointmentpage(HttpSession session) {
        Patient p=(Patient)session.getAttribute("patientinfo");
       int a=p.getPid();
        String appointmentgsonlist = milist.viewPatientAppointments(a);
        ModelAndView mv = new ModelAndView("patient/viewappointment", "addAppointmentObject1", new Appointments());
        mv.addObject("appointmentlist", appointmentgsonlist);
        mv.addObject("avl", "null");
        return mv;
    }
    
    
    @RequestMapping("/showappointmentpage")
    public ModelAndView showmedecinelistpage(@RequestParam("getdoctid") int doctid) {
        String medecinelist = milist.viewAppointments();
        
        String deptlist=depts.showDepartment();
        ModelAndView mv = new ModelAndView("patient/addappointment", "newAppointmentsObject", new Appointments());
        mv.addObject("appointmentlist", medecinelist);
        mv.addObject("departmentlist", deptlist);
        mv.addObject("doctorinfo", ds.showDocDepartment(doctid));
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping("/showappointmentpages")
    public ModelAndView showmedecinelistpages() {
        String medecinelist = milist.viewAppointments();
        

        ModelAndView mv = new ModelAndView("patient/addappointment", "newAppointmentsObject", new Appointments());
        mv.addObject("appointmentlist", medecinelist);
        
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping(value = "/prescriptionadds", params = "Add")
    public String addprescriptionpagess(@ModelAttribute("newPrescriptionObject") Prescription prescrip, HttpServletRequest request) {
        ps.insertPrescription(prescrip);

        return "redirect:/prescriptionlist";
    }
    
    @RequestMapping(value = "/appointmentadd", params = "Add")
    public ModelAndView addmedecinepage(@ModelAttribute("newAppointmentsObject") Appointments appoint, HttpServletRequest request) {
        Doctor doc=ds.showOneDoctor(appoint.getDoctorid());
        appoint.setFees(doc.getFee());
        boolean st = milist.insertAppointment(appoint);
        if (st) {
            String medecinelist = milist.viewAppointments();

            String deptlist = depts.showDepartment();
            ModelAndView mv = new ModelAndView("patient/patientprofile", "newAppointmentsObject", new Appointments());
            mv.addObject("appointmentlist", medecinelist);
            mv.addObject("departmentlist", deptlist);

            mv.addObject("avl", "true");
            return mv;
        } else {
            String medecinelist = milist.viewAppointments();

            String deptlist = depts.showDepartment();
            ModelAndView mv = new ModelAndView("patient/patientprofile", "newAppointmentsObject", new Appointments());
            mv.addObject("appointmentlist", medecinelist);
            mv.addObject("departmentlist", deptlist);

            mv.addObject("avl", "false");
            return mv;
        }
        //return "redirect:/showappointmentpages";
    }
    
    @RequestMapping(value = "/appointmentadd", params = "Edit")
    public String editMedecine(@ModelAttribute("newAppointmentsObject") Appointments appoint, HttpServletRequest request) {
        milist.updateAppointment(appoint.getAppointid(), appoint);
        
        return "redirect:/showappointmentpages";
    }
    
    
    
    @RequestMapping("/editingappointment")
    public ModelAndView editmedecinepage(@RequestParam("getpid") int pid) {
        String medecinelist = milist.viewAppointments();
        
        ModelAndView mv = new ModelAndView("addappointment", "newAppointmentsObject", milist.viewOneAppointment(pid));
         mv.addObject("appointmentlist", medecinelist);
        
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("removingappointment/{Id}")
    public String removedoctor(@PathVariable("Id") int docId) {
        milist.deleteAppointment(docId);
        return "redirect:/showappointmentpages";
    }
}
