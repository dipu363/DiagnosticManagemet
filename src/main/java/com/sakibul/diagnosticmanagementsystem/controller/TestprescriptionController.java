/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.PatientService;
import com.sakibul.diagnosticmanagementsystem.dao.TestService;
import com.sakibul.diagnosticmanagementsystem.dao.TestprescriptionService;
import com.sakibul.diagnosticmanagementsystem.dao.TestreportService;
import com.sakibul.diagnosticmanagementsystem.dao.TesttypeService;
import com.sakibul.diagnosticmanagementsystem.model.Cart;
import com.sakibul.diagnosticmanagementsystem.model.Patient;
import com.sakibul.diagnosticmanagementsystem.model.Prescription;
import com.sakibul.diagnosticmanagementsystem.model.TestPrescriptionCart;
import com.sakibul.diagnosticmanagementsystem.model.Testprescription;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class TestprescriptionController {
    @Autowired
     TesttypeService ds;
    @Autowired
     TestService ts;
    @Autowired
     TestreportService tr;
    @Autowired 
    TestprescriptionService tp;
    @Autowired
    PatientService ps;
    
    @RequestMapping("/addtestprescription")
    public ModelAndView showtestreportpage(HttpSession session) {
        String testreportgsonlist = tr.showTestreport();
        String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        String testprescriptionlist=tp.showTestpres();
        String patientlist=ps.viewPatient();
        ModelAndView mv = new ModelAndView("doctor/addtestprescription", "addTestprescriptionObject1", new Testprescription());
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testreportmodelobject", testreportgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("patientmodelobject", patientlist);
        mv.addObject("check", "true");
        Gson g = new Gson();

        ArrayList<TestPrescriptionCart> c = (ArrayList<TestPrescriptionCart>) session.getAttribute("testcart");
        if(c.isEmpty()){
         session.setAttribute("cartsempty", "true");
         mv.addObject("testcart", "null");
         return mv;
        }else {
            String cartgson = g.toJson(c);
            mv.addObject("testcart", cartgson);
            System.out.println(cartgson);
            
            session.setAttribute("cartsempty", "false");
            return mv;
        }
        
      
    }
    
   
    
    @RequestMapping("/removetestitem")
    public String removeproductitem(@RequestParam("testid") int testid, HttpSession session) {
        @SuppressWarnings("unchecked")
        ArrayList<TestPrescriptionCart> cartitems = (ArrayList<TestPrescriptionCart>) session.getAttribute("testcart");
        Iterator<TestPrescriptionCart> list = (Iterator<TestPrescriptionCart>) cartitems.iterator();
        while (list.hasNext()) {
            TestPrescriptionCart c = list.next();
            if (c.getTestid()== testid) {
                cartitems.remove(cartitems.indexOf(c));
                break;
            }
        }
        
        session.setAttribute("testcart", cartitems);
        return "redirect:/addtestprescription";
    }
    
    
    @RequestMapping("/addtesttocart")
    public String addingToCart(HttpSession session, @ModelAttribute("newPrescriptionObject") Prescription pres) {

        
        String flag = "not inserted";
        ArrayList<TestPrescriptionCart> cartarray = (ArrayList<TestPrescriptionCart>) session.getAttribute("testcart");

        if (cartarray.isEmpty()) {
            cartarray.add(new TestPrescriptionCart(pres.getPid(),pres.getTestid(), pres.getTypeid(),pres.getDescription(), pres.getAmount()));
            
            flag = "inserted";
        } else {
            Iterator<TestPrescriptionCart> lit = cartarray.iterator();
            while (lit.hasNext()) {
                TestPrescriptionCart d = lit.next();
                if (d.getTestid()== pres.getTestid()) {
                    int index = cartarray.indexOf(d);
                    
                    cartarray.remove(index);
                    cartarray.add(index, new TestPrescriptionCart(pres.getPid(),pres.getTestid(), pres.getTypeid(), pres.getDescription(),pres.getAmount()));
                    session.setAttribute("testcart", cartarray);
                    flag = "inserted";
                    break;
                }
            }
            if (flag.equals("not inserted")) {
                cartarray.add(new TestPrescriptionCart(pres.getPid(),pres.getTestid(), pres.getTypeid(), pres.getDescription(), pres.getAmount()));
                session.setAttribute("testcart", cartarray);
            }
        }
        
//        UserCartDetails usercart = new UserCartDetails();
//        Integer intcart = Integer.parseInt(session.getAttribute("Cartid").toString());
//        usercart.setCartid(Integer.parseInt(session.getAttribute("Cartid").toString()));
//        usercart.setProductsincart(cartarray.toString());
//        cdao.insertCartwithProducts(usercart);
        return "redirect:/addprescription";
    }
    
     @RequestMapping("/testprescriptionlist")
    public ModelAndView showmedecinetypepages() {
         String testreportgsonlist = tr.showTestreport();
        String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        String testprescriptionlist=tp.showTestpres();
        String patientlist=ps.viewPatient();
        ModelAndView mv = new ModelAndView("doctor/testprescriptionlist", "addTestprescriptionObject1", new Testprescription());
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testreportmodelobject", testreportgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("patientmodelobject", patientlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/testpreslist")
    public ModelAndView showtestprespages() {
        
        String testprescriptionlist=tp.showTestpres();
       
        ModelAndView mv = new ModelAndView("receptionist/testprescriptionlist", "addTestprescriptionObject1", new Testprescription());
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
      
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/testprescriptionlists")
    public ModelAndView showtestpresadminpages() {
        
        String testprescriptionlist=tp.showTestpres();
       
        ModelAndView mv = new ModelAndView("admin/testprescriptionlist", "addTestprescriptionObject1", new Testprescription());
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
      
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/pendingtestreport")
    public ModelAndView showpendingtestpages() {
        
        String testprescriptionlist=tp.showTestpres();
       
        ModelAndView mv = new ModelAndView("pharmacist/testprescriptionlist", "addTestprescriptionObject1", new Testprescription());
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
       
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/showtestprescription")
    public ModelAndView showpatienttprespages(HttpSession session) {
         Patient p=(Patient)session.getAttribute("patientinfo");
       int a=p.getPid();
        String testprescriptionlist=tp.showPatientTestpres(a);
        
        ModelAndView mv = new ModelAndView("patient/viewtestprescription", "addTestprescriptionObject1", new Testprescription());
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingtestprescription", params = "Add")
    public String addmedecinetype(@ModelAttribute("addTestprescriptionObject1") Testprescription cm, HttpServletRequest request,HttpSession httpSession) {
        ArrayList<TestPrescriptionCart> c = (ArrayList<TestPrescriptionCart>) httpSession.getAttribute("testcart");
        
        Testprescription tpa=new Testprescription();
        ArrayList<Testprescription> drugdetail = new ArrayList<Testprescription>();
        for (TestPrescriptionCart cart : c) {
            System.out.println("fast");
            tpa.setPid(cm.getPid());
            tpa.setTestid(cart.getTestid());
            tpa.setTypeid(cart.getTypeid());
            tpa.setAmount(cart.getAmount());
            tpa.setDescription(cart.getDescription());
            drugdetail.add(tpa);
            tp.insertPrescriptiondrug(drugdetail);
           
            
            
            
            // get product and update quantity
//            Purchasedetail p = purchaseDetailService.viewOnePurchasedetail(cart.getPid());
//            p.setQuantity(p.getQuantity()- cart.getQty());
//            purchaseDetailService.updatePurchasedetail(cart.getPid(), p);

        }
         //purchaseDetailService.insertPurchasedetail(odetail2);
        drugdetail.removeAll(drugdetail);
       httpSession.setAttribute("testcart", new ArrayList<TestPrescriptionCart>());
        
       
        return "redirect:/testprescriptionlist";
    }

    @RequestMapping(value = "/addingtestprescription", params = "Edit")
    public String editmedecinetype(@ModelAttribute("addTestprescriptionObject1") Testprescription tpr) {

        
        tp.updateTestpres(tpr);
        return "redirect:/testprescriptionlist";
    }

    @RequestMapping("removetestprescription/{Id}")
    public String removemedecinetype(@PathVariable("Id") int deptId) {
        tp.deleteTestpres(deptId);
        return "redirect:/testprescriptionlist";
    }

    @RequestMapping("/edittestprescriptionbutton")
    public ModelAndView passingonedepartment(@RequestParam("getpresid") int presid) {
        Testprescription oneprescription = tp.showOneTestpres(presid);
        String testprescriptionlist=tp.showTestpres();
        String testgsonlist = ts.showTest();
        String testtypegsonlist = ds.showTesttype();
        String testreportgsonlist = tr.showTestreport();
        String patientlist=ps.viewPatient();
        ModelAndView mv = new ModelAndView("doctor/addtestprescription", "addTestprescriptionObject1", oneprescription);
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        mv.addObject("testreportmodelobject", testreportgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("patientmodelobject", patientlist);
        mv.addObject("check", "false");
        return mv;
    }
}
