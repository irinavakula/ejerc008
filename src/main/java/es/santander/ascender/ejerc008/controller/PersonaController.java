package es.santander.ascender.ejerc008.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc008.models.Persona;
import es.santander.ascender.ejerc008.models.Provincia;
import es.santander.ascender.ejerc008.services.PersonaService;
import es.santander.ascender.ejerc008.services.ProvinciaService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ProvinciaService provinciaService;

    @PatchMapping("/{id}")
    public Persona updatePersonaProvincia(@PathVariable Long id, @RequestBody Long provinciaId) {
        Persona persona = personaService.findById(id);
        if (persona != null) {
            Provincia provincia = provinciaService.findById(provinciaId);
            if (provincia != null) {
                persona.setProvincia(provincia);
            } else {
                return null;
            }
        }
        return null;
    }

    @PostMapping
    public Persona create(@RequestBody Persona persona) {
        return personaService.savePersona(persona);
    }

    @GetMapping("/{id}")
    public Persona retrive(@PathVariable Persona persona) {
        return personaService.savePersona(persona);
    }

    @PutMapping("/{id}")
    public Persona update(@PathVariable("id") Long id, @RequestBody Persona persona) {
        return personaService.updatePersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        personaService.deletePersona(id);
        return "delete";
    }

    @GetMapping
    public List<Persona> list() {
        return personaService.retrieveAllPersona();
    }
}
