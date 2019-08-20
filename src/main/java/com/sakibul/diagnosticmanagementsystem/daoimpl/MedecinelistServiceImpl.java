/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinelistService;
import com.sakibul.diagnosticmanagementsystem.model.Medecinelist;
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
public class MedecinelistServiceImpl implements MedecinelistService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertMedecine(Medecinelist ml) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(ml);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateMedecine(int listid, Medecinelist ml) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Medecinelist onemedecineobject = (Medecinelist) s.get(Medecinelist.class, listid);
        onemedecineobject.setTypeid(ml.getTypeid());
        onemedecineobject.setGroupid(ml.getGroupid());
        onemedecineobject.setMedecinename(ml.getMedecinename());
        
        
        s.update(onemedecineobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteMedecine(int listid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Medecinelist pm = (Medecinelist) s.get(Medecinelist.class, listid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewMedecine() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Medecinelist> productslist = s.createQuery("from Medecinelist").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Medecinelist viewOneMedecine(int listid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Medecinelist pm = (Medecinelist) s.get(Medecinelist.class, listid);
        t.commit();
        s.close();
        return pm;
    }
    
}
