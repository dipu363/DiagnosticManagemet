/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author User
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("patientsignup").permitAll()
                .antMatchers("/welcome").access("hasRole('ROLE_USER')")
                .antMatchers("/signup").access("hasRole('ROLE_USER')")
                .antMatchers("/reguser").access("hasRole('ROLE_USER')")
                .antMatchers("/users").access("hasRole('ROLE_USER')")
                .antMatchers("/patientlist").access("hasRole('ROLE_USER')")
                .antMatchers("/addtesttype").access("hasRole('ROLE_USER')")
                .antMatchers("/testtypelist").access("hasRole('ROLE_USER')")
                .antMatchers("/addtimeschedule").access("hasRole('ROLE_USER')")
                .antMatchers("/timeschedulelist").access("hasRole('ROLE_USER')")
                .antMatchers("/addbed").access("hasRole('ROLE_USER')")
                .antMatchers("/bedlist").access("hasRole('ROLE_USER')")
                .antMatchers("/adddoctor").access("hasRole('ROLE_USER')")
                .antMatchers("/doctorlist").access("hasRole('ROLE_USER')")
                .antMatchers("/addreceptionist").access("hasRole('ROLE_USER')")
                .antMatchers("/receptionistlist").access("hasRole('ROLE_USER')")
                .antMatchers("/addpharmacist").access("hasRole('ROLE_USER')")
                .antMatchers("/pharmacistlist").access("hasRole('ROLE_USER')")
                .antMatchers("/addaccountant").access("hasRole('ROLE_USER')")
                .antMatchers("/accountantlist").access("hasRole('ROLE_USER')")
                .antMatchers("/addtest").access("hasRole('ROLE_USER')")
                .antMatchers("/testlist").access("hasRole('ROLE_USER')")
                .antMatchers("/reportView").access("hasRole('ROLE_USER')")
                .antMatchers("/patientprofile").access("hasRole('ROLE_PATIENT')")
                .antMatchers("/showappointmentpage").access("hasRole('ROLE_PATIENT')")
                .antMatchers("/showappointmentpages").access("hasRole('ROLE_PATIENT')")
                .antMatchers("/showappointment").access("hasRole('ROLE_PATIENT')")
                .antMatchers("/appointdoctorlist").access("hasRole('ROLE_PATIENT')")
                .antMatchers("/showprescription").access("hasRole('ROLE_PATIENT')")
                .antMatchers("/showtestprescription").access("hasRole('ROLE_PATIENT')")
                .antMatchers("/showtestreport").access("hasRole('ROLE_PATIENT')")
                //.antMatchers("/showappointmentpages").access("hasRole('ROLE_DOCTOR') or hasRole('ROLE_PATIENT')")
                //.antMatchers("/showappointmentpage").access("hasRole('ROLE_DOCTOR') or hasRole('ROLE_PATIENT')")
                .antMatchers("/doctorprofile").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/patientprescription").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/addprescription").access("hasRole('ROLE_DOCTOR') ")
                .antMatchers("/prescriptionlist").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/pendingappointment").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/addmedecinetype").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/medicinetypelist").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/addmedecinegroup").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/medicinegrouplist").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/addmedicine").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/medicinelist").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/addtestprescription").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/testprescriptionlist").access("hasRole('ROLE_DOCTOR')")
                
                .antMatchers("/accountantprofile").access("hasRole('ROLE_ACCOUNTANT')")
                .antMatchers("/addpayment").access("hasRole('ROLE_ACCOUNTANT')")
                .antMatchers("/paymentlist").access("hasRole('ROLE_ACCOUNTANT')")
                .antMatchers("/allbillrecords").access("hasRole('ROLE_ACCOUNTANT')")
                .antMatchers("/totalreportview").access("hasRole('ROLE_ACCOUNTANT')")
                
                
                .antMatchers("/receptionistprofile").access("hasRole('ROLE_RECEPTIONIST')")
                .antMatchers("/showtreport").access("hasRole('ROLE_RECEPTIONIST')")
                .antMatchers("/pendingappointments").access("hasRole('ROLE_RECEPTIONIST')")
                .antMatchers("/appointmentlist").access("hasRole('ROLE_RECEPTIONIST')")
                .antMatchers("/preslist").access("hasRole('ROLE_RECEPTIONIST')")
                .antMatchers("/testpreslist").access("hasRole('ROLE_RECEPTIONIST')")
                .antMatchers("/addaddmission").access("hasRole('ROLE_RECEPTIONIST')")
                .antMatchers("/addmissionlist").access("hasRole('ROLE_RECEPTIONIST')")
                .antMatchers("/presreportView").access("hasRole('ROLE_RECEPTIONIST')")
                .antMatchers("/testpresreportView").access("hasRole('ROLE_RECEPTIONIST')")
                
                .antMatchers("/pharmacistprofile").access("hasRole('ROLE_PHARMACIST')")
                .antMatchers("/pendingtestreport").access("hasRole('ROLE_PHARMACIST')")
                .antMatchers("/addtestreport").access("hasRole('ROLE_PHARMACIST')")
                .antMatchers("/testreportlist").access("hasRole('ROLE_PHARMACIST')")
                
                .antMatchers("/showingcategorypage").access("hasRole('ROLE_USER')")
                .antMatchers("/viewtestreport").access("hasRole('ROLE_USER')")
                .antMatchers("/adddepartment").access("hasRole('ROLE_USER')")
                .and().formLogin().loginPage("/login").loginProcessingUrl("/perform_login")
                .successForwardUrl("/loginsuccess").usernameParameter("usename")
                .passwordParameter("userpassword").failureUrl("/login")
                .and().logout().logoutUrl("/logout")
                .logoutSuccessUrl("/welcome").invalidateHttpSession(true)
                .and().csrf().disable();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("in security.............");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select emailId, password, status from UserRole where emailId=? and status='True'")
                .authoritiesByUsernameQuery("select emailId,role from UserRole where emailId=?");
    }

}
