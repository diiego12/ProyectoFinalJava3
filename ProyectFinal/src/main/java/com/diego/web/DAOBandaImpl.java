package com.diego.web;

import static com.diego.web.DAO.close;
import static com.diego.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Query;

public class DAOBandaImpl extends DAO{
    
    public void agregarBanda(Banda bnd) {
    begin();
    getSession().save(bnd);
    commit();
    close();
    }
    
    public ArrayList<Banda> buscarTodosBanda() {
        begin();
        Query q = getSession().createQuery("from Banda");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Banda> bd = (ArrayList<Banda>)q.list();
        commit();
        close();
        return bd; 
    }
    
    public void borrarDisco(Banda bd){
            begin();
             getSession().delete(bd);
            commit();
            close();
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
