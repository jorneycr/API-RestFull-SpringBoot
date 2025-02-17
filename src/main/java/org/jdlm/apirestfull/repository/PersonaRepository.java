package org.jdlm.apirestfull.repository;

import org.jdlm.apirestfull.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query("SELECT p FROM Persona p WHERE p.correo like %?1%")
    public List<Persona> findAllByCorreoContaining(String correo);
    
    @Query("SELECT p FROM Persona p WHERE p.nombre like %?1% or p.apellido like %?2%")
    public List<Persona> findByNombrePersonas(String nombre, String apellido);
}
