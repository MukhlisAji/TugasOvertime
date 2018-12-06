/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import controllers.EmployeeControllerInterface;
import controllers.OvertimeController;
import controllers.OvertimeControllerInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import entities.Overtime;
import entities.Presence;
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
        DAOInterface gdao = new GeneralDAO(sessionFactory);
//        EmployeeControllerInterface eci = new EmployeeController(sessionFactory);
       OvertimeControllerInterface oci = new OvertimeController(sessionFactory);
       
//       Employee employee = new Employee("12345");
//       Presence presence = new Presence(Integer.valueOf("1234"));
//       Overtime o = new Overtime(1234, Short.parseShort("2"), Long.parseLong("15000"),
//               Short.parseShort("Approve"), "", employee, presence);
//       System.out.println(oci.insert(o));
for (Object object : oci.getAlls()) {
            Overtime o = (Overtime) object;
            System.out.println(o.getOvertimeId()+ " - " + o.getNik());
        }
//        System.out.println(oci.insert("1234", "2", "15000", "1", "111", "12345", "1234"));
//        System.out.println(oci.insert(new Overtime(1234, Short.parseShort("2"), Long.parseLong("15000"),
//               Short.parseShort("Approve"), "", employee, presence)));
//        Employee e = new Employee("14413", BCrypt.hashpw("adhe", BCrypt.gensalt()));
    }
}
