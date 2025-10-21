package com.example.api.mapper;


import com.example.api.dto.EstudianteDTO;
import com.example.api.entities.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {

    public EstudianteDTO toDTO(Estudiante entity) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setMatricula(entity.getMatricula());
        return dto;
    }

    public Estudiante toEntity(EstudianteDTO dto) {
        Estudiante entity = new Estudiante();
        entity.setNombre(dto.getNombre());
        entity.setMatricula(dto.getMatricula());
        return entity;
    }
}

