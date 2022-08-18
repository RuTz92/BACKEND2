
package com.portfolioweb.FA.Security.Repository;

import com.portfolioweb.FA.Security.Entity.Rol;
import com.portfolioweb.FA.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
