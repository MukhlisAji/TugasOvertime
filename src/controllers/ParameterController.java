/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Parameter;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author AD
 */
public class ParameterController implements ParameterControllerInterface {

    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private DAOInterface daoi = new GeneralDAO(factory);

    public ParameterController() {
    }

    public ParameterController(SessionFactory sessionFactory) {
        this.factory = factory;
    }

    @Override
    public List<Object> getAlls() {
        return daoi.doDDL(new Parameter(), "");
    }

    @Override
    public List<Object> search(String key) {
        return daoi.doDDL(new Parameter(), key);
    }

    @Override
    public Parameter getById(String id) {
        return (Parameter) daoi.getById(new Parameter(), id);
    }

    @Override
    public boolean insert(String paramaterId, String parameterName, String value) {
        try {
            int paraId = Integer.parseInt(paramaterId);
            Long val = Long.getLong(value);

            Parameter para = new Parameter(paraId, parameterName, val);
            if (daoi.doDML(para, false)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(String paramaterId, String parameterName, String value) {
        try {
           int paraId = Integer.parseInt(paramaterId);
            Long val = Long.getLong(value);

            Parameter para = new Parameter(paraId, parameterName, val);
            if (daoi.doDML(para, false)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int paraId = Integer.parseInt(id);
        Parameter parameter = new Parameter(paraId);
        if (daoi.doDML(parameter, true)) {
            return true;
        }
        return false;
    }
}
