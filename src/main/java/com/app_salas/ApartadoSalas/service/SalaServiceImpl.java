package com.app_salas.ApartadoSalas.service;

import com.app_salas.ApartadoSalas.Entity.Sala;
import com.app_salas.ApartadoSalas.error.LocalNotFoundException;
import com.app_salas.ApartadoSalas.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class SalaServiceImpl implements SalaService{

    @Autowired
    SalaRepository salaRepository;

    @Override
    public List<Sala> findAllSalas(){
        return salaRepository.findAll();
    }

    @Override
    public Sala insertaSala(Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public Sala updateSala(Long id, Sala sala) {

        Sala salaDb = salaRepository.findById(id).get();

        if (Objects.nonNull((sala.getNombreSala())) && !"".equalsIgnoreCase(sala.getNombreSala())) {
            salaDb.setNombreSala(sala.getNombreSala());
        }
        return salaRepository.save(salaDb);
    }

    @Override
    public void borraSala(Long id) {
        salaRepository.deleteById(id);

    }

    @Override
    public Optional<Sala> findSalaNameWithJPQL(String name) {
        return salaRepository.findSalaNameWithJPQL(name);
    }

    @Override
    public Optional<Sala> findBynombreSala(String name) {
        return salaRepository.findBynombreSala(name);
    }

    @Override
    public Optional<Sala> findBynombreSalaIgnoreCase(String name) throws LocalNotFoundException {

        return salaRepository.findBynombreSalaIgnoreCase(name);
        /*
        Optional<Sala> sala = salaRepository.findBynombreSalaIgnoreCase(name);

        if (sala.isEmpty()){
            throw new LocalNotFoundException("no disponible");
        }

        return sala;
        */

    }

}
