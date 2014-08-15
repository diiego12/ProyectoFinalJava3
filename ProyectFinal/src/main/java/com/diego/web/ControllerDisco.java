package com.diego.web;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControllerDisco {
    @RequestMapping(value= "/disco/{titulo}/{banda}/{año}/{id_banda}",method = RequestMethod.GET,headers = {"Accept=text/html"})
    public @ResponseBody String agregarDisco(@PathVariable String titulo, @PathVariable String banda, @PathVariable @PathVariable int año, @PathVariable int id_banda){
        try{
         DAODiscoImpl dd = new DAODiscoImpl();
         dd.agregarDisco(new Disco(titulo, banda, año, new Banda(id_banda)));
         return "Disco añadido de manera correcta";
        }catch(Exception e){
            return "El id de la banda no existe";
        }
    }
    
     @RequestMapping(value= "/disco/{titulo}/{banda}/{año}/{id_banda}",method = RequestMethod.PUT,headers = {"Accept=text/html"})
     public @ResponseBody String actualizarDisco(@PathVariable String titulo, @PathVariable String banda, @PathVariable @PathVariable int año, @PathVariable int id_banda){
         try{
         DAODiscoImpl dd = new DAODiscoImpl();
         dd.actualizarDisco(new Disco(titulo, banda, año,new Banda(id_banda)));
         return "Datos del disco actualizados de manera correcta";         
         }catch(Exception e){
           return "Error al actualizar";
         }
     }
    
    @RequestMapping(value= "/disco/{id_disco}",method = RequestMethod.DELETE,headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id_disco){
        try{
         DAODiscoImpl dd = new DAODiscoImpl();
         dd.borrarDisco(new Disco(id_disco));
         return "El disco se ha eliminado";
        }catch(Exception e){
            return "No se ha encontrado el id";
        }
    
    @RequestMapping(value= "/disco",method = RequestMethod.GET,headers = {"Accept=Application/json"})  
    public @ResponseBody String buscarTodosDiscos() throws IOException{
        ObjectMapper mapper1 = new ObjectMapper(); 
        return mapper1.writeValueAsString(DAODiscoImpl.buscarTodosDisco());
    }
        
    }
    
   
}
