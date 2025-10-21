package com.example.api.mapper;

import com.example.api.dto.CursoDTO;
import com.example.api.dto.EstudianteDTO;
import com.example.api.entities.Curso;
import com.example.api.entities.Estudiante;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CursoMapper {

    private final EstudianteMapper estudianteMapper;

    public CursoMapper(EstudianteMapper estudianteMapper) {
        this.estudianteMapper = estudianteMapper;
    }

    // Entity → DTO
    public CursoDTO toDTO(Curso entity) {
        CursoDTO dto = new CursoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());

        // Convertir estudiantes
        if (entity.getEstudiantes() != null) {
            List<EstudianteDTO> estudiantesDTO = entity.getEstudiantes().stream()
                    .map(estudianteMapper::toDTO)
                    .collect(Collectors.toList());
            dto.setEstudiantes(estudiantesDTO);
        }

        return dto;
    }

    // DTO → Entity
    public Curso toEntity(CursoDTO dto, List<Estudiante> estudiantes) {
        Curso entity = new Curso();
        entity.setNombre(dto.getNombre());
        entity.setEstudiantes(estudiantes);
        return entity;
    }
}
