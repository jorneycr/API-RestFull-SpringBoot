package org.jdlm.apirestfull.controller;

import org.jdlm.apirestfull.entity.Persona;
import org.jdlm.apirestfull.service.PersonaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/person")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> finAll(){
        return personaService.findAll();
    }

    @PostMapping
    public void savePerson(@RequestBody Persona persona){
        personaService.save(persona);
    }

    @GetMapping("/correo")
    public List<Persona> findByCorreo(@RequestParam String correo){
        return personaService.findByCorreo(correo);
    }

    @GetMapping("/nombre")
    public List<Persona> findByNombre(@RequestParam String nombre, @RequestParam String apellido){
        return personaService.findByNombre(nombre, apellido);
    }

}
