/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;


import com.sakibul.diagnosticmanagementsystem.dao.DepartmentService;
import com.sakibul.diagnosticmanagementsystem.dao.DoctorService;
import com.sakibul.diagnosticmanagementsystem.model.Doctor;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Another User
 */
@Controller
public class DoctorController {
    
    @Autowired
     DoctorService ds;
    
    @Autowired
    DepartmentService depts;
    
    @Autowired
    private ServletContext servletContext;
    
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "presdate", new CustomDateEditor(format, false));
       // binder.registerCustomEditor(Date.class, "schtime", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/adddoctor")
    public ModelAndView showdoctorpage() {
        String doctorgsonlist = ds.showDoctor();
        String deptlist=depts.showDepartment();
        ModelAndView mv = new ModelAndView("admin/adddoctor", "addDoctorObject1", new Doctor());
        mv.addObject("doctormodelobject", doctorgsonlist);
        mv.addObject("departmentlist", deptlist);
        mv.addObject("check", "true");
        return mv;
    }
    
     @RequestMapping("/doctorlist")
    public ModelAndView showdoctorlistpage() {
        String doctorgsonlist = ds.showDoctor();
        ModelAndView mv = new ModelAndView("admin/doctorlist", "addDoctorObject1", new Doctor());
        mv.addObject("doctormodelobject", doctorgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    

    @RequestMapping(value = "/addingdoctor", params = "Adddoctor")
    public String adddoctor(@ModelAttribute("addDoctorObject1") Doctor doc, HttpServletRequest request) {
        
        ds.insertDoctor(doc);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\dimage\\" + String.valueOf(doc.getDoctorid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = doc.getPimage();
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
       
        return "redirect:/doctorlist";
    }

    @RequestMapping(value = "/addingdoctor", params = "EditDoctor")
    public String editRoom(@ModelAttribute("addDoctorObject1") Doctor doc, HttpServletRequest request) {

        
        ds.updateDoctor(doc);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        String p = targetcut + "\\src\\main\\webapp\\resources\\dimage\\" + String.valueOf(doc.getDoctorid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = doc.getPimage();
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
        return "redirect:/doctorlist";
    }

    @RequestMapping("removedoctor/{Id}")
    public String removedoctor(@PathVariable("Id") int docId) {
        ds.deleteDoctor(docId);
        return "redirect:/doctorlist";
    }

    @RequestMapping("/editdoctorbutton")
    public ModelAndView passingonedoctor(@RequestParam("getdoctorid") int docid) {

        Doctor onedoc = ds.showOneDoctor(docid);
        String deptlist=depts.showDepartment();
        String doctorgsonlist = ds.showDoctor();
        ModelAndView mv = new ModelAndView("admin/adddoctor", "addDoctorObject1", onedoc);
        mv.addObject("doctormodelobject", doctorgsonlist);
        mv.addObject("departmentlist", deptlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    @RequestMapping("/editdoctorbuttons")
    public ModelAndView editdoctor(@RequestParam("getdoctorid") String docid) {

        Doctor onedoc = ds.showOneDoctorbyEmail(docid);
        String doctorgsonlist = ds.showDoctor();
        String deptlist=depts.showDepartment();
        ModelAndView mv = new ModelAndView("admin/adddoctor", "addDoctorObject1", onedoc);
        mv.addObject("doctormodelobject", doctorgsonlist);
        mv.addObject("departmentlist", deptlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    @RequestMapping("/searchdoctor")
    public ModelAndView showsearchdoctorpage(@ModelAttribute("addDoctorObject1") Doctor doc) {
        String doctorgsonlist = ds.viewdepratmentDoctor(doc.getDeptname());
        
        ModelAndView mv = new ModelAndView("departmentdoctor", "addDoctorObject1", new Doctor());
        mv.addObject("abc", doctorgsonlist);
        
        mv.addObject("check", "true");
        return mv;
    }
}
