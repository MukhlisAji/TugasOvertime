/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import java.math.BigDecimal;
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
    public Boolean insert(String nik, String name, String email, String password, String phoneNumber, String hireDate, String jobTitle, String salary, String managerId, String status) {
        boolean hasil = false;
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date dates = format.parse(hireDate);
            
            System.out.println(dates);
            long sal = Integer .valueOf(salary);
            System.out.println(sal);
//            BigDecimal com = new BigDecimal(commissionPct);
//            System.out.println(com);
//            int managerid = Integer.valueOf(managerId);
//            System.out.println(managerid);
            Employee emp = new Employee(nik);
//            Job job = new Job(jobId);
//            Department department = new Department(Short.valueOf(departmentId));
            Employee employee = new Employee(nik, name, email, password, phoneNumber, dates, jobTitle, sal, managerId, status);
            if (daoi.doDML(employee, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }
//    public Boolean insert(String Name, String Email, String Password, String Phone_number, String Hire_date, String Job_title, String Salary, String Manager_id, String Status, String NIK) {
//        try {
//            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//            Date dates = format.parse(Hire_date);
//            Long salary = Long.parseLong(Salary);
//            System.out.println(dates);
//            Employee employee = new Employee(NIK, Name, Email, Password, Phone_number, dates, Job_title, salary, Manager_id, Status);
//            if (daoi.doDML(employee, false)) {
//                return "Berhasil menambahkan id: " + NIK;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "Gagal";
//    }

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
            e.printStackTrace();
        }
        return "Gagal";
    }

    @Override
    public Boolean delete(String nik) {
       boolean hasil = true;
        try {
           
            Employee employee = new Employee(nik);
            if (daoi.doDML(employee, true)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

    @Override
    public List<Object> getEmployeeName(String keyword) {
        return daoi.doDDL(new Employee(), keyword);
    }

}
