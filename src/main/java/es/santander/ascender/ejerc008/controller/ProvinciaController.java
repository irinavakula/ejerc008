package es.santander.ascender.ejerc008.controller;

import java.util.List;
import es.santander.ascender.ejerc008.services.ProvinciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc008.models.Provincia;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @PostMapping
    public Provincia create(@RequestBody Provincia provincia) {
        return provinciaService.saveProvincia(provincia);
    }

    @GetMapping("/{id}")
    public Provincia retrive(@PathVariable("id") Long id) {
        return provinciaService.retrieveProvincia(id);
    }

    @PutMapping("/{id}")
    public Provincia update(@PathVariable("id") Long id, @RequestBody Provincia provincia) {
        return provinciaService.updateProvincia(id, provincia);
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        provinciaService.deleteProvincia(id);
        return "delete";
    }

    @GetMapping
    public List<Provincia> list() {
        return provinciaService.retrieveAllProvincias();
    }
}
