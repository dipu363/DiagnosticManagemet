/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.AddmissionService;
import com.sakibul.diagnosticmanagementsystem.model.Addmission;
import com.sakibul.diagnosticmanagementsystem.model.Paymentinfo;
import com.sakibul.diagnosticmanagementsystem.model.Room;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sakib
 */
@Repository
public class AdmissionServiceImpl implements AddmissionService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertAddmission(Addmission add) {
        System.out.println(add.getTotalcost());
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Room oneroomobject = (Room) s.get(Room.class, add.getRoomid());
        oneroomobject.setStatus("Unavailable");
        Paymentinfo onepaymentobject = (Paymentinfo) s.get(Paymentinfo.class, add.getPid());
        onepaymentobject.setAdmissionfees(add.getTotalcost());
        onepaymentobject.setAddid(add.getAddid());
        onepaymentobject.setStatus("Pending");
        List<Paymentinfo> payinfo = s.createQuery("select u from Paymentinfo u where pid=?").setParameter(0, add.getPid()).list();
        if (payinfo.size() > 0) {
            s.update(onepaymentobject);
        } else {
            s.save(onepaymentobject);
        }

        s.update(oneroomobject);
        s.save(add);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateAddmission(Addmission add) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();

        s.update(add);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteAddmission(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Addmission cm = (Addmission) s.get(Addmission.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String showAddmission() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Addmission> categorieslist = s.createQuery("from Addmission").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();

        return categorylistgson;
    }

    @Override
    public Addmission showOneAddmission(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Addmission cm = (Addmission) s.get(Addmission.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }

    @Override
    public Addmission showPaymentAddmission(int id) {
        Session s = sessionFactory.openSession();
        Addmission tp = new Addmission();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Addmission u where pid=? and billstatus='True'");

        List<Addmission> addinfo = q.setParameter(0, id).list();

        t.commit();
        s.close();
        if (addinfo.size() > 0) {
            return addinfo.get(0);
        } else {
            return null;
        }

    }

    @Override
    public String showAddmissionBill() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Addmission> admissionlist = s.createQuery("select u from Addmission u where billstatus='True'").list();
        Gson g = new Gson();
        String admissionlistgson = g.toJson(admissionlist);
        t.commit();
        s.close();
        return admissionlistgson;
    }

}
