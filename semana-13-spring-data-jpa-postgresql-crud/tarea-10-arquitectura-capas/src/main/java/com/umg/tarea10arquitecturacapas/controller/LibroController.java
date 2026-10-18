package com.umg.tarea10arquitecturacapas.controller;

import  com.umg.tarea10arquitecturacapas.entity.Libro;
import  com.umg.tarea10arquitecturacapas.repository.LibroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Joshua Israel Flores Pérez
 * @Carnet 9941-25-9403
 */

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> listarTodos() {
        List<Libro> libros = libroRepository.findAll();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarPorID(@PathVariable Long id){
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libro> guardar(@RequestBody Libro libro) {
        libro.setId(null);

        Libro nuevoLibro = libroRepository.save(libro);

        return ResponseEntity.status(201).body(nuevoLibro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro libroActualizado) {
        Optional<Libro> libroExistente = libroRepository.findById(id);

        if (libroExistente.isPresent()) {
            Libro libro = libroExistente.get();

            libro.setCodigo(libroActualizado.getCodigo());
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setCategoria(libroActualizado.getCategoria());
            libro.setAnioPublicacion(libroActualizado.getAnioPublicacion());
            libro.setPrecio(libroActualizado.getPrecio());
            libro.setDisponible(libroActualizado.getDisponible());

            Libro libroGuardado = libroRepository.save(libro);
            return ResponseEntity.ok(libroGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Libro>> buscarPorCategoria(@PathVariable String categoria) {
        List<Libro> libros = libroRepository.findByCategoria(categoria);
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Libro>> listarDisponibles() {
        List<Libro> libros = libroRepository.findByDisponibleTrue();
        return ResponseEntity.ok(libros);
    }
}
