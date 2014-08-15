package com.diego.web;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class ControllerDiscografica {
    @RequestMapping(value= "/discografica/{nombre}/{pais}",method = RequestMethod.GET,headers = {"Accept=text/html"})
    public @ResponseBody String agregarDiscografica(@PathVariable String nombre, @PathVariable String pais){
        try{
         DAODiscograficaImpl dd = new DAODiscograficaImpl();
         dd.agregarDiscografica(new Discografica(Integer.MIN_VALUE, nombre, pais));
         return "Discografica añadida de manera correcta";
        }catch(Exception e){
            return "No se pudo añadir por alguna extraña razón";
        }
    }
    
     @RequestMapping(value= "/discografica/{nombre}/{pais}",method = RequestMethod.PUT,headers = {"Accept=text/html"})
     public @ResponseBody String actualizarDiscografica(@PathVariable String nombre, @PathVariable String pais){
         try{
          DAODiscograficaImpl dd = new DAODiscograficaImpl();
          dd.actualizarDiscografica(new Discografica(Integer.MIN_VALUE, nombre, pais));
         return "Discografica actualizada";
         }catch(Exception e){
           return "Error al actualizar";
         }
     }
    
    @RequestMapping(value= "/discografica/{id_discografica}",method = RequestMethod.DELETE,headers = {"Accept=text/html"})
    public @ResponseBody String eliminarDiscografica(@PathVariable int id_discografica){
        try{
         DAODiscograficaImpl dd = new DAODiscograficaImpl();
         dd.borrarDiscografica(new Discografica(id_discografica));
         return "La discografica se ha eliminado";
        }catch(Exception e){
         return "No se ha encontrado el id";
        }
    }
    
    @RequestMapping(value= "/discografica",method = RequestMethod.GET,headers = {"Accept=Application/json"})  
    public @ResponseBody  String bucarTodos() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAODiscograficaImpl.buscarTodosDiscografica());
        
    }
        
    @RequestMapping(value= "/discografica/{id_discografica}",method = RequestMethod.GET,headers = {"Accept=text/html"}) 
    public @ResponseBody String buscarID(@PathVariable int id_disco){
        return DAODiscograficaImpl.buscarPorId(id_disco).toString();
    } 
}
