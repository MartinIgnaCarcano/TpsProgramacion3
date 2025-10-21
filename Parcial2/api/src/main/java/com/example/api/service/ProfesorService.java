package com.example.api.service;

import com.example.api.dto.ProfesorDTO;

import java.util.List;

public interface ProfesorService {
    List<ProfesorDTO> listar();
    ProfesorDTO obtenerPorId(Long id);
    ProfesorDTO crear(ProfesorDTO dto);
    ProfesorDTO actualizar(Long id, ProfesorDTO dto);
    void eliminar(Long id);

    // Metodo especial
    ProfesorDTO agregarCurso(Long profesorId, Long cursoId);
}
