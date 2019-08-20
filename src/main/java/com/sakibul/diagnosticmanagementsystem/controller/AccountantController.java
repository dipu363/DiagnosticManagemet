/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.AccountantService;
import com.sakibul.diagnosticmanagementsystem.model.Accountant;
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
public class AccountantController {
    @Autowired
    AccountantService acs;
    @Autowired
    private ServletContext servletContext;
    
    @RequestMapping("/addaccountant")
    public ModelAndView showaccountantpage() {
        String accountantgsonlist = acs.showAccountant();
        
        ModelAndView mv = new ModelAndView("admin/addaccountant", "addAccountantObject1", new Accountant());
        mv.addObject("accountantmodelobject", accountantgsonlist);
        
        mv.addObject("check", "true");
        return mv;
    }
    
     @RequestMapping("/accountantlist")
    public ModelAndView showaccountantlistpage() {
        String accountantgsonlist = acs.showAccountant();
        ModelAndView mv = new ModelAndView("admin/accountantlist", "addAccountantObject1", new Accountant());
        mv.addObject("accountantmodelobject", accountantgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    

    @RequestMapping(value = "/addingaccountant", params = "Addaccountant")
    public String addaccountant(@ModelAttribute("addAccountantObject1") Accountant acc, HttpServletRequest request) {
        
        acs.insertAccountant(acc);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\aimage\\" + String.valueOf(acc.getEmailid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = acc.getAimage();
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

    @RequestMapping(value = "/addingaccountant", params = "EditAccountant")
    public String editaccountant(@ModelAttribute("addAccountantObject1") Accountant acc, HttpServletRequest request) {

        
        acs.updateAccountant(acc);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        String p = targetcut + "\\src\\main\\webapp\\resources\\aimage\\" + String.valueOf(acc.getEmailid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = acc.getAimage();
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

    @RequestMapping("removeaccountant/{Id}")
    public String removeaccountant(@PathVariable("Id") int aid) {
        acs.deleteAccountant(aid);
        return "redirect:/accountantlist";
    }

    @RequestMapping("/editaccountantbutton")
    public ModelAndView passingoneaccountant(@RequestParam("getaid") int aid) {

        Accountant oner = acs.showOneAccountant(aid);
        
        String accountantgsonlist = acs.showAccountant();
        ModelAndView mv = new ModelAndView("admin/addaccountant", "addAccountantObject1", oner);
        mv.addObject("accountantmodelobject", accountantgsonlist);
        
        mv.addObject("check", "false");
        return mv;
    }
    
    @RequestMapping("/editaccountantbuttons")
    public ModelAndView editaccountant(@RequestParam("getaid") String aid) {

        Accountant oner = acs.showOneAccountantbyEmail(aid);
        String accountantgsonlist = acs.showAccountant();
       
        ModelAndView mv = new ModelAndView("admin/addaccountant", "addAccountantObject1", oner);
        mv.addObject("accountantmodelobject", accountantgsonlist);
        
        mv.addObject("check", "false");
        return mv;
    }
}
