package com.example.api.dto;

import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String matricula;
}
