package com.example.proyectofct.infrastructure.repository;

import com.example.proyectofct.domain.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

    List<Persona> findByName(String name);
    Persona findByUsuario(String usuario);
}
