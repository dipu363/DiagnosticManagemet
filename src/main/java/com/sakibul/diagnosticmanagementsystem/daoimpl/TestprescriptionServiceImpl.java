/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.TestprescriptionService;
import com.sakibul.diagnosticmanagementsystem.model.Paymentinfo;
import com.sakibul.diagnosticmanagementsystem.model.Prescription;
import com.sakibul.diagnosticmanagementsystem.model.Testprescription;
import java.util.ArrayList;
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
public class TestprescriptionServiceImpl implements TestprescriptionService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertTestpres(Testprescription tp) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        

        s.save(tp);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateTestpres(Testprescription tp) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();

        s.update(tp);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteTestpres(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Testprescription cm = (Testprescription) s.get(Testprescription.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String showTestpres() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Testprescription> testprescriptionlist = s.createQuery("from Testprescription").list();
        Gson g = new Gson();
        String testpreslistgson = g.toJson(testprescriptionlist);
        t.commit();
        s.close();

        return testpreslistgson;
    }

    @Override
    public Testprescription showOneTestpres(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Testprescription cm = (Testprescription) s.get(Testprescription.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String testpreslistgson = g.toJson(cm);
        return cm;
    }

    @Override
    public String showAvailableTest() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Testprescription> testlist = s.createQuery("from Testprescription where status='Pending'").list();
        Gson g = new Gson();
        String testlistgson = g.toJson(testlist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return testlistgson;
    }

    @Override
    public String showPatientTestpres(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Testprescription> testprescriptionlist = s.createQuery("from Testprescription where pid=?").setParameter(0, id).list();
        Gson g = new Gson();
        String testpreslistgson = g.toJson(testprescriptionlist);
        t.commit();
        s.close();

        return testpreslistgson;
    }

    @Override
    public  Testprescription showBillTest(int id) {
         Session s = sessionFactory.openSession();
        Testprescription tp = new Testprescription();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Testprescription u where pid=? and status='Pending'");

        List<Testprescription> testinfo = q.setParameter(0, id).list();

        t.commit();
        s.close();
        if(testinfo.size()>0){
            return testinfo.get(0);
        }else{
            return null;
        }
        
    }

    @Override
    public String insertPrescriptiondrug(ArrayList<Testprescription> presdetail) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        for (Testprescription pdetails : presdetail) {
            s.save(pdetails);
        }
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updatepayinfo(double total, Prescription ps) {
        
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Query q=s.createQuery("update Paymentinfo set testcost=? where pid=?").setParameter(0, total).setParameter(1, ps.getPid());
        q.executeUpdate();
        t.commit();
        s.close();
        return null;
    }

}
