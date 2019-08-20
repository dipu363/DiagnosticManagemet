/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.TimescheduleService;
import com.sakibul.diagnosticmanagementsystem.model.Timeschedule;

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
public class TimescheduleServiceImpl implements TimescheduleService{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public String insertTimeschedule(Timeschedule timesch) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(timesch);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateTimeschedule(Timeschedule timesch) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        
        s.update(timesch);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteTimeschedule(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Timeschedule cm = (Timeschedule) s.get(Timeschedule.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String showTimeschedule() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Timeschedule> timeschedulelist = s.createQuery("from Timeschedule").list();
        Gson g = new Gson();
        String timeschedulelistgson = g.toJson(timeschedulelist);
        t.commit();
        s.close();
        
        return timeschedulelistgson;
    }

    @Override
    public Timeschedule showOneTimeschedule(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Timeschedule cm = (Timeschedule) s.get(Timeschedule.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String timeschedulegson = g.toJson(cm);
        return cm;
    }
    
}
