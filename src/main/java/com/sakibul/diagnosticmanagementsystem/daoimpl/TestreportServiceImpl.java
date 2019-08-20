/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.TestreportService;
import com.sakibul.diagnosticmanagementsystem.model.Testprescription;
import com.sakibul.diagnosticmanagementsystem.model.Testreport;
import java.util.List;
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

public class TestreportServiceImpl implements TestreportService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertTestreport(Testreport treport) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        System.out.println("alsdjffl"+treport.getPresid());
        
        s.save(treport);
        Testprescription onepresobject = (Testprescription) s.get(Testprescription.class, treport.getPresid());
        onepresobject.setStatus("Ok");
         s.update(onepresobject);
         System.out.println("lajsldfkj"+onepresobject.getStatus());
         
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateTestreport(Testreport treport) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        
        s.update(treport);
        t.commit();
        s.close();
        return null; 
    }

    @Override
    public String deleteTestreport(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Testreport cm = (Testreport) s.get(Testreport.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String showTestreport() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Testreport> categorieslist = s.createQuery("select u from Testreport u ORDER BY reportdate DESC").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        
        return categorylistgson;
    }

    @Override
    public Testreport showOneTestreport(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Testreport cm = (Testreport) s.get(Testreport.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }

    @Override
    public String updateTestpres(int presid) {
        System.out.println("alsdkjflkajdslf"+presid);
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Testprescription onepresobject = (Testprescription) s.get(Testprescription.class, presid);
        
        
        s.update(onepresobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String showPatientTestreport(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Testreport> categorieslist = s.createQuery("from Testreport where pid=?").setParameter(0, id).list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        
        return categorylistgson;
    }

   
    
    
}
