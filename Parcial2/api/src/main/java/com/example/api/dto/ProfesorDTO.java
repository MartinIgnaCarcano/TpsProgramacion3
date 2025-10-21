package com.example.api.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfesorDTO {
    private Long id;
    private String nombre;
    private String email;
    private List<CursoDTO> cursos;
}

