package com.app_salas.ApartadoSalas.Controller;

import com.app_salas.ApartadoSalas.Entity.Sala;
import com.app_salas.ApartadoSalas.service.SalaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SalaController.class)
class SalaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalaService salaService;

    private Sala sala;

    @BeforeEach
    void setUp() {

        sala = Sala.builder()
                .id(25)
                .nombreSala("salamoquito")
                .build();

    }

    @Test
    void findAllsalas() {
    }

    @Test
    void insertaSala() throws Exception {
        Sala postSala = Sala.builder()
                .id(15)
                .nombreSala("desdetest")
                .build();
        Mockito.when(salaService.insertaSala(postSala)).thenReturn(sala);
        mockMvc.perform(post("/creaSala").contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"nombreSala\":\"salamoquito\",\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void updateSala() {
    }

    @Test
    void borraSala() {
    }

    @Test
    void buscasalaXNombre() {
    }
}