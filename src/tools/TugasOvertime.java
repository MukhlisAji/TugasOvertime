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
import controllers.ParameterController;
import controllers.ParameterControllerInterface;
import controllers.PresenceController;
import controllers.PresenceControllerInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import entities.Overtime;
import entities.Presence;
import java.sql.Timestamp;
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
        EmployeeControllerInterface eci = new EmployeeController(sessionFactory);
        OvertimeControllerInterface oci = new OvertimeController(sessionFactory);
        PresenceControllerInterface pci = new PresenceController(sessionFactory);
        ParameterControllerInterface parameterControllerInterface = new ParameterController(sessionFactory);

//        eci.delete("14410");
//        System.out.println(gdao.updateStatus("1", "0"));
//        int autiID = pci.getAlls().size() + 101;
//        System.out.println(autiID);

//        for (Object all : eci.getAlls()) {
//            Employee e1 = (Employee) all;
//            System.out.println(e1.getName());
//        }
//       Employee employee = new Employee("12345");
//       Presence presence = new Presence(Integer.valueOf("1234"));
//       Overtime o = new Overtime(1234, Short.parseShort("2"), Long.parseLong("15000"),
//               Short.parseShort("Approve"), "", employee, presence);
////       System.out.println(oci.insert(o));
//for (Object object : oci.getAlls()) {
//            Overtime o = (Overtime) object;
//            System.out.println(o.getOvertimeId()+ " - " + o.getNik());
//        }
//        System.out.println(oci.insert("1234", "2", "15000", "1", "111", "12345", "1234"));
//        System.out.println(oci.insert(new Overtime(1234, Short.parseShort("2"), Long.parseLong("15000"),
//               Short.parseShort("Approve"), "", employee, presence)));
//        Employee e = new Employee("14413", BCrypt.hashpw("adhe", BCrypt.gensalt()));
//    String pass = "admin";
//    String neep = BCrypt.hashpw(pass, BCrypt.gensalt());
//    
//        System.out.println(neep);
//              eci.update("14410", "Ajis", "Ajiaji.com", "$2a$10$wXE3Zz8ZU0enhJlYWQzsD.gp4xkfwSrVROCIMPP0I3Xs1zVLt0Rpu", "08992013", "11/21/2011", "Helper", "10000", "123", "0");
//Presence p = pci.getById("104");
//        System.out.println(p.getCheckIn());
////Presence p = pci.getById("3");
//        System.out.println(p.getCheckIn());
//pci.update("3", "14413", "12/07/2018 11:04:30.403000 AM ASIA/BANGKOK", "12/07/2018", "09/09/2018");
//
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        String time = String.valueOf(timestamp);
//
//        String dates1 = time.substring(11, 19);
//        System.out.println(dates1);

//OvertimeControllerInterface oci1 = new OvertimeController(sessionFactory);
//oci.insert("5", "14413", "124", "3", "30000.00", "0", "da");


        Long percent = parameterControllerInterface.getById("2").getValue();
        double perc = Double.valueOf(percent.doubleValue());
//        int dura = Integer.parseInt(Duration);
        Long salary = eci.getByNIK("14413").getSalary()/30;
        int hasil = (int) (((perc / 100) * salary )* 2);
        System.out.println(hasil);
    }
}
