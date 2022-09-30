package com.portfolioweb.FA.Repository;

import com.portfolioweb.FA.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer>{
    
    public Optional<Skill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
