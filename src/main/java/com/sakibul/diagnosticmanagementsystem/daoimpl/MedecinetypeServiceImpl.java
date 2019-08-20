/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinetypeService;
import com.sakibul.diagnosticmanagementsystem.model.Medecinetype;

import java.util.List;
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
public class MedecinetypeServiceImpl implements MedecinetypeService{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public String insertMedecinetype(Medecinetype mdc) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(mdc);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateMedecinetype(Medecinetype mdc) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        
        s.update(mdc);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteMedecinetype(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Medecinetype cm = (Medecinetype) s.get(Medecinetype.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String showMedecinetype() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Medecinetype> categorieslist = s.createQuery("from Medecinetype").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        
        return categorylistgson;
    }

    @Override
    public Medecinetype showOneMedecinetype(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Medecinetype cm = (Medecinetype) s.get(Medecinetype.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }
    
}
