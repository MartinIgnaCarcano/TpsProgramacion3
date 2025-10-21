package com.example.api.service;

import com.example.api.dto.CursoDTO;
import com.example.api.dto.EstudianteDTO;
import com.example.api.entities.Curso;
import com.example.api.entities.Estudiante;
import com.example.api.mapper.CursoMapper;
import com.example.api.repository.CursoRepository;
import com.example.api.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired private CursoRepository cursoRepository;
    @Autowired private EstudianteRepository estudianteRepository;
    @Autowired private CursoMapper cursoMapper;

    @Override
    public List<CursoDTO> listar() {
        return cursoRepository.findAll()
                .stream()
                .map(cursoMapper::toDTO)
                .toList();
    }

    @Override
    public CursoDTO obtenerPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        return cursoMapper.toDTO(curso);
    }

    @Override
    @Transactional
    public CursoDTO crear(CursoDTO dto) {
        List<Estudiante> estudiantes = new ArrayList<>();
        if (dto.getEstudiantes() != null) {
            for (EstudianteDTO eDTO : dto.getEstudiantes()) {
                Estudiante e = estudianteRepository.findById(eDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
                estudiantes.add(e);
            }
        }

        Curso curso = cursoMapper.toEntity(dto, estudiantes);
        return cursoMapper.toDTO(cursoRepository.save(curso));
    }

    @Override
    @Transactional
    public CursoDTO actualizar(Long id, CursoDTO dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        curso.setNombre(dto.getNombre());

        // Actualizamos estudiantes si vienen en el DTO
        if (dto.getEstudiantes() != null) {
            curso.getEstudiantes().clear();
            for (EstudianteDTO eDTO : dto.getEstudiantes()) {
                Estudiante e = estudianteRepository.findById(eDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
                curso.agregarEstudiante(e);
            }
        }

        return cursoMapper.toDTO(cursoRepository.save(curso));
    }

    @Override
    public void eliminar(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso no encontrado");
        }
        cursoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CursoDTO agregarEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Estudiante estu = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        curso.agregarEstudiante(estu);
        return cursoMapper.toDTO(cursoRepository.save(curso));
    }
}