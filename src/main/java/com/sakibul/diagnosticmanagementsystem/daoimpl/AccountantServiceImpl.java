/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.AccountantService;
import com.sakibul.diagnosticmanagementsystem.model.Accountant;
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
public class AccountantServiceImpl implements AccountantService{
    
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertAccountant(Accountant ac) {
        String status;
        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.getTransaction();
            t.begin();
            User u=new User();
            UserRole ur=new UserRole();
            u.setEmailid(ac.getEmailid());
            u.setUsername(ac.getFname());
            u.setPhone(ac.getPhone());
            
            ur.setEmailid(ac.getEmailid());
            ur.setPassword(ac.getPassword());
            ur.setRole(ac.getRole());
            ur.setStatus(ac.getStatus());
            s.save(ac);
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
    public String updateAccountant(Accountant ac) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(ac);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteAccountant(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Accountant doc = (Accountant) s.get(Accountant.class, id);
        s.delete(doc);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String showAccountant() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Accountant> categorieslist = s.createQuery("from Accountant").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

    @Override
    public Accountant showOneAccountant(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Accountant cm = (Accountant) s.get(Accountant.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }

    @Override
    public Accountant showOneAccountantbyEmail(String email) {
        Session s = sessionFactory.openSession();
        Accountant ph = new Accountant();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Accountant u where emailid=?");

        List<Accountant> rinfo = q.setParameter(0, email).list();

        t.commit();
        s.close();
        return rinfo.get(0);
    }

    @Override
    public int showallAccountant() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Accountant> st = s.createQuery("from Accountant").list();
        int a=st.size();
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return a;
    }
    
}
