
package com.portolio.mgb.InterFace;
    //Para traer un lista de pers
import com.portolio.mgb.Entity.Persona;
import java.util.List;


    
public interface IPersonaService {
    
    public List<Persona> getPersona();
//guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    //eliminar objeto usuario, pero lo buscamos por ID
    public void deletePersona(Long Id);
    //buscar una persona por Id
    public Persona findPersona(Long Id);
}
