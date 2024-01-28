package com.app_salas.ApartadoSalas.repository;

import com.app_salas.ApartadoSalas.Entity.Sala;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class SalaRepositoryTest {

    @Autowired
    SalaRepository salaRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Sala sala = Sala.builder()
                        .nombreSala("salsa").build();

        testEntityManager.persist(sala);
    }
    /*
    * prueba donde si encuentra valor*/
    @Test
    void findSalaNameWithJPQLFound() {
        Optional<Sala> sala = salaRepository.findBynombreSalaIgnoreCase("salsa");
        assertEquals(sala.get().getNombreSala(),"salsa");
        System.out.println("sala.get() "+ sala.get());
    }
    /*
     * prueba donde NO encuentra valor*/
    @Test
    void findSalaNameWithJPQLNotFound() {
        Optional<Sala> sala = salaRepository.findBynombreSalaIgnoreCase("cinema");
        assertEquals(sala,Optional.empty());
        System.out.println("sala "+ sala);
    }

    @Test
    public void findBynombreSala() {

    }

    @Test
    void findBynombreSalaIgnoreCase() {
    }
}