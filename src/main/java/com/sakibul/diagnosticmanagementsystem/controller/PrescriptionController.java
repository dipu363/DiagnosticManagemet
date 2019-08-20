/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.AppointmentsService;
import com.sakibul.diagnosticmanagementsystem.dao.DoctorService;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinegroupService;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinelistService;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinetypeService;
import com.sakibul.diagnosticmanagementsystem.dao.PatientService;
import com.sakibul.diagnosticmanagementsystem.dao.PrescriptionService;
import com.sakibul.diagnosticmanagementsystem.dao.PrescriptiondrugService;
import com.sakibul.diagnosticmanagementsystem.dao.TestService;
import com.sakibul.diagnosticmanagementsystem.dao.TestprescriptionService;
import com.sakibul.diagnosticmanagementsystem.dao.TestreportService;
import com.sakibul.diagnosticmanagementsystem.dao.TesttypeService;
import com.sakibul.diagnosticmanagementsystem.dao.ViewPrescriptiondrugService;
import com.sakibul.diagnosticmanagementsystem.model.Cart;
import com.sakibul.diagnosticmanagementsystem.model.Doctor;
import com.sakibul.diagnosticmanagementsystem.model.Patient;
import com.sakibul.diagnosticmanagementsystem.model.Prescription;
import com.sakibul.diagnosticmanagementsystem.model.Prescriptiondrug;
import com.sakibul.diagnosticmanagementsystem.model.TestPrescriptionCart;
import com.sakibul.diagnosticmanagementsystem.model.Testprescription;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Another User
 */
@Controller
public class PrescriptionController {

    @Autowired
    PrescriptionService ps;
    
    @Autowired
    AppointmentsService aps;
    
    @Autowired
    MedecinegroupService ms;
    
    @Autowired
    MedecinetypeService mts;
    
    @Autowired
    MedecinelistService mls;
    
     @Autowired
    DoctorService ds;
     @Autowired
     PrescriptiondrugService pds;
     
     @Autowired
    ViewPrescriptiondrugService vps;
     
