/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.ReceptionistService;
import com.sakibul.diagnosticmanagementsystem.model.Receptionist;
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
public class ReceptionistController {
    @Autowired
    ReceptionistService rs;
    @Autowired
    private ServletContext servletContext;
    
    
    @RequestMapping("/addreceptionist")
    public ModelAndView showreceptionistpage() {
        String receptionistgsonlist = rs.showReceptionist();
        
        ModelAndView mv = new ModelAndView("admin/addreceptionist", "addReceptionistObject1", new Receptionist());
        mv.addObject("receptionistmodelobject", receptionistgsonlist);
        
        mv.addObject("check", "true");
        return mv;
    }
    
     @RequestMapping("/receptionistlist")
    public ModelAndView showreceptionistlistpage() {
        String receptionistgsonlist = rs.showReceptionist();
        ModelAndView mv = new ModelAndView("admin/receptionistlist", "addReceptionistObject1", new Receptionist());
        mv.addObject("receptionistmodelobject", receptionistgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    

    @RequestMapping(value = "/addingreceptionist", params = "Addreceptionist")
    public String addreceptionist(@ModelAttribute("addReceptionistObject1") Receptionist rec, HttpServletRequest request) {
        
        rs.insertReceptionist(rec);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\rimage\\" + String.valueOf(rec.getEmailid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = rec.getRimage();
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
       
        return "redirect:/receptionistlist";
    }

    @RequestMapping(value = "/addingreceptionist", params = "EditReceptionist")
    public String editreceptionist(@ModelAttribute("addReceptionistObject1") Receptionist rec, HttpServletRequest request) {

        
        rs.updateReceptionist(rec);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        String p = targetcut + "\\src\\main\\webapp\\resources\\rimage\\" + String.valueOf(rec.getEmailid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = rec.getRimage();
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
        return "redirect:/receptionistlist";
    }

    @RequestMapping("removereceptionist/{Id}")
    public String removereceptionist(@PathVariable("Id") int rid) {
        rs.deleteReceptionist(rid);
        return "redirect:/receptionistlist";
    }

    @RequestMapping("/editreceptionistbutton")
    public ModelAndView passingonereceptionist(@RequestParam("getrid") int rid) {

        Receptionist oner = rs.showOneReceptionist(rid);
        
        String receptionistgsonlist = rs.showReceptionist();
        ModelAndView mv = new ModelAndView("admin/addreceptionist", "addReceptionistObject1", oner);
        mv.addObject("receptionistmodelobject", receptionistgsonlist);
        
        mv.addObject("check", "false");
        return mv;
    }
    
    @RequestMapping("/editreceptionistbuttons")
    public ModelAndView editreceptionist(@RequestParam("getrid") String rid) {

        Receptionist oner = rs.showOneReceptionistbyEmail(rid);
        String doctorgsonlist = rs.showReceptionist();
       
        ModelAndView mv = new ModelAndView("admin/addreceptionist", "addReceptionistObject1", oner);
        mv.addObject("receptionistmodelobject", doctorgsonlist);
        
        mv.addObject("check", "false");
        return mv;
    }
}
