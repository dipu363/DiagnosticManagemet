/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.PharmacistService;
import com.sakibul.diagnosticmanagementsystem.model.Pharmacist;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class PharmacistController {
    
    @Autowired
    PharmacistService phs;
    @Autowired
    private ServletContext servletContext;
    
    @RequestMapping("/addpharmacist")
    public ModelAndView showpharmacistpage() {
        String pharmacistgsonlist = phs.showPharmacist();
        
        ModelAndView mv = new ModelAndView("admin/addpharmacist", "addPharmacistObject1", new Pharmacist());
        mv.addObject("pharmacistmodelobject", pharmacistgsonlist);
        
        mv.addObject("check", "true");
        return mv;
    }
    
     @RequestMapping("/pharmacist")
    public ModelAndView showpharmacistlistpage() {
        String pharmacistgsonlist = phs.showPharmacist();
        ModelAndView mv = new ModelAndView("admin/pharmacistlist", "addPharmacistObject1", new Pharmacist());
        mv.addObject("pharmacistmodelobject", pharmacistgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    

    @RequestMapping(value = "/addingpharmacist", params = "Addpharmacist")
    public String addpharmacist(@ModelAttribute("addReceptionistObject1") Pharmacist phar, HttpServletRequest request) {
        
        phs.insertpharmacist(phar);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\phimage\\" + String.valueOf(phar.getEmailid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = phar.getPhimage();
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
       
        return "redirect:/pharmacist";
    }

    @RequestMapping(value = "/addingpharmacist", params = "EditPharmacist")
    public String editpharmacist(@ModelAttribute("addPharmacistObject1") Pharmacist ph, HttpServletRequest request) {

        
        phs.updatePharmacist(ph);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        String p = targetcut + "\\src\\main\\webapp\\resources\\phimage\\" + String.valueOf(ph.getEmailid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = ph.getPhimage();
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
        return "redirect:/pharmacist";
    }

    @RequestMapping("removepharmacist/{Id}")
    public String removepharmacist(@PathVariable("Id") int phid) {
        phs.deletePharmacist(phid);
        return "redirect:/pharmacist";
    }

    @RequestMapping("/editpharmacistbutton")
    public ModelAndView passingonepharmacist(@RequestParam("getphid") int phid) {

        Pharmacist oner = phs.showOnePharmacist(phid);
        
        String pharmacistgsonlist = phs.showPharmacist();
        ModelAndView mv = new ModelAndView("admin/addpharmacist", "addPharmacistObject1", oner);
        mv.addObject("pharmacistmodelobject", pharmacistgsonlist);
        
        mv.addObject("check", "false");
        return mv;
    }
    
    @RequestMapping("/editpharmacistbuttons")
    public ModelAndView editpharmacist(@RequestParam("getphid") String phid) {

        Pharmacist oner = phs.showOnePharmacistbyEmail(phid);
        String pharmacistgsonlist = phs.showPharmacist();
       
        ModelAndView mv = new ModelAndView("admin/addpharmacist", "addPharmacistObject1", oner);
        mv.addObject("pharmacistmodelobject", pharmacistgsonlist);
        
        mv.addObject("check", "false");
        return mv;
    }
}
