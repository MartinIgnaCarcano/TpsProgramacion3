package com.example.api.service;

import com.example.api.dto.EstudianteDTO;
import com.example.api.entities.Estudiante;
import com.example.api.mapper.EstudianteMapper;
import com.example.api.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired private EstudianteRepository estudianteRepository;
    @Autowired private EstudianteMapper estudianteMapper;

    @Override
    public List<EstudianteDTO> listar() {
        return estudianteRepository.findAll()
                .stream()
                .map(estudianteMapper::toDTO)
                .toList();
    }

    @Override
    public EstudianteDTO obtenerPorId(Long id) {
        Estudiante est = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return estudianteMapper.toDTO(est);
    }

    @Override
    public EstudianteDTO crear(EstudianteDTO dto) {
        Estudiante est = estudianteMapper.toEntity(dto);
        return estudianteMapper.toDTO(estudianteRepository.save(est));
    }

    @Override
    public EstudianteDTO actualizar(Long id, EstudianteDTO dto) {
        Estudiante est = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        est.setNombre(dto.getNombre());
        est.setMatricula(dto.getMatricula());

        return estudianteMapper.toDTO(estudianteRepository.save(est));
    }

    @Override
    public void eliminar(Long id) {
        if (!estudianteRepository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado");
        }
        estudianteRepository.deleteById(id);
    }
}