/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.PrescriptionService;
import com.sakibul.diagnosticmanagementsystem.model.Appointments;
import com.sakibul.diagnosticmanagementsystem.model.Prescription;
import com.sakibul.diagnosticmanagementsystem.model.Prescriptiondrug;
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
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPrescription(Prescription pres) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(pres);
        
        Appointments oneappointobject = (Appointments) s.get(Appointments.class, pres.getAppointid());
        oneappointobject.setAppointstatus("Ok");
        
         s.update(oneappointobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deletePrescription(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Prescription pm = (Prescription) s.get(Prescription.class, id);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String showPrescription() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Prescription> productslist = s.createQuery("from Prescription").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Prescription showOnePrescription(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Prescription pm = (Prescription) s.get(Prescription.class, id);
        t.commit();
        s.close();
        return pm;
    }

    @Override
    public String updatePrescription(Prescription pres) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Prescription ps=new Prescription();
        ps.setAppointid(pres.getAppointid());
        ps.setDoctorid(pres.getDoctorid());
        ps.setPid(pres.getPid());
        ps.setPresdate(pres.getPresdate());
        ps.setNextconsultdate(pres.getNextconsultdate());
        ps.setRemarks(pres.getRemarks());
        s.update(ps);
        
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String patientPrescription(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Prescription> productslist = s.createQuery("from Prescription where pid=?").setParameter(0, id).list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public String showPenPrescription() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Prescription> productslist = s.createQuery("from Prescription where reportstatus='True'").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public String updatePrescriptionstatus(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Prescription onemedecineobject = (Prescription) s.get(Prescription.class, id);
        onemedecineobject.setReportstatus("False");
        
        s.update(onemedecineobject);
        t.commit();
        s.close();
        return null;
    }

}
