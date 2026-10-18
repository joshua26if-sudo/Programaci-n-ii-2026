package com.umg.tarea10arquitecturacapas.repository;

import  com.umg.tarea10arquitecturacapas.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByCategoria(String categoria);
    List<Libro> findByDisponibleTrue();
}


