/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Mukhlish
 */
public class FunctionDAO {

    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private Session session;
    private Transaction transaction;

    public FunctionDAO() {
    }

    public FunctionDAO(SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Fungsi untuk melakukan insert atau update Region
     *
     * @param region
     * @param isDelete
     * @return
     */
    public boolean insertOrUpdateOrDelete(Object object,
            boolean isDelete) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isDelete) {
                session.delete(object);
            } else {
                session.saveOrUpdate(object);
            }
            result = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    /**
     *
     * @param query
     * @return
     */
    public List<Object> getDatas(Object entities, String key) {
        List<Object> ent = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            String className = entities.getClass().getName();

            className = className.substring(className.lastIndexOf(".") + 1);
            String query = ("From " + className);

            if (key.equals("")) {
                ent = session.createQuery(query).list();
            } else {
                query += (" WHERE ");
                Short Count = 0;
                for (Object o : entities.getClass().getDeclaredFields()) {
                    String field = o + "";
                    if (!field.contains("UID") && !field.contains("List")) {
                        field = field.substring(field.lastIndexOf(".") + 1);
                        //System.out.println(field);
                        query += field + " LIKE '%" + key + "%' ";
                        if (Count < entities.getClass().getDeclaredFields().length - 2) {
                            query += "OR ";
                        }
                    }
                    Count++;
                }
                ent = session.createQuery(query).list();
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return ent;
    }

    /**
     *
     * @param query
     * @return
     */
    public Object getById(Object entities, Object id) {
        Object object = new Object();        
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = ("From " + className + " WHERE ");
                
        try {
            for (Object o : entities.getClass().getDeclaredFields()) {
//            System.out.println(o);
            String field = o+"";
            if (field.contains("java.lang") && field.contains("Id")) {
                        field = field.substring(field.lastIndexOf(".") + 1);
//                        System.out.println(field);
                        query += field + " = " + id;
            }
        }
            session = factory.openSession();
            transaction = session.beginTransaction();
            object = session.createQuery(query)
                    .uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return object;
    }
    
    public Object login(Object entities, String Name){
        Object object = new Object();      
//        boolean result = false;
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = ("From "+className+" WHERE Username = '"+ Name +"'");
                
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            object = session.createQuery(query).uniqueResult();
            transaction.commit();
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return object;
    }
    
}
