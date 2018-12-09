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
import java.util.List;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Mukhlish
 */
public class OvertimeController implements OvertimeControllerInterface {

    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private DAOInterface daoi = new GeneralDAO(factory);

    public OvertimeController(SessionFactory factory, DAOInterface daoi) {
        this.daoi = daoi;
    }

    public OvertimeController() {
    }

    public OvertimeController(SessionFactory sessionFactory) {
        this.factory = factory;
    }

    @Override
    public List<Object> getAlls() {
        return daoi.doDDL(new Overtime(), "");
    }

    @Override
    public List<Object> search(String key) {
        return daoi.doDDL(new Overtime(), key);
    }

    @Override
    public Overtime getById(String id) {
        return (Overtime) daoi.getById(new Overtime(), id);
    }

    @Override
    public boolean insert(String overtimeId, String nik, String presenceId, String otDuration, String fee, String status, String tsFile) {
        int overid = Integer.parseInt(overtimeId);
        Employee employee = new Employee(nik);
        Short otDur = Short.parseShort(otDuration);
        Long fe = Long.parseLong(fee);
        Short stat = Short.parseShort(status);
        Presence presence = new Presence(Integer.valueOf(presenceId));
        Overtime overtime = new Overtime(overid, otDur, fe, stat, tsFile, employee, presence);
        if(daoi.doDML(overtime, false)){
            return true;
        }
        return false;
    }
    
    @Override
    public boolean update(String overtimeId, String nik, String presenceId, String otDuration, String fee, String status, String tsFile) {
        int overid = Integer.parseInt(overtimeId);
        Employee employee = new Employee(nik);
        Short otDur = Short.parseShort(otDuration);
        Long fe = Long.parseLong(fee);
        Short stat = Short.parseShort(status);
        Presence presence = new Presence(Integer.valueOf(presenceId));

        Overtime overtime = new Overtime(overid, otDur, fe, stat, tsFile, employee, presence);
        if(daoi.doDML(overtime, false)){
            return true;
        }
        return false;
    }

    @Override
    public String delete(String id) {
        int overid = Integer.parseInt(id);
        Overtime overtime = new Overtime(overid);
        if(daoi.doDML(new Overtime(), true)){
            return "Data berhasil di Hapus";
        }
        return "Gagal";
    }
}
