package com.diego.web;

import java.util.ArrayList;
import org.hibernate.Query;


public class DAODiscoImpl extends DAO {
    
    public void agregarDisco(Disco lp) {
    begin();
    getSession().save(lp);
    commit();
    close();
    }
    
    public ArrayList<Disco> buscarTodosDiscos() {
        begin();
        Query q = getSession().createQuery("from Disco");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Disco> cd = (ArrayList<Disco>)q.list();
        commit();
        close();
        return cd; 
    }
    
    public void borrarDisco(Disco d){
            begin();
             getSession().delete(d);
            commit();
            close();
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
