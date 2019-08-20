/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.PharmacistService;
import com.sakibul.diagnosticmanagementsystem.model.Pharmacist;
import com.sakibul.diagnosticmanagementsystem.model.User;
import com.sakibul.diagnosticmanagementsystem.model.UserRole;
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
public class PharmacistServiceImpl implements PharmacistService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertpharmacist(Pharmacist ph) {
        String status;
        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.getTransaction();
            t.begin();
            User u=new User();
            UserRole ur=new UserRole();
            u.setEmailid(ph.getEmailid());
            u.setUsername(ph.getFname());
            u.setPhone(ph.getPhone());
            
            ur.setEmailid(ph.getEmailid());
            ur.setPassword(ph.getPassword());
            ur.setRole(ph.getRole());
            ur.setStatus(ph.getStatus());
            s.save(ph);
            s.save(u);
            s.save(ur);

            t.commit();
            s.close();
            status = "Success";
            //logger.info("End of insert user method in userservice impl");
        } catch (Exception e) {
            //logger.info("inside catch accept user method in userservice impl");
            e.printStackTrace();
            status = "Fail";
        }
        return status;
    }

    @Override
    public String updatePharmacist(Pharmacist ph) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(ph);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deletePharmacist(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Pharmacist doc = (Pharmacist) s.get(Pharmacist.class, id);
        s.delete(doc);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String showPharmacist() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Pharmacist> categorieslist = s.createQuery("from Pharmacist").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

    @Override
    public Pharmacist showOnePharmacist(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Pharmacist cm = (Pharmacist) s.get(Pharmacist.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }

    @Override
    public Pharmacist showOnePharmacistbyEmail(String email) {
        Session s = sessionFactory.openSession();
        Pharmacist ph = new Pharmacist();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Pharmacist u where emailid=?");

        List<Pharmacist> rinfo = q.setParameter(0, email).list();

        t.commit();
        s.close();
        return rinfo.get(0);
    }

    @Override
    public int showallPharmacist() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Pharmacist> st = s.createQuery("from Pharmacist").list();
        int a=st.size();
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return a;
    }
    
}
