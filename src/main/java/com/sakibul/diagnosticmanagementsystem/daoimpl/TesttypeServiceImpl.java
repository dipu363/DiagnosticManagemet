/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.TesttypeService;
import com.sakibul.diagnosticmanagementsystem.model.Testtype;
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
public class TesttypeServiceImpl implements TesttypeService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertTesttype(Testtype ttype) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(ttype);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateTesttype(Testtype ttype) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        
        s.update(ttype);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteTesttype(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Testtype cm = (Testtype) s.get(Testtype.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String showTesttype() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Testtype> categorieslist = s.createQuery("from Testtype").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        
        return categorylistgson;
    }

    @Override
    public Testtype showOneTesttype(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Testtype cm = (Testtype) s.get(Testtype.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }
    
}
