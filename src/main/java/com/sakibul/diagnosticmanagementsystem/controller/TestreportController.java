/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.TestService;
import com.sakibul.diagnosticmanagementsystem.dao.TestprescriptionService;
import com.sakibul.diagnosticmanagementsystem.dao.TestreportService;
import com.sakibul.diagnosticmanagementsystem.dao.TesttypeService;
import com.sakibul.diagnosticmanagementsystem.model.Patient;
import com.sakibul.diagnosticmanagementsystem.model.Testreport;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sakib
 */
@Controller
public class TestreportController {
    @Autowired
     TesttypeService ds;
    @Autowired
     TestService ts;
    @Autowired
     TestreportService tr;
    @Autowired
     TestprescriptionService tp;
     @Autowired
    private ServletContext servletContext;
    
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "testdate", new CustomDateEditor(format, false));
       // binder.registerCustomEditor(Date.class, "schtime", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    
     @InitBinder
    public void myInitBinders(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "reportdate", new CustomDateEditor(format, false));
       // binder.registerCustomEditor(Date.class, "schtime", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    
    @RequestMapping("/addtestreport")
    public ModelAndView showtestreportpage(HttpSession session) {
        String testreportgsonlist = tr.showTestreport();
        String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        String testprescriptionlist=tp.showAvailableTest();
        ModelAndView mv = new ModelAndView("pharmacist/addtestreport", "addTestreportObject1", new Testreport());
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        
        mv.addObject("testreportmodelobject", testreportgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
     @RequestMapping("/testreportlist")
    public ModelAndView showmedecinetypepages(HttpSession session) {
         String testreportgsonlist = tr.showTestreport();
       
        ModelAndView mv = new ModelAndView("pharmacist/testreportlist", "addTestreportObject1", new Testreport());
        
        mv.addObject("testreportmodelobject", testreportgsonlist);
        
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/testreportlists")
    public ModelAndView showmtestreportpages(HttpSession session) {
         String testreportgsonlist = tr.showTestreport();
       
        ModelAndView mv = new ModelAndView("admin/testreportlist", "addTestreportObject1", new Testreport());
        
        mv.addObject("testreportmodelobject", testreportgsonlist);
        
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/showtreport")
    public ModelAndView viewtreport(HttpSession session) {
         String testreportgsonlist = tr.showTestreport();
       
        ModelAndView mv = new ModelAndView("receptionist/showtestreport", "addTestreportObject1", new Testreport());
        
        mv.addObject("testreportmodelobject", testreportgsonlist);
        
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/showtestreport")
    public ModelAndView showtestreportpages(HttpSession session) {
        Patient p=(Patient)session.getAttribute("patientinfo");
       int a=p.getPid();
         String testreportgsonlist = tr.showPatientTestreport(a);
        
        ModelAndView mv = new ModelAndView("patient/viewtestreport", "addTestreportObject1", new Testreport());
        mv.addObject("testreportmodelobject", testreportgsonlist);
        
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/viewtestreport")
    public ModelAndView showtestreportpag(HttpSession session) {
        String testreportgsonlist = tr.showTestreport();
        String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        String testprescriptionlist=tp.showAvailableTest();
        ModelAndView mv = new ModelAndView("doctor/viewtestreport", "addTestreportObject1", new Testreport());
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        mv.addObject("testreportmodelobject", testreportgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/viewtestreportdoc")
    public ModelAndView showtestreportdoctor(HttpSession session) {
        String testreportgsonlist = tr.showTestreport();
        String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        String testprescriptionlist=tp.showAvailableTest();
        ModelAndView mv = new ModelAndView("doctor/viewtestreport", "addTestreportObject1", new Testreport());
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        mv.addObject("testreportmodelobject", testreportgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingtestreport", params = "Addtestreport")
    public String addmedecinetype(@ModelAttribute("addTestreportObject1") Testreport cm) {
        
        tr.insertTestreport(cm);
        tr.updateTestpres(cm.getPresid());
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\timage\\" + String.valueOf(cm.getReportid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = cm.getTimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                FileOutputStream fos = new FileOutputStream(new File(p));
                BufferedOutputStream bs = new BufferedOutputStream(fos);
                bs.write(bytes);
                bs.close();
                fos.close();
                Thread.sleep(10000);
                System.out.println("File Uploaded Successfully");
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
       
        return "redirect:/testreportlist";
    }

    @RequestMapping(value = "/addingtestreport", params = "EditTestreport")
    public String editmedecinetype(@ModelAttribute("addTestreportObject1") Testreport dept) {

        
        tr.updateTestreport(dept);
        
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        String p = targetcut + "\\src\\main\\webapp\\resources\\timage\\" + String.valueOf(dept.getReportid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = dept.getTimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                File f = new File(p);
                if (f.exists()) {
                    f.delete();
                    FileOutputStream fos = new FileOutputStream(f);
                    BufferedOutputStream bs = new BufferedOutputStream(fos);
                    bs.write(bytes);
                    bs.close();
                    fos.close();
                    Thread.sleep(10000);
                    System.out.println("File Uploaded Successfully");
                }
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
        return "redirect:/testreportlist";
    }

    @RequestMapping("removetestreport/{Id}")
    public String removemedecinetype(@PathVariable("Id") int deptId) {
        tr.deleteTestreport(deptId);
        return "redirect:/testreportlist";
    }

    @RequestMapping("/edittestreportbutton")
    public ModelAndView passingonedepartment(@RequestParam("getreportid") int reportid) {
        Testreport onereport = tr.showOneTestreport(reportid);
        String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        String testreportgsonlist = tr.showTestreport();
        String testprescriptionlist=tp.showTestpres();
        ModelAndView mv = new ModelAndView("pharmacist/addtestreport", "addTestreportObject1", onereport);
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testreportmodelobject", testreportgsonlist);
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
