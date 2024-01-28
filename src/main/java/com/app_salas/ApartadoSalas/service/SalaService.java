package com.app_salas.ApartadoSalas.service;

import com.app_salas.ApartadoSalas.Entity.Sala;
import com.app_salas.ApartadoSalas.error.LocalNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SalaService {
    List<Sala> findAllSalas();
    Sala insertaSala(Sala sala);
    Sala updateSala(Long id, Sala sala);
    void borraSala(Long id);

    /*
    * retorno optional en lugar de list pues no se
    * sabe cuantos registros se van a rtornar
    * */
    Optional<Sala> findSalaNameWithJPQL(String name);

    Optional<Sala> findBynombreSala(String name);

    Optional<Sala> findBynombreSalaIgnoreCase(String name) throws LocalNotFoundException;

}
