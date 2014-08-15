package com.diego.web;

import static com.diego.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;


public class DAODiscoImpl extends DAO {
    
    public static void agregarDisco(Disco d) {
        begin();
        getSession().save(d);
        commit();
        close();
    }
    
    public static void borrarDisco(Disco d){
        begin();
        getSession().delete(d);
        commit();
        close();
    }
    
    public static void actualizarDisco(Disco d){
        begin();
        getSession().update(d);
        commit();
        close();
    }
    
    public static ArrayList<Disco> buscarTodosDiscos() {
        begin();
        Criteria q = getSession().createCriteria(Disco.class);
        ArrayList<Disco> cd = (ArrayList<Disco>)q.list();
        commit();
        close();
        return cd; 
    }
         
    public static Disco buscarPorId(int id){
        begin();
        Query q = getSession().createQuery("from Disco where id = :id");
        q.setInteger("id",id);
        Disco cd = (Disco)q.uniqueResult();
        commit();
        close();
        return cd;
    }
}
