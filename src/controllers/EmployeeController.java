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
public class EmployeeController implements EmployeeControllerInterface{

    @Override
    public List<Object> getAlls() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status, String isDelete, String NIK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status, String isDelete, String NIK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getEmployeeName(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
