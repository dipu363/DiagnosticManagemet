/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.DoctorService;
import com.sakibul.diagnosticmanagementsystem.model.Doctor;
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
 * @author Another User
 */
@Repository
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public String insertDoctor(Doctor doc) {
        String status;
        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.getTransaction();
            t.begin();
            User u=new User();
            UserRole ur=new UserRole();
            u.setEmailid(doc.getEmailid());
            u.setUsername(doc.getFname());
            u.setPhone(doc.getPhone());
            
            ur.setEmailid(doc.getEmailid());
            ur.setPassword(doc.getPassword());
            ur.setRole(doc.getRole());
            ur.setStatus(doc.getStatus());
            s.save(doc);
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
    public String deleteDoctor(int doctorid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Doctor doc = (Doctor) s.get(Doctor.class, doctorid);
        s.delete(doc);
        t.commit();
        s.close();

        return null;
    }

    

    @Override
    public Doctor showOneDoctor(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Doctor cm = (Doctor) s.get(Doctor.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }

    @Override
    public String showDoctor() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Doctor> categorieslist = s.createQuery("from Doctor").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

    @Override
    public String updateDoctor(Doctor doc) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(doc);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Doctor showOneDoctorbyEmail(String email) {
        Session s = sessionFactory.openSession();
        Doctor doc = new Doctor();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Doctor u where emailid=?");

        List<Doctor> docinfo = q.setParameter(0, email).list();

        t.commit();
        s.close();
        return docinfo.get(0);
    }

    @Override
    public int showallDoctor() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Doctor> st = s.createQuery("from Doctor").list();
        int a=st.size();
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return a;
    
    }

    @Override
    public String viewdepratmentDoctor(String deptname) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Doctor> doctorlist = s.createQuery("from Doctor where deptname=?").setParameter(0, deptname).list();
        Gson g = new Gson();
        String doctorlistgson = g.toJson(doctorlist);
        t.commit();
        s.close();
       
        return doctorlistgson;
    }

    @Override
    public Doctor showDocDepartment(int id) {
        Session s = sessionFactory.openSession();
        Doctor doc = new Doctor();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Doctor u where doctorid=?");

        List<Doctor> docinfo = q.setParameter(0, id).list();

        t.commit();
        s.close();
        return docinfo.get(0);
    }

    
    
}
