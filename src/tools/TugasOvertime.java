/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Email.mail;
import Email.sendEmail;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mukhlish
 */
public class TugasOvertime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(HibernateUtil.getSessionFactory());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        DAOInterface daoi = new GeneralDAO(sessionFactory);
        
//        Employee employee = new Employee(nik, name, email, password, managerId);

//        for (Object employee : daoi.doDDL(new Employee(), "")) {
//            Employee e = (Employee) employee;
//            System.out.println(e.getName());
//        
//        }
        
        sendEmail e = new sendEmail();
//        
        System.out.println(e);
//        Employee e = (Employee) daoi.doDDL(new Employee(), "");

//        mail mail =  new mail(); 
        
    }
    
}
