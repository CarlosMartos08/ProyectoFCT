package com.example.proyectofct.application.dto.output;

import com.example.proyectofct.domain.entity.Imagen;
import com.example.proyectofct.domain.entity.Inmueble;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InmuebleOutputDTO {

    Integer id_inmueble;
    String descripcion;
    int habs;
    int banos;
    int m2;
    float precio;
    String direccion;
    String localidad;
    String provincia;

    List<Imagen> imagenes;
//    Integer id_persona;
//    PersonaOutputDTO personaOutputDTO;

    public InmuebleOutputDTO(Inmueble inmueble){

        this.id_inmueble = inmueble.getId_inmueble();
        this.descripcion = inmueble.getDescripcion();
        this.habs = inmueble.getHabs();
        this.banos = inmueble.getBanos();
        this.m2 = inmueble.getM2();
        this.precio = inmueble.getPrecio();
        this.direccion = inmueble.getDireccion();
        this.localidad = inmueble.getLocalidad();
        this.provincia = inmueble.getProvincia();
        this.imagenes = inmueble.getImagenes();
//        this.personaOutputDTO = new PersonaOutputDTO(inmueble.getPersona());
    }

}
