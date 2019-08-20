/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.AppointmentsService;
import com.sakibul.diagnosticmanagementsystem.model.Appointments;
import com.sakibul.diagnosticmanagementsystem.model.Paymentinfo;
import com.sakibul.diagnosticmanagementsystem.model.Timeschedule;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class AppointmentsServiceImpl implements AppointmentsService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insertAppointment(Appointments ml) {
        boolean st;
        Date d = ml.getAppointdate();
        System.out.println(d);
        String b = new SimpleDateFormat("EEEEE").format(d);
        
        System.out.println(b);
        int a = ml.getDoctorid();
        int p=ml.getPid();
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        System.out.println(a);
        List<Integer> plimit = s.createQuery("select patientlimit from Timeschedule where doctorid=:doid").setParameter("doid", a).list();
        System.out.println(plimit.get(0));
        int i = plimit.get(0);

        List<Timeschedule> time = s.createQuery("select u from Timeschedule u where doctorid=? and dayoff=?").setParameter(0, a).setParameter(1, b).list();
        System.out.println(time.size());
        List<Appointments> appoint = s.createQuery("select u from Appointments u where doctorid=? and appointdate=?").setParameter(0, a).setParameter(1, d).list();
        System.out.println(appoint.size());
        
        List<Appointments> pappoint = s.createQuery("select u from Appointments u where doctorid=? and appointdate=? and pid=?").setParameter(0, a).setParameter(1, d).setParameter(2, p).list();
        System.out.println(pappoint.size());
        if (time.size() > 0 || appoint.size() > i || pappoint.size()>0) {
            st = false;
        } else {
            if(appoint.size()==0){
                ml.setSerialno(1);
            }else{
                ml.setSerialno(appoint.size()+1);
            }
            t.begin();
            
            s.save(ml);
            Paymentinfo pinfo=new Paymentinfo();
            pinfo.setAppointid(ml.getAppointid());
            pinfo.setAppointfees(ml.getFees());
            pinfo.setPid(ml.getPid());
            s.save(pinfo);
            t.commit();

            st = true;
        }

        return st;
    }

    @Override
    public String updateAppointment(int appointid, Appointments ml) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Appointments onemedecineobject = (Appointments) s.get(Appointments.class, appointid);
        onemedecineobject.setPid(ml.getPid());
        onemedecineobject.setDoctorid(ml.getDoctorid());
        onemedecineobject.setAppointdate(ml.getAppointdate());

        onemedecineobject.setAppointstatus(ml.getAppointstatus());

        s.update(onemedecineobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteAppointment(int appointid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Appointments pm = (Appointments) s.get(Appointments.class, appointid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewAppointments() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Appointments> productslist = s.createQuery("from Appointments").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Appointments viewOneAppointment(int appointid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Appointments pm = (Appointments) s.get(Appointments.class, appointid);
        t.commit();
        s.close();
        return pm;
    }

    @Override
    public String viewAppointmentsPatient() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        Date date=new Date();
        
        t.begin();
        List<Appointments> productslist = s.createQuery("select u from Appointments u where appointstatus='pending' and appointdate=?").setParameter(0, date).list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public String viewPatientAppointments(int pid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Appointments> productslist = s.createQuery("select u from Appointments u where pid=?").setParameter(0, pid).list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public String viewPatientAppointment(int docid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Date d=new Date();
        List<Appointments> appointlist = s.createQuery("select u from Appointments u where appointstatus='Pending' and doctorid=? and appointdate=?").setParameter(0, docid).setParameter(1, d).list();
        Gson g = new Gson();
        String appointlistgson = g.toJson(appointlist);
        t.commit();
        s.close();
        return appointlistgson;
    }

    @Override
    public Appointments viewPayableAppointments(int pid) {
        Session s = sessionFactory.openSession();
        Appointments tp = new Appointments();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Appointments u where pid=? and billstatus='True'");

        List<Appointments> appinfo = q.setParameter(0, pid).list();

        t.commit();
        s.close();
        if(appinfo.size()>0){
            return appinfo.get(0);
        }else{
            return null;
        }
        
    }

    @Override
    public String viewPendingPatient() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Appointments> appointlist = s.createQuery("select u from Appointments u where billstatus='True'").list();
        Gson g = new Gson();
        String appointlistgson = g.toJson(appointlist);
        t.commit();
        s.close();
        if (appointlist.size() > 0) {
            return appointlistgson;
        } else {
            return "null";
        }

    }

    @Override
    public String viewBillPatient() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Appointments> appointlist = s.createQuery("select u from Appointments u where billstatus='True'").list();
        Gson g = new Gson();
        String appointlistgson = g.toJson(appointlist);
        t.commit();
        s.close();
        return appointlistgson;
    }

}
