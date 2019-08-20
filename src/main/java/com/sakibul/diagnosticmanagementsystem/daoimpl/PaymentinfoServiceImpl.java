/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.PaymentinfoService;
import com.sakibul.diagnosticmanagementsystem.model.Addmission;
import com.sakibul.diagnosticmanagementsystem.model.Appointments;
import com.sakibul.diagnosticmanagementsystem.model.Paymentinfo;
import com.sakibul.diagnosticmanagementsystem.model.Test;
import com.sakibul.diagnosticmanagementsystem.model.Testprescription;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Another User
 */
@Repository
public class PaymentinfoServiceImpl implements PaymentinfoService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPaymentinfo(Paymentinfo add) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(add);
        if (add.getAppointid() > 0) {
            Appointments oneappointobject = (Appointments) s.get(Appointments.class, add.getAppointid());
            oneappointobject.setBillstatus("False");
            s.update(oneappointobject);
        }
        if (add.getAddid() > 0) {
            Addmission oneappointobject = (Addmission) s.get(Addmission.class, add.getAddid());
            oneappointobject.setBillstatus("False");
            s.update(oneappointobject);
        }
        if(add.getTestid()>0){
            Testprescription oneappointobject = (Testprescription) s.get(Testprescription.class, add.getTestid());
            oneappointobject.setStatus("False");
            s.update(oneappointobject);
        }

        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updatePaymentinfo(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Paymentinfo onemedecineobject = (Paymentinfo) s.get(Paymentinfo.class, id);
        onemedecineobject.setStatus("Paid");
        
        s.update(onemedecineobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deletePaymentinfo(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Paymentinfo cm = (Paymentinfo) s.get(Paymentinfo.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String showPaymentinfo() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Paymentinfo> categorieslist = s.createQuery("from Paymentinfo where status='Unpaid'").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();

        return categorylistgson;
    }

    @Override
    public Paymentinfo showOnePaymentinfo(int id) {
        Session s = sessionFactory.openSession();

        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Paymentinfo u where pid=?");

        List<Paymentinfo> payinfo = q.setParameter(0, id).list();

        t.commit();
        s.close();
        return payinfo.get(0);
    }

    @Override
    public String patientbill(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Paymentinfo> paymentlist = s.createQuery("select u from Paymentinfo u where pid=?").setParameter(0, id).list();
        Gson g = new Gson();
        String productslistgson = g.toJson(paymentlist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public String showPendingPaymentinfo() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Paymentinfo> categorieslist = s.createQuery("SELECT addmission.totalcost, appointments.fees,addmission.addid,appointments.appointid,testprescription.presid, testprescription.amount FROM (diagnostic.appointments appointments INNER JOIN diagnostic.addmission addmission ON (appointments.pid = addmission.pid)) INNER JOIN diagnostic.testprescription testprescription ON (testprescription.pid = appointments.pid) where status='Pending'").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();

        return categorylistgson;
    }

    @Override
    public String patienttotalbill(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Paymentinfo> paymentlist = s.createQuery("select u from Paymentinfo u where payid=?").setParameter(0, id).list();
        Gson g = new Gson();
        String paymentlistgson = g.toJson(paymentlist);
        t.commit();
        s.close();
        return paymentlistgson;
    }

    @Override
    public String updatePaymentinfo(Paymentinfo payinfo) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        
        s.update(payinfo);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String showAllPaymentinfo() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Paymentinfo> categorieslist = s.createQuery("from Paymentinfo").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();

        return categorylistgson;
    }

}
