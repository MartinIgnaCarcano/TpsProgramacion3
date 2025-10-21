package com.example.api.controller;

import com.example.api.dto.EstudianteDTO;
import com.example.api.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // 🔹 Listar todos
    @GetMapping
    public List<EstudianteDTO> listar() {
        return estudianteService.listar();
    }

    // 🔹 Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.obtenerPorId(id));
    }

    // 🔹 Crear estudiante
    @PostMapping
    public ResponseEntity<EstudianteDTO> crear(@RequestBody EstudianteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.crear(dto));
    }

    // 🔹 Actualizar estudiante
    @PatchMapping("/{id}")
    public ResponseEntity<EstudianteDTO> actualizar(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
        return ResponseEntity.ok(estudianteService.actualizar(id, dto));
    }

    // 🔹 Eliminar estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
