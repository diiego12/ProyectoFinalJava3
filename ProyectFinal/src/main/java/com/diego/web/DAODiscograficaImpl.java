package com.diego.web;

import static com.diego.web.DAO.close;
import static com.diego.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Query;

public class DAODiscograficaImpl extends DAO{
    
    public void agregarDiscografica(Discografica ds) {
        begin();
        getSession().save(ds);
        commit();
        close();
    }
    
    public void borrarDiscografica(Discografica ds){
        begin();
        getSession().delete(ds);
        commit();
        close();
    }
    
    public void actualizarDiscografica(Discografica ds){
        begin();
        getSession().update(ds);
        commit();
        close();
        
    }
    
    public ArrayList<Discografica> buscarTodosDiscografica() {
        begin();
        Query q = getSession().createQuery("from Discografica");
        ArrayList<Discografica> dsc = (ArrayList<Discografica>)q.list();
        commit();
        close();
        return dsc; 
    }
    
    
    public Discografica buscarPorId(int id){
        begin();
        Query q = getSession().createQuery("from Discografica where id = :id");
        q.setInteger("id",id);
        Discografica dsc = (Discografica)q.uniqueResult();
        commit();
        close();
        return dsc;
    }
    
}
