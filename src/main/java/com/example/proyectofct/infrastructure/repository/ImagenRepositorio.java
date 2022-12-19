package com.example.proyectofct.infrastructure.repository;

import com.example.proyectofct.domain.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepositorio extends JpaRepository<Imagen, Integer> {

}