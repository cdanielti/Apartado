package com.app_salas.ApartadoSalas.Controller;

import com.app_salas.ApartadoSalas.Entity.Saludo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SaludoController {

    private static final String template = "Hola ,%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/saludo")
    public Saludo holaMundo(@RequestParam(value="nombre",defaultValue = "mundo")String nombre){
        //return new Saludo(counter.incrementAndGet(),String.format(template,nombre));
        return new Saludo(counter.incrementAndGet(),String.format(template,nombre));
    }
}
