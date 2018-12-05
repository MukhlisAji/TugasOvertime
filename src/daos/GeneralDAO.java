/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mukhlish
 */
public class GeneralDAO implements DAOInterface {

    private FunctionDAO fdao;

    public GeneralDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

    /**
     * method for insert, update, or delete
     * @param object
     * @param isDelete
     * @return 
     */
    @Override
    public boolean doDML(Object object, boolean isDelete) {
        return this.fdao.insertOrUpdateOrDelete(object, isDelete);
    }

    @Override
    public Object getById(Object entities, Object id) {
        return this.fdao.getById(entities, id);
    }

    @Override
    public List<Object> doDDL(Object entities, String key) {
       return this.fdao.getDatas(entities, key);
    }

    @Override
    public Object login(Object entities, String Name) {
       return this.fdao.login(entities, Name);
    }


}