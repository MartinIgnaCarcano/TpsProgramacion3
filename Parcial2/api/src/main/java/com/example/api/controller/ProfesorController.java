package com.example.api.controller;

import com.example.api.dto.ProfesorDTO;
import com.example.api.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@CrossOrigin
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    // 🔹 Listar todos
    @GetMapping
    public List<ProfesorDTO> listar() {
        return profesorService.listar();
    }

    // 🔹 Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(profesorService.obtenerPorId(id));
    }

    // 🔹 Crear profesor
    @PostMapping
    public ResponseEntity<ProfesorDTO> crear(@RequestBody ProfesorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.crear(dto));
    }

    // 🔹 Actualizar profesor
    @PatchMapping("/{id}")
    public ResponseEntity<ProfesorDTO> actualizar(@PathVariable Long id, @RequestBody ProfesorDTO dto) {
        return ResponseEntity.ok(profesorService.actualizar(id, dto));
    }

    // 🔹 Eliminar profesor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Agregar curso a profesor
    @PostMapping("/{profesorId}/cursos/{cursoId}")
    public ResponseEntity<ProfesorDTO> agregarCurso(
            @PathVariable Long profesorId,
            @PathVariable Long cursoId) {
        return ResponseEntity.ok(profesorService.agregarCurso(profesorId, cursoId));
    }
}