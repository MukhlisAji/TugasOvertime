/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Employee;
import java.util.List;

/**
 *
 * @author Mukhlish
 */
public interface EmployeeControllerInterface {
    public List<Object> getAlls();
    public List<Object> search(String key);
    public Employee getById(String id);
    public Boolean insert(String nik, String name, String email, String password, String phoneNumber, String hireDate, String jobTitle, String salary, String managerId, String status);
    public String update(String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status, String NIK);
    public Boolean delete(String nik);
    public List<Object> getEmployeeName(String keyword);
    
}
