/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Email.sendEmail;
import controllers.EmployeeController;
import controllers.EmployeeControllerInterface;
import controllers.OvertimeController;
import controllers.OvertimeControllerInterface;
import controllers.PresenceController;
import controllers.PresenceControllerInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import entities.Overtime;
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
        System.out.println(pci.insert("14410", "11/01/2018", "11/01/2018", "11/01/2018", "1"));
        
//        System.out.println(pci.getById("1"));
//        EmployeeControllerInterface eci = new EmployeeController(sessionFactory);
////
////        eci.insert("susan", "hasan@gmail.com", "1234567", "0928147424", "11/01/2018", "IT", "3000000", "222", "Admin", "14410");
//        
//        OvertimeControllerInterface oci = new OvertimeController(sessionFactory);
//        oci.insert("2", "14409", "1", "3", "300000", "0", "fsgsga");
        
        

//        mail mail =  new mail(); 

//        String s = "Aji";
//        String newJ = BCrypt.hashpw(s, BCrypt.gensalt());
//        
//        System.out.println(newJ);
        
    }
    
}
