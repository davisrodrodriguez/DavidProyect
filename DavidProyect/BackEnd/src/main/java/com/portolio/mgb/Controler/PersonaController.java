
package com.portolio.mgb.Controler;


import com.portolio.mgb.Entity.Persona;
import com.portolio.mgb.InterFace.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    @DeleteMapping("/personas/borrar/{Id}")
    public String deletePersona(@PathVariable Long Id){
        ipersonaService.deletePersona(Id);
        return "La persona fue eliminada correcctamente";
    }
    //URL:PUERTO/personas/editar/4/nombre & apellido & img
    @PutMapping("/personas/editar/{Id}")
    public Persona editPersona(@PathVariable Long Id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg){
        Persona persona = ipersonaService.findPersona(Id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }    
    
    @GetMapping("/personas/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
}

