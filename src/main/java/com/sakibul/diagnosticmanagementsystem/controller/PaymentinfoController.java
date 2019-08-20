/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.AddmissionService;
import com.sakibul.diagnosticmanagementsystem.dao.AppointmentsService;
import com.sakibul.diagnosticmanagementsystem.dao.PatientService;
import com.sakibul.diagnosticmanagementsystem.dao.PaymentinfoService;
import com.sakibul.diagnosticmanagementsystem.dao.PrescriptionService;
import com.sakibul.diagnosticmanagementsystem.dao.TestService;
import com.sakibul.diagnosticmanagementsystem.dao.TestprescriptionService;
import com.sakibul.diagnosticmanagementsystem.model.Paymentinfo;
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
 * @author Another User
 */
@Controller
public class PaymentinfoController {

    @Autowired
    AddmissionService ads;
    
    @Autowired
    AppointmentsService aps;

    @Autowired
    PrescriptionService pres;

    @Autowired
    PaymentinfoService ps;

    @Autowired
    PatientService pas;
    
    @Autowired
    TestprescriptionService tps;

    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "addmissiondate", new CustomDateEditor(format, false));
        }

    @RequestMapping("/paymentlist")
    public ModelAndView showappointmentlistpage() {

        String paymentlist = ps.showPaymentinfo();

        ModelAndView mv = new ModelAndView("accountant/paymentlist", "addPaymentObject1", new Paymentinfo());

        mv.addObject("paymentlist", paymentlist);

        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/paymentlists")
    public ModelAndView showappointmentpage() {

        String paymentlist = ps.showPaymentinfo();

        ModelAndView mv = new ModelAndView("admin/paymentlist", "addPaymentObject1", new Paymentinfo());

        mv.addObject("paymentlist", paymentlist);

        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/allbillrecords")
    public ModelAndView showallbillpage() {

        String paymentlist = ps.showAllPaymentinfo();

        ModelAndView mv = new ModelAndView("accountant/allbillrecords", "addPaymentObject1", new Paymentinfo());

        mv.addObject("paymentlist", paymentlist);

        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping("/addpayment")
    public ModelAndView showmedecinelistpage() {

        String billlist = aps.viewPendingPatient();
        ModelAndView mv = new ModelAndView("accountant/searchbill", "addPaymentObject1", new Paymentinfo());

        mv.addObject("billlistobject", billlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping("/showbill")
    public ModelAndView showbillpage() {

        String billlist = aps.viewPendingPatient();
        ModelAndView mv = new ModelAndView("accountant/searchbill", "addPaymentObject1", new Paymentinfo());

        mv.addObject("billlist", billlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingpayment", params = "Add")
    public String addmedecinepage(@ModelAttribute("addPaymentObject1") Paymentinfo payinfo, HttpServletRequest request) {

        payinfo.setStatus("Unpaid");
        ps.insertPaymentinfo(payinfo);

        return "redirect:/paymentlist";
    }

    @RequestMapping(value = "/searchbill")
    public ModelAndView addmedecinepages(@ModelAttribute("addPaymentObject1") Paymentinfo payinfo, HttpSession session) {
        int a = payinfo.getPid();
        System.out.println(a);
        
       
        ModelAndView mv = new ModelAndView("accountant/addpayment", "addPaymentObject1", new Paymentinfo());
       
        session.setAttribute("appointinfo", aps.viewPayableAppointments(a));
        session.setAttribute("admissioninfo", ads.showPaymentAddmission(a));
        session.setAttribute("testinfo", tps.showBillTest(a));
       
        return mv;

    }

    @RequestMapping(value = "/addingpayment", params = "Edit")
    public String editMedecine(@ModelAttribute("addPaymentObject1") Paymentinfo payinfo, HttpServletRequest request) {
        ps.updatePaymentinfo(payinfo);

        return "redirect:/paymentlist";
    }

    @RequestMapping("/editingpayment")
    public ModelAndView editmedecinepage(@RequestParam("getid") int payid) {
        String addmissiongsonlist = ads.showAddmission();
        String preslist = pres.showPrescription();
        String paymentlist = ps.showPaymentinfo();
        String plist = pas.viewPatient();
        Paymentinfo billlist = ps.showOnePaymentinfo(payid);
        ModelAndView mv = new ModelAndView("accountant/addpayment", "addPaymentObject1", ps.showOnePaymentinfo(payid));
        mv.addObject("addmissionlist", addmissiongsonlist);
        mv.addObject("preslist", preslist);
        mv.addObject("paymentlist", paymentlist);
        mv.addObject("patientlist", plist);
        mv.addObject("billlist", billlist);
        mv.addObject("check", "false");
        return mv;
    }

    @RequestMapping("removingpayment/{Id}")
    public String removedoctor(@PathVariable("Id") int addid) {
        ads.deleteAddmission(addid);
        return "redirect:/paymentlist";
    }
    
}
