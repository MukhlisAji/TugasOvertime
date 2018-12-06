/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Email.sendEmail;
import controllers.PresenceController;
import controllers.PresenceControllerInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import jbcrypt.BCrypt;
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
        
//        sendEmail e = new sendEmail();
//                
//        e.sent(true);
        
        PresenceControllerInterface pci = new PresenceController(sessionFactory);
//        System.out.println(pci.insert("14410", "", "", "11/01/2018", "1"));
        
        System.out.println(pci.getById("1"));
        Employee e = (Employee) daoi.doDDL(new Employee(nik, name, email, password, managerId), "");
        

//        mail mail =  new mail(); 

//        String s = "Aji";
//        String newJ = BCrypt.hashpw(s, BCrypt.gensalt());
//        
//        System.out.println(newJ);
        
    }
    
}
