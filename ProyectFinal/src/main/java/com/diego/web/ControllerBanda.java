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
public class ControllerBanda {
    @RequestMapping(value= "/banda/{nombre}/{pais}/{discografica}",method = RequestMethod.GET,headers = {"Accept=text/html"})
    public @ResponseBody String agregarBanda(@PathVariable String nombre, @PathVariable String pais, @PathVariable int discografica){
        try{
         DAOBandaImpl db = new DAOBandaImpl();
         db.agregarBanda(new Banda(nombre, pais, new Discografica(discografica)));
         return "Banda añadida de manera correcta";
        }catch(Exception e){
            return "No existe el id de la Discografica";
        }
    }
    
     @RequestMapping(value= "/banda/{nombre}/{pais}/{id_discografica}",method = RequestMethod.PUT,headers = {"Accept=text/html"})
     public @ResponseBody String actualizarBanda(@PathVariable String nombre, @PathVariable String pais, @PathVariable int id_discografica){
         try{
          DAOBandaImpl db = new DAOBandaImpl();
          db.actualizarBanda(new Banda(nombre, pais, null));
         return "Banda actualizada";
         }catch(Exception e){
           return "Error al actualizar";
         }
     }
    
    @RequestMapping(value= "/banda/{id_banda}",method = RequestMethod.DELETE,headers = {"Accept=text/html"})
    public @ResponseBody String eliminarBanda(@PathVariable int id_banda){
        try{
         DAOBandaImpl db = new DAOBandaImpl();
         db.borrarBanda(new Banda(id_banda));
         return "La banda se ha eliminado";
        }catch(Exception e){
         return "No se ha encontrado el id";
        }
    }
    
   @RequestMapping(value= "/banda",method = RequestMethod.GET,headers = {"Accept=Application/json"})  
    public @ResponseBody  String bucarTodos() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOBandaImpl.buscarTodosBanda());
        
    }
        
    @RequestMapping(value= "/banda/{id_banda}",method = RequestMethod.GET,headers = {"Accept=text/html"}) 
    public @ResponseBody String buscarID(@PathVariable int id_banda){
        return DAOBandaImpl.buscarPorId(id_banda).toString();
    } 
        
        
}
