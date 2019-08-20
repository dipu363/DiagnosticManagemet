/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;



import com.sakibul.diagnosticmanagementsystem.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public interface Userservice {
    public String acceptUser(User u);

    public String insertUser(User u);

    public String updateUser(User u);

    public String deleteUser(String email);

    public String viewUsers();

    public User viewUser(String s);
}
