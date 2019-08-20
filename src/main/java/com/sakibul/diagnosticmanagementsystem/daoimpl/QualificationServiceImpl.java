/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.QualificationService;
import com.sakibul.diagnosticmanagementsystem.model.Qualification;

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
public class QualificationServiceImpl implements QualificationService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertQualification(Qualification dept) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(dept);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateQualification(Qualification dept) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        
        s.update(dept);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteQualification(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Qualification cm = (Qualification) s.get(Qualification.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String showQualification() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Qualification> qualificationslist = s.createQuery("from Qualification").list();
        Gson g = new Gson();
        String qualificationlistgson = g.toJson(qualificationslist);
        t.commit();
        s.close();
        
        return qualificationlistgson;
    }

    @Override
    public Qualification showOneQualification(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Qualification cm = (Qualification) s.get(Qualification.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String qualificationgson = g.toJson(cm);
        return cm;
    }
    
}
