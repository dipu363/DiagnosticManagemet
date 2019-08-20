/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;


import com.sakibul.diagnosticmanagementsystem.dao.DoctorService;
import com.sakibul.diagnosticmanagementsystem.dao.TimescheduleService;
import com.sakibul.diagnosticmanagementsystem.model.Timeschedule;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class TimescheduleController {
    @Autowired
     TimescheduleService qs;
    
    @Autowired
    DoctorService ds;
    
    @RequestMapping("/timeschedulelist")
    public ModelAndView showtimeschedulepages() {
        String timeschedulegsonlist = qs.showTimeschedule();
        String doctorgsonlist=ds.showDoctor();
        ModelAndView mv = new ModelAndView("admin/schedulelist", "addTimescheduleObject1", new Timeschedule());
        mv.addObject("timeshcedulemodelobject", timeschedulegsonlist);
        mv.addObject("doctorlist", doctorgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    

    @RequestMapping("/addtimeschedule")
    public ModelAndView showtimeschedulepage() {
        String timeschedulegsonlist = qs.showTimeschedule();
        String doctorgsonlist=ds.showDoctor();
        ModelAndView mv = new ModelAndView("admin/addtimeschedule", "addTimescheduleObject1", new Timeschedule());
        mv.addObject("timeshcedulemodelobject", timeschedulegsonlist);
        mv.addObject("doctorlist", doctorgsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingtimeschedule", params = "Addtimeschedule")
    public String addtimeschedule(@ModelAttribute("addTimescheduleObject1") Timeschedule cm) {
        
        qs.insertTimeschedule(cm);
       
        return "redirect:/timeschedulelist";
    }

    @RequestMapping(value = "/addingtimeschedule", params = "EditTimeschedule")
    public String editTimeschedule(@ModelAttribute("addTimescheduleObject1") Timeschedule dept) {

        
        qs.updateTimeschedule(dept);
        return "redirect:/timeschedulelist";
    }

    @RequestMapping("removetimeschedule/{Id}")
    public String removeTimeschedule(@PathVariable("Id") int tid) {
        qs.deleteTimeschedule(tid);
        return "redirect:/timeschedulelist";
    }

    @RequestMapping("/edittimeschedulebutton")
    public ModelAndView passingoneTimeschedule(@RequestParam("gettid") int tid) {

        Timeschedule onetimeschedule = qs.showOneTimeschedule(tid);
        String timeschedulegsonlist = qs.showTimeschedule();
        String doctorgsonlist=ds.showDoctor();
        ModelAndView mv = new ModelAndView("admin/addtimeschedule", "addTimescheduleObject1", onetimeschedule);
        mv.addObject("timeshcedulemodelobject", timeschedulegsonlist);
        mv.addObject("doctorlist", doctorgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
