package com.example.api.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CursoDTO {
    private Long id;
    private String nombre;
    private List<EstudianteDTO> estudiantes;
}

