package com.example.api.service;

import com.example.api.dto.EstudianteDTO;

import java.util.List;

public interface EstudianteService {
    List<EstudianteDTO> listar();
    EstudianteDTO obtenerPorId(Long id);
    EstudianteDTO crear(EstudianteDTO dto);
    EstudianteDTO actualizar(Long id, EstudianteDTO dto);
    void eliminar(Long id);
}
