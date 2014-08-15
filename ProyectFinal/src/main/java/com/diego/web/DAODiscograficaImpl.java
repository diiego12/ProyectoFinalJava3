package com.diego.web;

import static com.diego.web.DAO.close;
import static com.diego.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAODiscograficaImpl extends DAO{
    
    public static void agregarDiscografica(Discografica ds) {
        begin();
        getSession().save(ds);
        commit();
        close();
    }
    
    public static void borrarDiscografica(Discografica ds){
        begin();
        getSession().delete(ds);
        commit();
        close();
    }
    
    public static void actualizarDiscografica(Discografica ds){
        begin();
        getSession().update(ds);
        commit();
        close();
        
    }
    
    public static ArrayList<Discografica> buscarTodosDiscografica() {
        begin();
        Criteria q = getSession().createCriteria(Discografica.class);
        ArrayList<Discografica> dsc = (ArrayList<Discografica>)q.list();
        commit();
        close();
        return dsc; 
    }
    
    
    public static Discografica buscarPorId(int id){
        begin();
        Query q = getSession().createQuery("from Discografica where id = :id");
        q.setInteger("id",id);
        Discografica dsc = (Discografica)q.uniqueResult();
        commit();
        close();
        return dsc;
    }
    
}
