package com.app_salas.ApartadoSalas.Controller;

import com.app_salas.ApartadoSalas.Entity.Sala;
import com.app_salas.ApartadoSalas.error.LocalNotFoundException;
import com.app_salas.ApartadoSalas.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalaController {

    @Autowired
    SalaService salaService;
    @GetMapping("/findAllsalas")
    public List<Sala> findAllsalas(){
        return salaService.findAllSalas();
    }

    @PostMapping("/creaSala")
    public Sala creaSala(@Valid @RequestBody Sala sala){
        return salaService.insertaSala(sala);
    }

    @PutMapping("/updateSala/{id}")
    public Sala updateSala(@PathVariable Long id ,@RequestBody Sala sala){

        return salaService.updateSala(id,sala);
    }

    @DeleteMapping("/borraSala/{id}")
    public String borraSala(@PathVariable Long id){
        salaService.borraSala(id);
        return "Successfully deleted";
    }

    @GetMapping("/buscaSalaXNombre/{nombre}")
    public Optional<Sala> buscasalaXNombre(@PathVariable String nombre) throws LocalNotFoundException {
        //return salaService.findSalaNameWithJPQL(nombre);
        //return salaService.findBynombreSala(nombre);
        return salaService.findBynombreSalaIgnoreCase(nombre);
    }


}