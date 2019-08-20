/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Appointments;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface AppointmentsService {

    public boolean insertAppointment(Appointments ml);

    public String updateAppointment(int appointid, Appointments ml);

    public String deleteAppointment(int appointid);

    public String viewAppointments();

    public Appointments viewOneAppointment(int appointid);

    public String viewAppointmentsPatient();

    public String viewPatientAppointments(int pid);
    
    public Appointments viewPayableAppointments(int pid);
    
    public String viewPatientAppointment(int docid);
    
    public String viewPendingPatient();
    
    public String viewBillPatient();
    
}
