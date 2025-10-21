package com.example.api.mapper;

import com.example.api.dto.CursoDTO;
import com.example.api.dto.ProfesorDTO;
import com.example.api.entities.Profesor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfesorMapper {

    private final CursoMapper cursoMapper;

    public ProfesorMapper(CursoMapper cursoMapper) {
        this.cursoMapper = cursoMapper;
    }

    // Entity → DTO
    public ProfesorDTO toDTO(Profesor entity) {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setEmail(entity.getEmail());

        if (entity.getCursos() != null) {
            List<CursoDTO> cursosDTO = entity.getCursos().stream()
                    .map(cursoMapper::toDTO)
                    .collect(Collectors.toList());
            dto.setCursos(cursosDTO);
        }

        return dto;
    }

    // DTO → Entity (normalmente para crear Profesor)
    public Profesor toEntity(ProfesorDTO dto) {
        Profesor entity = new Profesor();
        entity.setNombre(dto.getNombre());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
