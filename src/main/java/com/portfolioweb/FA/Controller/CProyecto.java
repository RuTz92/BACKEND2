package com.portfolioweb.FA.Controller;

import com.portfolioweb.FA.Dto.dtoProyecto;
import com.portfolioweb.FA.Entity.Proyecto;
import com.portfolioweb.FA.Security.Controller.Mensaje;
import com.portfolioweb.FA.Service.SProyecto;
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
@CrossOrigin(origins = {"http://localhost:4200","https://francoangiolinipw.web.app"})

public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto) {
        if (StringUtils.isBlank(dtoproyecto.getProyecto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyecto.existsByNombre(dtoproyecto.getProyecto())) {
            return new ResponseEntity(new Mensaje("Esa Proyecto existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(dtoproyecto.getProyecto(), dtoproyecto.getDescripcion(), dtoproyecto.getFecha(), dtoproyecto.getImg());
        sProyecto.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto) {

        //validamos si existe el id
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //comparo nombre Proyecto
        if (sProyecto.existsByNombre(dtoproyecto.getProyecto()) && sProyecto.getByNombre(dtoproyecto.getProyecto()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //no puede estar vacio
        if (StringUtils.isBlank(dtoproyecto.getProyecto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligarotio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setProyecto(dtoproyecto.getProyecto());
        proyecto.setDescripcion(dtoproyecto.getDescripcion());
        proyecto.setFecha(dtoproyecto.getFecha());
        proyecto.setImg(dtoproyecto.getImg());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe el id
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        sProyecto.delete(id);

        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);

    }
    
}
