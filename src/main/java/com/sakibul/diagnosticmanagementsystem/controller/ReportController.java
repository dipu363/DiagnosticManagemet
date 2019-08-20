/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;

import com.sakibul.diagnosticmanagementsystem.dao.AppointmentsService;
import com.sakibul.diagnosticmanagementsystem.dao.PaymentinfoService;
import com.sakibul.diagnosticmanagementsystem.dao.PrescriptionService;
import com.sakibul.diagnosticmanagementsystem.dao.TestprescriptionService;
import com.sakibul.diagnosticmanagementsystem.dao.TestreportService;
import com.sakibul.diagnosticmanagementsystem.daoimpl.JasperReportDao;
import com.sakibul.diagnosticmanagementsystem.model.Appointments;
import com.sakibul.diagnosticmanagementsystem.model.Paymentinfo;
import com.sakibul.diagnosticmanagementsystem.model.Prescription;
import com.sakibul.diagnosticmanagementsystem.model.Testprescription;
import com.sakibul.diagnosticmanagementsystem.model.Testreport;
import com.sakibul.diagnosticmanagementsystem.reportmodel.AppointmentBill;
import com.sakibul.diagnosticmanagementsystem.reportmodel.AppointmentReport;
import com.sakibul.diagnosticmanagementsystem.reportmodel.BillReport;
import com.sakibul.diagnosticmanagementsystem.reportmodel.PaymentReport;
import com.sakibul.diagnosticmanagementsystem.reportmodel.PrescriptionReport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sakib
 */
@Controller
public class ReportController {
    
    @Autowired
    AppointmentsService aps;
    
    @Autowired
    PaymentinfoService ps;
    
    @Autowired
    PrescriptionService prs;
    
    @Autowired
    TestprescriptionService tps;
    
    @Autowired
     TestreportService tr;
    
    @RequestMapping(value = "/reportView", method = RequestMethod.GET)
    public String loadSurveyPg(
            @ModelAttribute("reportInputForm") AppointmentReport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "admin/report";
    }
    
