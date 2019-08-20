/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Paymentinfo;
import org.springframework.stereotype.Service;

/**
 *
 * @author Another User
 */
@Service
public interface PaymentinfoService {

    public String insertPaymentinfo(Paymentinfo add);

    public String updatePaymentinfo(int id);
    
    public String updatePaymentinfo(Paymentinfo payinfo);

    public String deletePaymentinfo(int id);

    public String showPaymentinfo();
    
    public String showAllPaymentinfo();

    public String showPendingPaymentinfo();

    public Paymentinfo showOnePaymentinfo(int id);

    public String patientbill(int id);

    public String patienttotalbill(int id);
    
}
