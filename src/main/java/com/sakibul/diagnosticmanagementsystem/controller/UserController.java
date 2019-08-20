/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;



import com.sakibul.diagnosticmanagementsystem.dao.Userservice;
import com.sakibul.diagnosticmanagementsystem.model.User;
import com.sakibul.diagnosticmanagementsystem.model.UserRole;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    Userservice us;
    
     @Autowired
    private ServletContext servletContext;
            
    
    @RequestMapping("/signup")
    public ModelAndView signUpPage() {
        ModelAndView mv = new ModelAndView("admin/addadmin");
        mv.addObject("urm", new User());
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping(value= "/reguser", method = RequestMethod.POST)
    public ModelAndView reguser(@ModelAttribute("urm") User urm1,HttpServletRequest request) {
        String result = us.insertUser(urm1);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\adminimage\\" + String.valueOf(urm1.getEmailid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = urm1.getAdminimage();
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
            ModelAndView mv = new ModelAndView("admin/welcome");
            mv.addObject(result, "success");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("admin/signup");
            mv.addObject(result, "fail");
            return mv;
        }
        
        
        
    }
    
    @RequestMapping("/users")
    public ModelAndView showuserpage() {
        String usergsonlist = us.viewUsers();
        ModelAndView mv = new ModelAndView("admin/adminlist", "addUserObject1", new UserRole());
        mv.addObject("usermodelobject", usergsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
     @RequestMapping("removeuser/{emailid}")
    public String removeuser(@PathVariable("emailid") String umail) {
         System.out.println(umail);
        us.deleteUser(umail);
        return "redirect:/users";
    }
}
