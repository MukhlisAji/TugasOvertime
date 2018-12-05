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
    public String insert(String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status, String isDelete, String NIK);
    public String update(String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status, String isDelete, String NIK);
    public String delete(String id);
    public List<Object> getEmployeeName(String keyword);
    
}
