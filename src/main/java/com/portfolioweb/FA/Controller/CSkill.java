
package com.portfolioweb.FA.Controller;

import com.portfolioweb.FA.Dto.dtoskill;
import com.portfolioweb.FA.Entity.Skill;
import com.portfolioweb.FA.Security.Controller.Mensaje;
import com.portfolioweb.FA.Service.SSkill;
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
@CrossOrigin(origins = {"http://localhost:4200","https://francoangiolinipw.web.app"})
@RequestMapping("/skill")

public class CSkill {

    @Autowired
    SSkill sskill;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = sskill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoskill dtosk) {
        if (StringUtils.isBlank(dtosk.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sskill.existsByNombre(dtosk.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa Skill existe"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(dtosk.getNombre(), dtosk.getPorcentaje());
        sskill.save(skill);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoskill dtosk) {

        //validamos si existe el id
        if (!sskill.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //comparo nombre Skill
        if (sskill.existsByNombre(dtosk.getNombre()) && sskill.getByNombre(dtosk.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //no puede estar vacio
        if (StringUtils.isBlank(dtosk.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligarotio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = sskill.getOne(id).get();
        skill.setNombre(dtosk.getNombre());
        skill.setPorcentaje(dtosk.getPorcentaje());
        sskill.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!sskill.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = sskill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe el id
        if (!sskill.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        sskill.delete(id);

        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);

    }
}
