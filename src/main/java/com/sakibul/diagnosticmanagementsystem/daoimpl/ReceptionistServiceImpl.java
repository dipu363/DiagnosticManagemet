/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.ReceptionistService;
import com.sakibul.diagnosticmanagementsystem.model.Receptionist;
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
public class ReceptionistServiceImpl implements ReceptionistService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertReceptionist(Receptionist rcp) {
        String status;
        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.getTransaction();
            t.begin();
            User u=new User();
            UserRole ur=new UserRole();
            u.setEmailid(rcp.getEmailid());
            u.setUsername(rcp.getFname());
            u.setPhone(rcp.getPhone());
            
            ur.setEmailid(rcp.getEmailid());
            ur.setPassword(rcp.getPassword());
            ur.setRole(rcp.getRole());
            ur.setStatus(rcp.getStatus());
            s.save(rcp);
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
    public String updateReceptionist(Receptionist rcp) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(rcp);
        t.commit();
        s.close();
        return null;

    }

    @Override
    public String deleteReceptionist(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Receptionist doc = (Receptionist) s.get(Receptionist.class, id);
        s.delete(doc);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String showReceptionist() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Receptionist> categorieslist = s.createQuery("from Receptionist").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

    @Override
    public Receptionist showOneReceptionist(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Receptionist cm = (Receptionist) s.get(Receptionist.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }

    @Override
    public Receptionist showOneReceptionistbyEmail(String email) {
        Session s = sessionFactory.openSession();
        Receptionist doc = new Receptionist();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Receptionist u where emailid=?");

        List<Receptionist> rinfo = q.setParameter(0, email).list();

        t.commit();
        s.close();
        return rinfo.get(0);
    }

    @Override
    public int showallReceptionist() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Receptionist> st = s.createQuery("from Receptionist").list();
        int a=st.size();
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return a;
    }
    
}
