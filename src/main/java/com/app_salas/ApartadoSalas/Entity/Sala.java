package com.app_salas.ApartadoSalas.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="sala")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Agregar nombre de sala")
    @Length(min = 2,max = 10)
    private String nombreSala;
}
