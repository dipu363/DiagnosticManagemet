/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.PrescriptiondrugService;
import com.sakibul.diagnosticmanagementsystem.model.Appointments;
import com.sakibul.diagnosticmanagementsystem.model.Prescriptiondrug;
import java.util.ArrayList;
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
public class PrescriptiondrugServiceImpl implements PrescriptiondrugService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPrescriptiondrug(Prescriptiondrug pres) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(pres);
        Appointments oneappointobject = (Appointments) s.get(Appointments.class, pres.getAppointid());
        oneappointobject.setAppointstatus("Ok");
         s.update(oneappointobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updatePrescriptiondrug(int prid, Prescriptiondrug pres) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Prescriptiondrug oneprescriptionobject = (Prescriptiondrug) s.get(Prescriptiondrug.class, prid);
        oneprescriptionobject.setDoctorid(pres.getDoctorid());
        oneprescriptionobject.setPid(pres.getPid());
        oneprescriptionobject.setAppointid(pres.getAppointid());
        oneprescriptionobject.setDose(pres.getDose());
        oneprescriptionobject.setDoseadvice(pres.getDoseadvice());
        oneprescriptionobject.setDoseschedule(pres.getDoseschedule());
        oneprescriptionobject.setDrugid(pres.getDrugid());
        oneprescriptionobject.setGroupid(pres.getGroupid());
        oneprescriptionobject.setListid(pres.getListid());
        oneprescriptionobject.setTypeid(pres.getTypeid());

        s.update(oneprescriptionobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deletePrescriptiondrug(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Prescriptiondrug pm = (Prescriptiondrug) s.get(Prescriptiondrug.class, id);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String showPrescriptiondrug() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Prescriptiondrug> productslist = s.createQuery("from Prescriptiondrug").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Prescriptiondrug showOnePrescriptiondrug(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Prescriptiondrug pm = (Prescriptiondrug) s.get(Prescriptiondrug.class, id);
        t.commit();
        s.close();
        return pm;
    }

    @Override
    public String insertPrescriptiondrug(ArrayList<Prescriptiondrug> presdetail) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        for (Prescriptiondrug pdetails : presdetail) {
            s.save(pdetails);
        }
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String showPatientPrescriptiondrug(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Prescriptiondrug> productslist = s.createQuery("from Prescriptiondrug where pid=?").setParameter(0, id).list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }
    
}
