
package com.portolio.mgb.Service;

import com.portolio.mgb.Entity.Persona;
import com.portolio.mgb.InterFace.IPersonaService;
import com.portolio.mgb.repository.IPersonaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;  
    
    @Override
    public List<Persona> getPersona() {
    List<Persona> persona = ipersonaRepository.findAll();
    return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long Id) {
        ipersonaRepository.deleteById(Id);
    }

    @Override
    public Persona findPersona(Long Id) {
    Persona persona = ipersonaRepository.findById(Id).orElse(null);
    return persona;
    }
    
}
