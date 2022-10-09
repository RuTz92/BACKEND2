
package com.portfolioweb.FA.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.portfolioweb.FA.Entity.Persona;
import com.portfolioweb.FA.Interface.IPersonaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
//@CrossOrigin(origins = "https://francoangiolinipw.web.app")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired 
    IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
     
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona " + id + " fue eliminada correctamente";
    }
    
    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id, 
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg,
                                @RequestParam("titulo1") String titulo1,
                                @RequestParam("titulo2") String titulo2,
                                @RequestParam("descripcion") String descripcion){
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        persona.setTitulo1(titulo1);
        persona.setTitulo2(titulo2);
        persona.setDescripcion(descripcion);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
            
}
