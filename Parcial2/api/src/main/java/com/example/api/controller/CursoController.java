package com.example.api.controller;

import com.example.api.dto.CursoDTO;
import com.example.api.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // 🔹 Listar todos
    @GetMapping
    public List<CursoDTO> listar() {
        return cursoService.listar();
    }

    // 🔹 Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.obtenerPorId(id));
    }

    // 🔹 Crear curso
    @PostMapping
    public ResponseEntity<CursoDTO> crear(@RequestBody CursoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.crear(dto));
    }

    // 🔹 Actualizar curso
    @PatchMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizar(@PathVariable Long id, @RequestBody CursoDTO dto) {
        return ResponseEntity.ok(cursoService.actualizar(id, dto));
    }

    // 🔹 Eliminar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Agregar estudiante a un curso
    @PostMapping("/{cursoId}/estudiantes/{estudianteId}")
    public ResponseEntity<CursoDTO> agregarEstudiante(
            @PathVariable Long cursoId,
            @PathVariable Long estudianteId) {
        return ResponseEntity.ok(cursoService.agregarEstudiante(cursoId, estudianteId));
    }
}