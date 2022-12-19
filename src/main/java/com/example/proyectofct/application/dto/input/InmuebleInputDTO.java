package com.example.proyectofct.application.dto.input;

import com.example.proyectofct.domain.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InmuebleInputDTO {

    Integer id_inmueble;
    String descripcion;
    int habs;
    int banos;
    int m2;
    float precio;
    String direccion;
    String localidad;
    String provincia;
    Integer id_persona;
    Persona persona;
}
