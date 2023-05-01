package com.portofolio.david.Controller;

import com.portofolio.david.Dto.dtoProyecto;
import com.portofolio.david.Entity.Proyecto;
import com.portofolio.david.Security.Controller.Mensaje;
import com.portofolio.david.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")

public class CProyecto {
     @Autowired SProyecto sProyecto;
     
     
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id")int id){
        if(!sProyecto.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
            
            
     }   
    
     @DeleteMapping("delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoProyecto) {
        if (StringUtils.isBlank(dtoProyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("Completar nombre"), HttpStatus.BAD_REQUEST);
        }
        if (sProyecto.existsByNombreP(dtoProyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("Informacion de Proyecto ya existente"), HttpStatus.BAD_REQUEST);
        }

       Proyecto proyecto= new Proyecto (dtoProyecto.getNombreP(), dtoProyecto.getDescripcionP(),dtoProyecto.getLinkP(),dtoProyecto.getImagenP());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Informacion de Proyecto Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoProyecto){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
 
       }
        if(sProyecto.existsByNombreP(dtoProyecto.getNombreP()) && sProyecto
                .getByNombreP(dtoProyecto.getNombreP()).get().getId() !=id){
            
             return new ResponseEntity(new Mensaje("Ese proyecto ya existe"),HttpStatus.BAD_REQUEST);    
        }
        
        if(StringUtils.isBlank(dtoProyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("Campos Obligatorios"),HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombreP(dtoProyecto.getNombreP());
        proyecto.setDescripcionP(dtoProyecto.getDescripcionP());
        proyecto.setLinkP(dtoProyecto.getLinkP());
        proyecto.setImagenP(dtoProyecto.getImagenP());
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Informacion de Proyecto Actualizada Correctamente"),HttpStatus.OK);
      
       
        
    }
}