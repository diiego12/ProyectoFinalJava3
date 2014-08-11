package com.diego.web;

import java.util.ArrayList;
import org.hibernate.Query;


public class DAODiscoImpl extends DAO {
    
    public void agregarDisco(Disco d) {
        begin();
        getSession().save(d);
        commit();
        close();
    }
    
    public void borrarDisco(Disco d){
        begin();
        getSession().delete(d);
        commit();
        close();
    }
    
    public void actualizarDisco(Disco d){
        begin();
        getSession().update(d);
        commit();
        close();
    }
    
    public ArrayList<Disco> buscarTodosDiscos() {
        begin();
        Query q = getSession().createQuery("from Disco");
        ArrayList<Disco> cd = (ArrayList<Disco>)q.list();
        commit();
        close();
        return cd; 
    }
         
    public Disco buscarPorId(int id){
        begin();
        Query q = getSession().createQuery("from Disco where id = :id");
        q.setInteger("id",id);
        Disco cd = (Disco)q.uniqueResult();
        commit();
        close();
        return cd;
    }
}
