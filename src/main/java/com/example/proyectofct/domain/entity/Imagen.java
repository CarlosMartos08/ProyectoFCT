package com.example.proyectofct.domain.entity;

import com.example.proyectofct.application.dto.input.ImagenInputDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "imagen", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_imagen"})})
public class Imagen {

    @Id
    @GeneratedValue
    Integer id_imagen;

    @Column
    String img_url;

    @Column
    String nombre_img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_inmueble", nullable=false)
    @JsonIgnoreProperties(value="imagenes")
    Inmueble inmueble;

    public Imagen(ImagenInputDTO imagenInputDTO) {
        this.id_imagen = imagenInputDTO.getId_imagen();
        this.nombre_img = imagenInputDTO.getNombre_img();
        this.inmueble = imagenInputDTO.getInmueble();
    }
}
