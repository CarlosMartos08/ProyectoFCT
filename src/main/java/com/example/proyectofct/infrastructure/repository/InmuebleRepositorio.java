package com.example.proyectofct.infrastructure.repository;

import com.example.proyectofct.domain.entity.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepositorio extends JpaRepository<Inmueble, Integer> {

//    Inmueble findAllByPersona(Integer id);
}
