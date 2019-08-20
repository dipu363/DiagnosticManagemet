/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.PatientService;
import com.sakibul.diagnosticmanagementsystem.model.Patient;
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
public class PatientServiceImpl implements PatientService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPatient(Patient patient) {
        String status;
        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.getTransaction();
            t.begin();
            User u=new User();
            UserRole ur=new UserRole();
            u.setEmailid(patient.getEmailid());
            u.setUsername(patient.getFname());
            u.setPhone(patient.getMobile());
            
            ur.setEmailid(patient.getEmailid());
            ur.setPassword(patient.getPassword());
            ur.setRole(patient.getRole());
            ur.setStatus(patient.getStatus());
            s.save(patient);
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
    public String updatePatient(Patient cm) {
        
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(cm);
        t.commit();
        s.close();
        return null;

    }

    @Override
    public String deletePatient(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Patient doc = (Patient) s.get(Patient.class, id);
        s.delete(doc);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewPatient() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Patient> categorieslist = s.createQuery("from Patient").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

    @Override
    public Patient viewOnePatient(int id) {
        return null;
    }

    @Override
    public Patient viewOnePatentmail(String email) {
        Session s = sessionFactory.openSession();
        Patient pat = new Patient();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Patient u where emailid=?");

        List<Patient> patientinfo = q.setParameter(0, email).list();

        t.commit();
        s.close();
        return patientinfo.get(0);
    }

    @Override
    public String viewTestPatient() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Patient> categorieslist = s.createQuery("SELECT patient.fname, patient.emailid, patient.pid\n" +
"FROM diagnostic.appointments appointments\n" +
"     INNER JOIN diagnostic.patient patient\n" +
"        ON (appointments.pid = patient.pid)\n" +
"WHERE appointments.appointstatus = 'Ok'").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

    @Override
    public int showallPatient() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Patient> st = s.createQuery("from Patient").list();
        int a=st.size();
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return a;
    }

}
