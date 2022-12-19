package com.example.proyectofct.domain.entity;

import com.example.proyectofct.application.dto.input.InmuebleInputDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inmueble", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_inmueble"})})
public class Inmueble {

    @Id
    @GeneratedValue
    Integer id_inmueble;

    @Column
    String descripcion;

    @Column
    Integer habs;

    @Column
    Integer banos;

    @Column
    Integer m2;

    @Column
    float precio;

    @Column(nullable = false)
    String direccion;

    @Column
    String localidad;

    @Column
    String provincia;

    @Column
    String pais;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_persona")
//    Persona persona;

    @OneToMany(mappedBy="inmueble")
//    @JsonIgnoreProperties(value="inmueble")
    List<Imagen> imagenes;

    public Inmueble(InmuebleInputDTO inmuebleInputDTO) {
        this.id_inmueble = inmuebleInputDTO.getId_inmueble();
        this.descripcion = inmuebleInputDTO.getDescripcion();
        this.habs = inmuebleInputDTO.getHabs();
        this.banos = inmuebleInputDTO.getBanos();
        this.m2 = inmuebleInputDTO.getM2();
        this.precio = inmuebleInputDTO.getPrecio();
        this.direccion = inmuebleInputDTO.getDireccion();
        this.localidad = inmuebleInputDTO.getLocalidad();
        this.provincia = inmuebleInputDTO.getProvincia();
//        this.persona = inmuebleInputDTO.getPersona();
    }
}
