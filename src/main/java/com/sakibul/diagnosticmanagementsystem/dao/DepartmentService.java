/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;


import com.sakibul.diagnosticmanagementsystem.model.Department;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface DepartmentService {
    public String insertDepartment(Department dept);
    
    public String updateDepartment(Department dept);
    
    public String deleteDepartment(int id);
    
    public String showDepartment();
    
    public Department showOneDepartment(int id);
}
