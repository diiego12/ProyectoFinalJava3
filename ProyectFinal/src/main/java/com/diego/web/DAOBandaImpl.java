package com.diego.web;

import static com.diego.web.DAO.close;
import static com.diego.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Query;

public class DAOBandaImpl extends DAO{
    
    public void agregarBanda(Banda b) {
        begin();
        getSession().save(b);
        commit();
        close();
    }
    
    public void borrarBanda(Banda b){
        begin();
        getSession().delete(b);
        commit();
        close();
    }
    
    public void actualizarBanda(Banda b){
        begin();
        getSession().update(b);
        commit();
        close();
    }
    
    public ArrayList<Banda> buscarTodosBanda() {
        begin();
        Query q = getSession().createQuery("from Banda");
        ArrayList<Banda> bd = (ArrayList<Banda>)q.list();
        commit();
        close();
        return bd; 
    }
    
      
    public Banda buscarPorId(int id){
        begin();
        Query q = getSession().createQuery("from Banda where id = :id");
        q.setInteger("id",id);
        Banda bd = (Banda)q.uniqueResult();
        commit();
        close();
        return bd;
    }
    
}
