/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

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
    }
    
}
