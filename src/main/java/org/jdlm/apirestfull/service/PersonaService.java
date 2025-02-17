package org.jdlm.apirestfull.service;

import org.jdlm.apirestfull.entity.Persona;
import org.jdlm.apirestfull.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    public List<Persona> findByCorreo(String correo) {
        return personaRepository.findAllByCorreoContaining(correo);
    }

    public List<Persona> findByNombre(String nombre, String apellido) {
        return personaRepository.findByNombrePersonas(nombre, apellido);
    }
}
