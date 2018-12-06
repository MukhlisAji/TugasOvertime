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

/**
 *
 * @author Mukhlish
 */
public class OvertimeController implements OvertimeControllerInterface {

    private SessionFactory factory;
    private DAOInterface daoi = new GeneralDAO(factory);

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
    public String insert(String overtimeId, String nik, String presenceId, String otDuration, String fee, String status, String tsFile) {
        int overid = Integer.parseInt(overtimeId);
        Employee employee = new Employee(nik);
        Short otDur = Short.parseShort(otDuration);
        Long fe = Long.parseLong(fee);
        Short stat = Short.parseShort(status);
        Presence presence = new Presence(Integer.valueOf(presenceId));

        Overtime overtime = new Overtime(overid, otDur, fe, stat, tsFile, employee, presence);
        if(daoi.doDML(new Overtime(), false)){
            return "Berhasil menambahkan ID : " + overid;
        }
        return "Gagal";
    }
    
    @Override
    public String update(String overtimeId, String nik, String presenceId, String otDuration, String fee, String status, String tsFile) {
        int overid = Integer.parseInt(overtimeId);
        Employee employee = new Employee(nik);
        Short otDur = Short.parseShort(otDuration);
        Long fe = Long.parseLong(fee);
        Short stat = Short.parseShort(status);
        Presence presence = new Presence(Integer.valueOf(presenceId));

        Overtime overtime = new Overtime(overid, otDur, fe, stat, tsFile, employee, presence);
        if(daoi.doDML(new Overtime(), false)){
            return "Data berhasil di Update";
        }
        return "Gagal";
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
