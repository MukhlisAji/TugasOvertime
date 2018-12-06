/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Mukhlish
 */
public class EmployeeController implements EmployeeControllerInterface{
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private DAOInterface daoi = new GeneralDAO(factory);
    
    public EmployeeController(SessionFactory factory, DAOInterface daoi) {
        this.daoi = daoi;
    }

    public EmployeeController() {
    }

    @Override
    public List<Object> getAlls() {
        return daoi.doDDL(new Employee(), "");
    }

    @Override
    public List<Object> search(String key) {
        return daoi.doDDL(new Employee(), key);
    }

    @Override
    public Employee getById(String id) {
        return (Employee) daoi.getById(new Employee(), id);
    }

    @Override
    public String insert(String NIK, String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status, String isDelete) {
        Employee employee = new Employee(NIK, Name, Email, Password, Manager_id);
         if (daoi.doDML(employee, false)) {
            return "Berhasil menambahkan id: " + NIK;
        }
        return "Gagal";
    }

    @Override
    public String update(String NIK, String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status, String isDelete) {
              Employee employee = new Employee(NIK, Name, Email, Password, Manager_id);
         if (daoi.doDML(employee, false)) {
            return "Berhasil memperbarui id: " + NIK;
        }
        return "Gagal";
    }

    @Override
    public String delete(String NIK) {
        Employee employee = new Employee(NIK);
        if (daoi.doDML(employee, true)) {
            return "Berhasil menghapus id = + NIK";
        }
        return "gagal";
    }

    @Override
    public List<Object> getEmployeeName(String keyword) {
       return daoi.doDDL(new Employee(), keyword);
    }
    
}
