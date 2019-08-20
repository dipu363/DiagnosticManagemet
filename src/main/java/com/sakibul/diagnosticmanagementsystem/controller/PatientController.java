/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;


import com.sakibul.diagnosticmanagementsystem.dao.PatientService;
import com.sakibul.diagnosticmanagementsystem.model.Patient;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sakib
 */
@Controller
public class PatientController {

    @Autowired
    PatientService rs;
            
     @Autowired
    private ServletContext servletContext;
    
    @RequestMapping("/patientsignup")
    public ModelAndView addpatientPage() {
        ModelAndView mv = new ModelAndView("patientsignup");
        mv.addObject("patient", new Patient());
        return mv;
    }
    
    @RequestMapping(value= "/addingpatient", method = RequestMethod.POST)
    public ModelAndView reguser(@ModelAttribute("patient") Patient pp, HttpServletRequest request) {
        String result = rs.insertPatient(pp);
        
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\pimage\\" + String.valueOf(pp.getPid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = pp.getPimage();
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

        if (result.equalsIgnoreCase("success")) {
            ModelAndView mv = new ModelAndView("login");
            mv.addObject(result, "success");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("patientsignup");
            mv.addObject(result, "fail");
            return mv;
        }
    }
    
    @RequestMapping("/addpatient")
    public ModelAndView showpatientpage() {
        String patientgsonlist = rs.viewPatient();
        
        ModelAndView mv = new ModelAndView("addpatient", "addPatientObject1", new Patient());
        mv.addObject("doctormodelobject", patientgsonlist);
       
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping(value = "/addingpatients", params = "Addpatient")
    public String addpatient(@ModelAttribute("addPatientObject1") Patient pat, HttpServletRequest request) {
        
        rs.insertPatient(pat);
        String path = servletContext.getRealPath("/");
        System.out.println(path);
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        System.out.println(projectcut);
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        System.out.println(projectcuts);
        String targetcut = projectcuts.substring(0, projectcuts.lastIndexOf("\\"));
        System.out.println(targetcut);
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\pimage\\" + String.valueOf(pat.getPid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = pat.getPimage();
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
       
        return "redirect:/patientlist";
    }
    
    @RequestMapping("/patientlist")
    public ModelAndView showpatientlistpage() {
        String patientgsonlist = rs.viewPatient();
        ModelAndView mv = new ModelAndView("admin/patientlist", "addPatientObject1", new Patient());
        mv.addObject("patientmodelobject", patientgsonlist);
        mv.addObject("check", "true");
        return mv;
    }

}
