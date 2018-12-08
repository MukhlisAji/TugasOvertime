/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import entities.Overtime;
import entities.Presence;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Mukhlish
 */
public class PresenceController implements PresenceControllerInterface {

    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private DAOInterface daoi = new GeneralDAO(factory);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public PresenceController(SessionFactory factory, DAOInterface daoi) {
        this.factory = factory;
    }

    public PresenceController() {
    }

    public PresenceController(SessionFactory sessionFactory) {
       this.factory = factory;
    }

    @Override
    public List<Object> getAlls() {
        return daoi.doDDL(new Presence(), "");
    }

    @Override
    public List<Object> search(String key) {
        return daoi.doDDL(new Presence(), key);
    }

    @Override
    public Presence getById(String id) {

        return (Presence) daoi.getById(new Presence(), id);
    }

    @Override
    public boolean insert(String PresenceId, String NIK, String CheckIn, String CheckOut, String PresenceDate) {
        
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date dates = format.parse(PresenceDate);
            System.out.println(dates);
            int presentId = Integer.parseInt(PresenceId);
            Employee nik = new Employee(NIK);

            Presence presence = new Presence(presentId, nik, CheckIn, CheckOut, dates);
            if (daoi.doDML(presence, false)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
//        boolean hasil = false;
//        try {
//            int prId = Integer.parseInt(PresenceId);
//            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//            Date dates = format.parse(PresenceDate);
//            Employee nik = new Employee(NIK);
//            //    Timestamp timestamp = Date.parse(CheckIn);
//            Date Cekin = format.parse(CheckIn);
//            Date CekOut = format.parse(CheckOut);
//            System.out.println(dates);
//            System.out.println(CekOut);
//            System.out.println(Cekin);
//            Presence presence = new Presence(prId, Cekin, CekOut, dates, nik);
//            if (daoi.doDML(presence, true)) {
//            }
//            hasil = true;
//        } catch (Exception es) {
//            es.getMessage();
//        }
//        return hasil;
    }

    @Override
    public boolean update(String PresenceId, String NIK, String CheckIn, String CheckOut, String PresenceDate) {
                try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date dates = format.parse(PresenceDate);
            System.out.println(dates);
            int presentId = Integer.parseInt(PresenceId);
            Employee nik = new Employee(NIK);

            Presence presence = new Presence(presentId, nik, CheckIn, CheckOut, dates);
            if (daoi.doDML(presence, false)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                return false;
    }

    @Override
    public String delete(String id) {
        Presence presence = new Presence(id);
        if (daoi.doDML(presence, true)) {
            return "Berhasil menghapus id = "+ id;
        }
        return "gagal";
    }

}
