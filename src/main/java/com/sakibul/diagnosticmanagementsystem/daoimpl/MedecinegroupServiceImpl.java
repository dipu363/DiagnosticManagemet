/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.MedecinegroupService;
import com.sakibul.diagnosticmanagementsystem.model.Medecinegroup;
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
public class MedecinegroupServiceImpl implements MedecinegroupService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertMedecinegroup(Medecinegroup mdg) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(mdg);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateMedecinegroup(Medecinegroup mdg) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        
        s.update(mdg);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteMedecinegroup(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Medecinegroup cm = (Medecinegroup) s.get(Medecinegroup.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String showMedecinegroup() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Medecinegroup> categorieslist = s.createQuery("from Medecinegroup").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        
        return categorylistgson;
    }

    @Override
    public Medecinegroup showOneMedecinegroup(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Medecinegroup cm = (Medecinegroup) s.get(Medecinegroup.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }
    
}
