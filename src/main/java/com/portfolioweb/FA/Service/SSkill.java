
package com.portfolioweb.FA.Service;

import com.portfolioweb.FA.Entity.Skill;
import com.portfolioweb.FA.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkill {
    @Autowired
    ISkillRepository rSkill;
    
    public List<Skill> list(){
        return rSkill.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return rSkill.findById(id);
    }
    
    public Optional<Skill> getByNombre(String nombre){
        return rSkill.findByNombre(nombre);
    }
    
   public void save(Skill skill){
       rSkill.save(skill);
   }
   
   public void delete(int id){
       rSkill.deleteById(id);
   }
   
   public boolean existsById(int id){
       return rSkill.existsById(id);
   }
   
   public boolean existsByNombre(String nombre){
       return rSkill.existsByNombre(nombre);
   }
}
