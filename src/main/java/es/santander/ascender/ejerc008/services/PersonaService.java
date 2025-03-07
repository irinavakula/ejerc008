package es.santander.ascender.ejerc008.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.ejerc008.models.Persona;
import es.santander.ascender.ejerc008.repositories.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    public Persona retrievePersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public List<Persona> retrieveAllPersona() {
        return personaRepository.findAll();
    }

    public Persona updatePersona(Long id, Persona persona) {
        if (personaRepository.existsById(id)) {
            persona.setId(id);
            return this.savePersona(persona);
        }
        throw new RuntimeException("Couldn't find persona with id " + id);
    }
}
