/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.daoimpl;

import com.google.gson.Gson;
import com.sakibul.diagnosticmanagementsystem.dao.ViewPrescriptiondrugService;
import com.sakibul.diagnosticmanagementsystem.model.Prescription;
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
 * @author Another User
 */
@Repository
public class ViewPrescriptiondrugServiceImpl implements ViewPrescriptiondrugService{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public String updatePrescriptiondrug(int presid, Prescriptiondrug presdrug) {
        return null;
    }

    @Override
    public String deletePrescriptiondrug(int presid) {
        return null;
    }

    @Override
    public String viewPrescriptiondrug(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Prescription> orderList = s.createQuery("from Prescription  where pid=? order by presid").setParameter(0, id).list();
        List<Prescriptiondrug> orderDetailList = s.createQuery("from Prescriptiondrug  where pid=? order by presid").setParameter(0, id).list();
        //adding blank orderdetails
        for (int i = 0; i < orderList.size(); i++) {
            orderList.get(i).setPresdrug(new ArrayList<Prescriptiondrug>());
        }
        List<Integer> parentId = new ArrayList<>();
        List<Integer> childId = new ArrayList<>();
        //list all orderid from order
        for (int i = 0; i < orderList.size(); i++) {
            parentId.add(orderList.get(i).getPresid());            
        }
        //list all orderid from orderdetails
        for (int i = 0; i < orderDetailList.size(); i++) {
            childId.add(orderDetailList.get(i).getPresid());            
        }
        //List<OrderDetails> subchild;
        try {
            int index=0;
            for (Integer i : childId) {
            if (parentId.contains(i)) {
                //subchild = new ArrayList<>();
                System.out.println(parentId.indexOf(i)+" Match Found " + i);
                //subchild.add(orderDetailList.get(index));                
                orderList.get(parentId.indexOf(i)).getPresdrug().add(orderDetailList.get(index));
                index++;
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //orderList.addAll(orderDetailList);
        //for (int i = 0; i < orderDetailList.size(); i++) {
            //if(orderList.get(i).getOrderid()!=0)
            //if(orderDetailList.get(i).getOrderid()==orderList.get(i).getOrderid()){
            //orderList.get(0).setOrderDetails(orderDetailList);
            //}            
        //}
        Gson g = new Gson();
        String orderListgson = g.toJson(orderList);
        t.commit();
        s.close();
        System.out.println("-----"+orderListgson);
        return orderListgson;
    }

    @Override
    public Prescriptiondrug viewOnePrescriptiondrug(int presid) {
        return null;
    }

    @Override
    public String viewPrescriptiondrug() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Prescription> orderList = s.createQuery("from Prescription  order by presid").list();
        List<Prescriptiondrug> orderDetailList = s.createQuery("from Prescriptiondrug  order by presid").list();
        //adding blank orderdetails
        for (int i = 0; i < orderList.size(); i++) {
            orderList.get(i).setPresdrug(new ArrayList<Prescriptiondrug>());
        }
        List<Integer> parentId = new ArrayList<>();
        List<Integer> childId = new ArrayList<>();
        //list all orderid from order
        for (int i = 0; i < orderList.size(); i++) {
            parentId.add(orderList.get(i).getPresid());            
        }
        //list all orderid from orderdetails
        for (int i = 0; i < orderDetailList.size(); i++) {
            childId.add(orderDetailList.get(i).getPresid());            
        }
        //List<OrderDetails> subchild;
        try {
            int index=0;
            for (Integer i : childId) {
            if (parentId.contains(i)) {
                //subchild = new ArrayList<>();
                System.out.println(parentId.indexOf(i)+" Match Found " + i);
                //subchild.add(orderDetailList.get(index));                
                orderList.get(parentId.indexOf(i)).getPresdrug().add(orderDetailList.get(index));
                index++;
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //orderList.addAll(orderDetailList);
        //for (int i = 0; i < orderDetailList.size(); i++) {
            //if(orderList.get(i).getOrderid()!=0)
            //if(orderDetailList.get(i).getOrderid()==orderList.get(i).getOrderid()){
            //orderList.get(0).setOrderDetails(orderDetailList);
            //}            
        //}
        Gson g = new Gson();
        String orderListgson = g.toJson(orderList);
        t.commit();
        s.close();
        System.out.println("-----"+orderListgson);
        return orderListgson;
    }
    
}
