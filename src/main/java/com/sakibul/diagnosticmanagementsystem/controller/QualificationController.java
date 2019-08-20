/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;


import com.sakibul.diagnosticmanagementsystem.dao.QualificationService;
import com.sakibul.diagnosticmanagementsystem.model.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class QualificationController {
    @Autowired
     QualificationService qs;

    @RequestMapping("/addqualification")
    public ModelAndView showqualificationpage() {
        String qualificationgsonlist = qs.showQualification();
        ModelAndView mv = new ModelAndView("qualification", "addQualificationObject1", new Qualification());
        mv.addObject("qualificationmodelobject", qualificationgsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingqualification", params = "Addqualification")
    public String addqualification(@ModelAttribute("addQualificationObject1") Qualification cm) {
        
        qs.insertQualification(cm);
       
        return "redirect:/addqualification";
    }

    @RequestMapping(value = "/addingqualification", params = "EditQualification")
    public String editQualification(@ModelAttribute("addQualificationObject1") Qualification dept) {

        
        qs.updateQualification(dept);
        return "redirect:/addqualification";
    }

    @RequestMapping("removequalification/{Id}")
    public String removedepartment(@PathVariable("Id") int qId) {
        qs.deleteQualification(qId);
        return "redirect:/addqualification";
    }

    @RequestMapping("/editqualificationbutton")
    public ModelAndView passingoneQualification(@RequestParam("getqid") int qid) {

        Qualification onequalification = qs.showOneQualification(qid);
        String qualificationgsonlist = qs.showQualification();
        ModelAndView mv = new ModelAndView("qualification", "addQualificationObject1", onequalification);
        mv.addObject("qualificationmodelobject", qualificationgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