     @Autowired
     TesttypeService tts;
    @Autowired
     TestService ts;
    @Autowired
     TestreportService tr;
    @Autowired 
    TestprescriptionService tp;
    @Autowired
    PatientService pts;
    
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "presdate", new CustomDateEditor(format, false));
       // binder.registerCustomEditor(Date.class, "schtime", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    
    @InitBinder
    public void myInitBinders(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "nextconsultdate", new CustomDateEditor(format, false));
       // binder.registerCustomEditor(Date.class, "schtime", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/addprescription")
    public ModelAndView showprescriptionlistpage(HttpSession session) {
        String a= session.getAttribute("UserId").toString();
        Doctor d=ds.showOneDoctorbyEmail(a);
         System.out.println(a);
         System.out.println(d.getDoctorid());
         int doc=d.getDoctorid();
         String appointmentgsonlist = aps.viewPatientAppointment(doc);
        String preslist = ps.showPrescription();
        String apointlist=aps.viewAppointmentsPatient();
        String grouplist=ms.showMedecinegroup();
        String typelist=mts.showMedecinetype();
        String medicinelist=mls.viewMedecine();
        String testreportgsonlist = tr.showTestreport();
        String testgsonlist = ts.showTest();
        String testtypegsonlist = tts.showTesttype();
        String testprescriptionlist=tp.showTestpres();
        String patientlist=pts.viewPatient();
        
        
        ModelAndView mv = new ModelAndView("doctor/addprescription", "newPrescriptionObject", new Prescription());
        mv.addObject("prescriptionlist", preslist);
        mv.addObject("aplist", appointmentgsonlist);
        mv.addObject("appointmentgsonlist", apointlist);
        mv.addObject("grouplist", grouplist);
        mv.addObject("typelist", typelist);
        mv.addObject("medicinelist", medicinelist);
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testreportmodelobject", testreportgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("patientmodelobject", patientlist);
        
     
        mv.addObject("check", "true");
        Gson g = new Gson();
        
        ArrayList<TestPrescriptionCart> cd = (ArrayList<TestPrescriptionCart>) session.getAttribute("testcart");
        if(cd.isEmpty()){
         session.setAttribute("cartsempty", "true");
         mv.addObject("testcart", "null");
       
        }else {
            String cartgson = g.toJson(cd);
            mv.addObject("testcart", cartgson);
            System.out.println(cartgson);
            session.setAttribute("grandtotal", getGrandTotal(cd));
            session.setAttribute("cartsempty", "false");
           
        }

        ArrayList<Cart> c = (ArrayList<Cart>) session.getAttribute("usercart");
        if(c.isEmpty()){
         session.setAttribute("cartempty", "true");
         mv.addObject("itemsincart", "null");
         return mv;
        }else {
            String cartgson = g.toJson(c);
            mv.addObject("itemsincart", cartgson);
            System.out.println(cartgson);
            session.setAttribute("cartempty", "false");
            return mv;
        }
        
       
    }
    
    @RequestMapping("/addtocart")
    public String addingToCart(HttpSession session, @ModelAttribute("newPrescriptionObject") Prescription pres) {

//        String phurchaselist = purchaseService.viewPurchase();
//        String vendorlist = vendor.viewVendorinfo();
//        String products = productdao.viewProduct();
//        ModelAndView mv = new ModelAndView("purchase", "newpurchaseObject", new Purchase());
//        mv.addObject("phurchaselist", phurchaselist);
//        mv.addObject("vendorlist", vendorlist);
//       mv.addObject("products", products);
//        mv.addObject("check", "true");
        //Prescription pm = productdao.viewOneProduct(purchase.getProductid());
        //Purchasedetail pd = purchaseDetailService.viewOnePurchasedetail(productId);
        //Purchase pp = purchaseService.viewOnePurchase(productId);
        //session.setAttribute("productid", productId);
        
        String flag = "not inserted";
        ArrayList<Cart> cartarray = (ArrayList<Cart>) session.getAttribute("usercart");

        if (cartarray.isEmpty()) {
            cartarray.add(new Cart(pres.getGroupid(), pres.getTypeid(),pres.getListid(), pres.getDose(), pres.getDoseschedule(), pres.getDoseadvice()));
            
            flag = "inserted";
        } else {
            Iterator<Cart> lit = cartarray.iterator();
            while (lit.hasNext()) {
                Cart d = lit.next();
                if (d.getListid()== pres.getListid()) {
                    int index = cartarray.indexOf(d);
                    
                    cartarray.remove(index);
                    cartarray.add(index, new Cart(pres.getGroupid(), pres.getTypeid(), pres.getListid(), pres.getDose(), pres.getDoseschedule(),pres.getDoseadvice()));
                    session.setAttribute("usercart", cartarray);
                    flag = "inserted";
                    break;
                }
            }
            if (flag.equals("not inserted")) {
                cartarray.add(new Cart(pres.getGroupid(), pres.getTypeid(), pres.getListid(), pres.getDose(), pres.getDoseschedule(),pres.getDoseadvice()));
                session.setAttribute("usercart", cartarray);
            }
        }
        
//        UserCartDetails usercart = new UserCartDetails();
//        Integer intcart = Integer.parseInt(session.getAttribute("Cartid").toString());
//        usercart.setCartid(Integer.parseInt(session.getAttribute("Cartid").toString()));
//        usercart.setProductsincart(cartarray.toString());
//        cdao.insertCartwithProducts(usercart);
        return "redirect:/addprescription";
    }
    
    @RequestMapping("/prescriptionlist")
    public ModelAndView showprescriptionlistpages() {
        String presdrug=vps.viewPrescriptiondrug();
        ModelAndView mv = new ModelAndView("doctor/prescriptionlist", "newPrescriptionObject", new Prescription());
        mv.addObject("druglist", presdrug);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/preslist")
    public ModelAndView showprescriptionlistpage() {
        String preslist = ps.showPrescription();
        String apointlist=aps.viewAppointmentsPatient();
        String presdrug=vps.viewPrescriptiondrug();
        ModelAndView mv = new ModelAndView("receptionist/prescriptionlist", "newPrescriptionObject", new Prescription());
        mv.addObject("prescriptionlist", preslist);
        mv.addObject("appointmentgsonlist", apointlist);
        mv.addObject("druglist", presdrug);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/presforadmin")
    public ModelAndView showprescriptionadminpage() {
        String preslist = ps.showPrescription();
        String apointlist=aps.viewAppointmentsPatient();
        String presdrug=vps.viewPrescriptiondrug();
        ModelAndView mv = new ModelAndView("admin/prescriptionlist", "newPrescriptionObject", new Prescription());
        mv.addObject("prescriptionlist", preslist);
        mv.addObject("appointmentgsonlist", apointlist);
        mv.addObject("druglist", presdrug);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/showprescription")
    public ModelAndView showPatientprescriptionlistpages(HttpSession session) {
        Patient p=(Patient)session.getAttribute("patientinfo");
        int a=p.getPid();
        System.out.println(a);
       String preslist = ps.patientPrescription(a);
        String apointlist=aps.viewAppointmentsPatient();
        String presdrug=vps.viewPrescriptiondrug(a);
        
        ModelAndView mv = new ModelAndView("patient/prescriptionlist", "newPrescriptionObject", new Prescription());
        mv.addObject("prescriptionlist", preslist);
        mv.addObject("appointmentgsonlist", apointlist);
       mv.addObject("druglist", presdrug);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/prescriptionadd", params = "Add")
    public String addprescriptionpage(@ModelAttribute("newPrescriptionObject") Prescription prescrip, HttpServletRequest request,HttpSession httpSession) {
        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart");
        ps.insertPrescription(prescrip);
        
        Prescriptiondrug prsdrug=new Prescriptiondrug();
        int prid=prsdrug.getPresid();
                
       
        ArrayList<Prescriptiondrug> drugdetail = new ArrayList<Prescriptiondrug>();
        for (Cart cart : c) {
            System.out.println("fast");
            prsdrug.setAppointid(prescrip.getAppointid());
            prsdrug.setDoctorid(prescrip.getDoctorid());
            prsdrug.setPid(prescrip.getPid());
            prsdrug.setPresid(prescrip.getPresid());
            prsdrug.setDose(cart.getDose());
            prsdrug.setDoseadvice(cart.getDoseadvice());
            prsdrug.setDoseschedule(cart.getDoseschedule());
            prsdrug.setGroupid(cart.getGroupid());
            prsdrug.setTypeid(cart.getTypeid());
            prsdrug.setListid(cart.getListid());
            drugdetail.add(prsdrug);
            pds.insertPrescriptiondrug(drugdetail);
            
            
            
            // get product and update quantity
//            Purchasedetail p = purchaseDetailService.viewOnePurchasedetail(cart.getPid());
//            p.setQuantity(p.getQuantity()- cart.getQty());
//            purchaseDetailService.updatePurchasedetail(cart.getPid(), p);

        }
         //purchaseDetailService.insertPurchasedetail(odetail2);
        drugdetail.removeAll(drugdetail);
       httpSession.setAttribute("usercart", new ArrayList<Cart>());
       
       ArrayList<TestPrescriptionCart> cd = (ArrayList<TestPrescriptionCart>) httpSession.getAttribute("testcart");
        
        Testprescription tpa=new Testprescription();
        ArrayList<Testprescription> testdetail = new ArrayList<Testprescription>();
        for (TestPrescriptionCart cart : cd) {
            System.out.println("fast");
            tpa.setPid(prescrip.getPid());
            tpa.setTestid(cart.getTestid());
            tpa.setTypeid(cart.getTypeid());
            tpa.setAmount(cart.getAmount());
            tpa.setDescription(cart.getDescription());
            tpa.setGrandtotal((double)httpSession.getAttribute("grandtotal"));
            testdetail.add(tpa);
            
            tp.insertPrescriptiondrug(testdetail);
           
            
            
            
            // get product and update quantity
//            Purchasedetail p = purchaseDetailService.viewOnePurchasedetail(cart.getPid());
//            p.setQuantity(p.getQuantity()- cart.getQty());
//            purchaseDetailService.updatePurchasedetail(cart.getPid(), p);

        }
        
         //purchaseDetailService.insertPurchasedetail(odetail2);
        drugdetail.removeAll(drugdetail);
       httpSession.setAttribute("testcart", new ArrayList<TestPrescriptionCart>());

        return "redirect:/prescriptionlist";
    }
    
     public double getGrandTotal(ArrayList<TestPrescriptionCart> item){
        double gtotal=0;
        ListIterator<TestPrescriptionCart> itr=item.listIterator();
        while(itr.hasNext()){
            TestPrescriptionCart ob=(TestPrescriptionCart)itr.next();
            gtotal=gtotal+ob.getAmount();
        }
        return gtotal;
    }

    @RequestMapping(value = "/prescriptionadd", params = "Edit")
    public String editPrescription(@ModelAttribute("newPrescriptionObject") Prescription prescrip, HttpServletRequest request,HttpSession httpSession) {
        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart");
        
        ps.updatePrescription(prescrip);
        
         Prescriptiondrug prsdrug=new Prescriptiondrug();
        int prid=prsdrug.getPresid();
                
       
        ArrayList<Prescriptiondrug> drugdetail = new ArrayList<Prescriptiondrug>();
        for (Cart cart : c) {
            System.out.println("fast");
            prsdrug.setAppointid(prescrip.getAppointid());
            prsdrug.setDoctorid(prescrip.getDoctorid());
            prsdrug.setPid(prescrip.getPid());
            prsdrug.setPresid(prescrip.getPresid());
            prsdrug.setDose(cart.getDose());
            prsdrug.setDoseadvice(cart.getDoseadvice());
            prsdrug.setDoseschedule(cart.getDoseschedule());
            prsdrug.setGroupid(cart.getGroupid());
            prsdrug.setTypeid(cart.getTypeid());
            prsdrug.setListid(cart.getListid());
            drugdetail.add(prsdrug);
            pds.insertPrescriptiondrug(drugdetail);
            
            
            
            // get product and update quantity
//            Purchasedetail p = purchaseDetailService.viewOnePurchasedetail(cart.getPid());
//            p.setQuantity(p.getQuantity()- cart.getQty());
//            purchaseDetailService.updatePurchasedetail(cart.getPid(), p);

        }
         //purchaseDetailService.insertPurchasedetail(odetail2);
        drugdetail.removeAll(drugdetail);
       httpSession.setAttribute("usercart", new ArrayList<Cart>());
       
       ArrayList<TestPrescriptionCart> cd = (ArrayList<TestPrescriptionCart>) httpSession.getAttribute("testcart");
        
        Testprescription tpa=new Testprescription();
        ArrayList<Testprescription> testdetail = new ArrayList<Testprescription>();
        for (TestPrescriptionCart cart : cd) {
            System.out.println("fast");
            tpa.setPid(prescrip.getPid());
            tpa.setTestid(cart.getTestid());
            tpa.setTypeid(cart.getTypeid());
            tpa.setAmount(cart.getAmount());
            tpa.setDescription(cart.getDescription());
            testdetail.add(tpa);
            tp.insertPrescriptiondrug(testdetail);
           
            
            
            
            // get product and update quantity
//            Purchasedetail p = purchaseDetailService.viewOnePurchasedetail(cart.getPid());
//            p.setQuantity(p.getQuantity()- cart.getQty());
//            purchaseDetailService.updatePurchasedetail(cart.getPid(), p);

        }
         //purchaseDetailService.insertPurchasedetail(odetail2);
        drugdetail.removeAll(drugdetail);
       httpSession.setAttribute("testcart", new ArrayList<TestPrescriptionCart>());


        return "redirect:/prescriptionlist";
    }
    

    @RequestMapping("/editingprescription")
    public ModelAndView editprescriptionpage(@RequestParam("getpid") int pid, HttpSession session) {
        String a= session.getAttribute("UserId").toString();
        Doctor d=ds.showOneDoctorbyEmail(a);
         System.out.println(a);
         System.out.println(d.getDoctorid());
         int doc=d.getDoctorid();
         String appointmentgsonlist = aps.viewPatientAppointment(doc);
        String preslist = ps.showPrescription();
        String apointlist=aps.viewAppointmentsPatient();
        String grouplist=ms.showMedecinegroup();
        String typelist=mts.showMedecinetype();
        String medicinelist=mls.viewMedecine();
        String testreportgsonlist = tr.showTestreport();
        String testgsonlist = ts.showTest();
        String testtypegsonlist = tts.showTesttype();
        String testprescriptionlist=tp.showTestpres();
        String patientlist=pts.viewPatient();
        ModelAndView mv = new ModelAndView("doctor/addprescription", "newPrescriptionObject", ps.showOnePrescription(pid));
        session.setAttribute("prespdetail", pid);
        mv.addObject("prescriptionlist", preslist);
        mv.addObject("aplist", appointmentgsonlist);
        mv.addObject("appointmentgsonlist", apointlist);
        mv.addObject("grouplist", grouplist);
        mv.addObject("typelist", typelist);
        mv.addObject("medicinelist", medicinelist);
        mv.addObject("testprescriptionmodelobject", testprescriptionlist);
        mv.addObject("testmodelobject", testgsonlist);
        mv.addObject("testreportmodelobject", testreportgsonlist);
        mv.addObject("testtypemodelobject", testtypegsonlist);
        mv.addObject("patientmodelobject", patientlist);
        mv.addObject("check", "false");
        
        Gson g = new Gson();
        
        ArrayList<TestPrescriptionCart> cd = (ArrayList<TestPrescriptionCart>) session.getAttribute("testcart");
        if(cd.isEmpty()){
         session.setAttribute("cartsempty", "true");
         mv.addObject("testcart", "null");
       
        }else {
            String cartgson = g.toJson(cd);
            mv.addObject("testcart", cartgson);
            System.out.println(cartgson);
            session.setAttribute("cartsempty", "false");
           
        }

        ArrayList<Cart> c = (ArrayList<Cart>) session.getAttribute("usercart");
        if(c.isEmpty()){
         session.setAttribute("cartempty", "true");
         mv.addObject("itemsincart", "null");
         return mv;
        }else {
            String cartgson = g.toJson(c);
            mv.addObject("itemsincart", cartgson);
            System.out.println(cartgson);
            session.setAttribute("cartempty", "false");
            return mv;
        }
        
    }

    @RequestMapping("removingprescription/{Id}")
    public String removeprescription(@PathVariable("Id") int prid) {
        ps.deletePrescription(prid);
        return "redirect:/prescriptionlist";
    }
    
    @RequestMapping("/patientprescription")
    public ModelAndView editprescriptionpages(@RequestParam("getpid") int pid, HttpSession session) {
       
        String preslist = ps.showPrescription();
        String apointlist=aps.viewAppointmentsPatient();
        String grouplist=ms.showMedecinegroup();
        String typelist=mts.showMedecinetype();
        String medicinelist=mls.viewMedecine();
        ModelAndView mv = new ModelAndView("doctor/addprescription", "newPrescriptionObject", new Prescription());
        mv.addObject("prescriptionlist", preslist);
        mv.addObject("appointmentgsonlist", apointlist);
        mv.addObject("grouplist", grouplist);
        mv.addObject("typelist", typelist);
        mv.addObject("medicinelist", medicinelist);
        session.setAttribute("patientid", pid);
        return mv;
    }
}
