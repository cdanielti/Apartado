package com.app_salas.ApartadoSalas.service;

import com.app_salas.ApartadoSalas.Entity.Sala;
import com.app_salas.ApartadoSalas.error.LocalNotFoundException;
import com.app_salas.ApartadoSalas.repository.SalaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalaServiceTest {

    @Autowired
    private SalaService salaService;
    @MockBean
    private SalaRepository salaRepository;

    @BeforeEach
    void setUp(){
        Sala sala = Sala.builder()
                .id(10)
                .nombreSala("bachata")
                .build();
        Mockito.when(salaRepository.findBynombreSalaIgnoreCase("bachata")).thenReturn(Optional.of(sala));
    }

    @Test
    void findAllSalas() {
    }

    @Test
    void insertaSala() {
    }

    @Test
    void updateSala() {
    }

    @Test
    void borraSala() {
    }

    @Test
    void findSalaNameWithJPQL() {
    }

    @Test
    void findBynombreSala() {
    }

    @Test
    @DisplayName("prueba de busqueda de nombre" +
            "")
    void findBynombreSalaIgnoreCaseFound() throws LocalNotFoundException {
        String nombre = "bachata";
        Sala sala = salaService.findBynombreSalaIgnoreCase(nombre).get();
        assertEquals(nombre,sala.getNombreSala());
        System.out.println("sala: " + sala);

    }
}