package com.app_salas.ApartadoSalas.repository;

import com.app_salas.ApartadoSalas.Entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SalaRepository extends JpaRepository<Sala,Long> {

    @Query("Select s from Sala s where s.nombreSala = :name")
    Optional<Sala> findSalaNameWithJPQL(String name);

    /*
    * consulta con inversion de control*/
    Optional<Sala> findBynombreSala(String name);

    /*
    * consulta que ignore caracteres en mayuscula o minuscula
    * */
    Optional<Sala> findBynombreSalaIgnoreCase(String name);
}