    @RequestMapping(value = "/reportView", method = RequestMethod.POST)
    public String generateReport(@ModelAttribute("reportInputForm") AppointmentReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "appointmentlist";
        JasperReportDao jrdao = new JasperReportDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String sdate = reportInputForm.getSdate();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("sdate", sdate);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
   
    
    @RequestMapping(value = "/appointmentreportView", method = RequestMethod.GET)
    public ModelAndView loadreportPg( @ModelAttribute("reportInputForm") AppointmentBill reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        String billlist = aps.viewPendingPatient();
        ModelAndView mv = new ModelAndView("accountant/appointmentbill", "addPaymentObject1", new Paymentinfo());
        mv.addObject("billlistobject", billlist);
        return mv;
    }
    
    @RequestMapping(value = "/reportappointmentView", method = RequestMethod.POST)
    public String generateAppointReport(@ModelAttribute("reportInputForm") AppointmentBill reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "appointmentbill";
        JasperReportDao jrdao = new JasperReportDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String pid = reportInputForm.getPatientid();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("patientid", pid);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
     @RequestMapping(value = "/totalreportView", method = RequestMethod.GET)
    public ModelAndView loadadmissionreportPg( @ModelAttribute("reportInputForm") BillReport reportInputForm, Model model, @RequestParam("getpayid") int payid) {
        model.addAttribute("reportInputForm", reportInputForm);
        String billlist = ps.patienttotalbill(payid);
        ModelAndView mv = new ModelAndView("accountant/billdetails", "addPaymentObject1", new Paymentinfo());
        mv.addObject("billlistobject", billlist);
        
        return mv;
    }
    
    @RequestMapping(value = "/reporttotalView", method = RequestMethod.POST)
    public String generatetotalReport(@ModelAttribute("reportInputForm") BillReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        int a=Integer.parseInt(reportInputForm.getPayid());
        ps.updatePaymentinfo(a);
        
        String reportFileName = "paymentreport";
        JasperReportDao jrdao = new JasperReportDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String pid = reportInputForm.getPayid();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("payid", pid);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    
    @RequestMapping(value = "/presreportView", method = RequestMethod.GET)
    public ModelAndView loadPrescriptionPg(
            @ModelAttribute("reportInputForm") PrescriptionReport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        String preslist = prs.showPenPrescription();
        ModelAndView mv = new ModelAndView("receptionist/prescriptionreport", "addPrescriptionObject1", new Prescription());
        mv.addObject("preslistobject", preslist);
        
        return mv;
    }
    
    @RequestMapping(value = "/presreportView", method = RequestMethod.POST)
    public String generatePresReport(@ModelAttribute("reportInputForm") PrescriptionReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "prescription";
        
        
        JasperReportDao jrdao = new JasperReportDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String pid = reportInputForm.getPid();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("prespid", pid);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 
            

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    prs.updatePrescriptionstatus(reportInputForm.getPresid());
            System.out.println("lsakfaksflkajksjdf"+reportInputForm.getPresid());
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    @RequestMapping(value = "/testpresreportView", method = RequestMethod.GET)
    public ModelAndView loadTestPrescriptionPg(
            @ModelAttribute("reportInputForm") PrescriptionReport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        String preslist = tps.showTestpres();
        ModelAndView mv = new ModelAndView("receptionist/testpresreport", "addTestprescriptionObject1", new Testprescription());
        mv.addObject("testpreslistobject", preslist);
        
        return mv;
    }
    
    @RequestMapping(value = "/testpresreportView", method = RequestMethod.POST)
    public String generateTestPresReport(@ModelAttribute("reportInputForm") PrescriptionReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "testprescription";
        
        
        JasperReportDao jrdao = new JasperReportDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String pid = reportInputForm.getPid();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("tprespid", pid);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 
            

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    prs.updatePrescriptionstatus(reportInputForm.getPresid());
            System.out.println("lsakfaksflkajksjdf"+reportInputForm.getPresid());
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    @RequestMapping(value = "/testreportView", method = RequestMethod.GET)
    public ModelAndView loadTestreportPg(
            @ModelAttribute("reportInputForm") PrescriptionReport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        String preslist = tr.showTestreport();
        ModelAndView mv = new ModelAndView("receptionist/printtestreport", "addTestreportObject1", new Testreport());
        mv.addObject("testpreslistobject", preslist);
        
        return mv;
    }
    
    @RequestMapping(value = "/testreportView", method = RequestMethod.POST)
    public String generatetestReport(@ModelAttribute("reportInputForm") PrescriptionReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "testreport";
        
        
        JasperReportDao jrdao = new JasperReportDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String pid = reportInputForm.getPid();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("tprespid", pid);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 
            

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    prs.updatePrescriptionstatus(reportInputForm.getPresid());
            System.out.println("lsakfaksflkajksjdf"+reportInputForm.getPresid());
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    @RequestMapping(value = "/paymentreportView", method = RequestMethod.GET)
    public String loadpaymentreportPg(
            @ModelAttribute("reportInputForm") PaymentReport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "admin/paymentreport";
    }
    
    @RequestMapping(value = "/paymentreportView", method = RequestMethod.POST)
    public String generatePaymentReport(@ModelAttribute("reportInputForm") PaymentReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "payment";
        JasperReportDao jrdao = new JasperReportDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String sdate = reportInputForm.getStartdate();
            String edate = reportInputForm.getEnddate();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("startdate", sdate);
            hmParams.put("enddate", edate);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    
    @RequestMapping(value = "/printprescription")
    public String generatePresReport(@ModelAttribute("reportInputForm") PaymentReport reportInputForm,HttpServletRequest request,HttpServletResponse response,@RequestParam("getpid") int pid) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "finalprescription";
        JasperReportDao jrdao = new JasperReportDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("patientid", pid);
            
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    
    @RequestMapping(value = "/testreport")
    public String generateTestReport(@ModelAttribute("reportInputForm") PaymentReport reportInputForm,HttpServletRequest request,HttpServletResponse response,@RequestParam("getpid") int pid) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "testreport";
        JasperReportDao jrdao = new JasperReportDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("tprespid", pid);
            
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    
    
}
