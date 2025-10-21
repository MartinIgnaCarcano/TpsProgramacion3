package com.example.api.service;

import com.example.api.dto.CursoDTO;

import java.util.List;

public interface CursoService {
    List<CursoDTO> listar();
    CursoDTO obtenerPorId(Long id);
    CursoDTO crear(CursoDTO dto);
    CursoDTO actualizar(Long id, CursoDTO dto);
    void eliminar(Long id);

    // Metodo especial
    CursoDTO agregarEstudiante(Long cursoId, Long estudianteId);
}
