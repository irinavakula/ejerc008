package es.santander.ascender.ejerc008.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejerc008.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
