/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Mukhlish
 */
public class EmployeeController implements EmployeeControllerInterface {

    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private DAOInterface daoi = new GeneralDAO(factory);

    public EmployeeController(SessionFactory factory, DAOInterface daoi) {
        this.daoi = daoi;
    }

    public EmployeeController() {
    }

    public EmployeeController(SessionFactory sessionFactory) {
        this.factory = factory;
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
    public String insert(String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status, String NIK) {
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date dates = format.parse(Hire_date);
            Long salary = Long.parseLong(Salary);
            System.out.println(dates);
            Employee employee = new Employee(NIK, Name, Email, Password, Phone_number, dates, Job_title, salary, Manager_id, Status);
            if (daoi.doDML(employee, false)) {
                return "Berhasil menambahkan id: " + NIK;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return "Gagal";
    }

    @Override
    public String update(String NIK, String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status) {
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date dates = format.parse(Hire_date);
            Long salary = Long.parseLong(Salary);
            System.out.println(dates);
            Employee employee = new Employee(NIK, Name, Email, Password, Phone_number, dates, Job_title, salary, Manager_id, Status);
            if (daoi.doDML(employee, false)) {
                return "Berhasil memperbarui id: " + NIK;
            }
        } catch (Exception e) {
            e.getMessage();
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
