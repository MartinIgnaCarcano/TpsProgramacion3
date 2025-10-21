package com.example.api.service;

import com.example.api.dto.ProfesorDTO;
import com.example.api.entities.Curso;
import com.example.api.entities.Profesor;
import com.example.api.mapper.ProfesorMapper;
import com.example.api.repository.CursoRepository;
import com.example.api.repository.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired private ProfesorRepository profesorRepository;
    @Autowired private CursoRepository cursoRepository;
    @Autowired private ProfesorMapper profesorMapper;

    @Override
    public List<ProfesorDTO> listar() {
        return profesorRepository.findAll()
                .stream()
                .map(profesorMapper::toDTO)
                .toList();
    }

    @Override
    public ProfesorDTO obtenerPorId(Long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        return profesorMapper.toDTO(profesor);
    }

    @Override
    @Transactional
    public ProfesorDTO crear(ProfesorDTO dto) {
        Profesor profesor = profesorMapper.toEntity(dto);
        return profesorMapper.toDTO(profesorRepository.save(profesor));
    }

    @Override
    @Transactional
    public ProfesorDTO actualizar(Long id, ProfesorDTO dto) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        profesor.setNombre(dto.getNombre());
        profesor.setEmail(dto.getEmail());

        return profesorMapper.toDTO(profesorRepository.save(profesor));
    }

    @Override
    public void eliminar(Long id) {
        if (!profesorRepository.existsById(id)) {
            throw new RuntimeException("Profesor no encontrado");
        }
        profesorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ProfesorDTO agregarCurso(Long profesorId, Long cursoId) {
        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        profesor.getCursos().add(curso);
        return profesorMapper.toDTO(profesorRepository.save(profesor));
    }
}
