package com.diego.web;

import static com.diego.web.DAO.close;
import static com.diego.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Query;

public class DAODiscograficaImpl extends DAO{
    
    public void agregarDiscografica(Disco dco) {
    begin();
    getSession().save(dco);
    commit();
    close();
    }
    
    public ArrayList<Discografica> buscarTodosDiscografica() {
        begin();
        Query q = getSession().createQuery("from Discografica");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Discografica> dsc = (ArrayList<Discografica>)q.list();
        commit();
        close();
        return dsc; 
    }
    
    public void borrarDiscografica(Discografica ds){
            begin();
             getSession().delete(ds);
            commit();
            close();
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
