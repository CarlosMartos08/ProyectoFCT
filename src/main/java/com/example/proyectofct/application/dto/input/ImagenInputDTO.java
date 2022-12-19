package com.example.proyectofct.application.dto.input;

import com.example.proyectofct.domain.entity.Inmueble;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagenInputDTO {
    Integer id_imagen;
    String nombre_img;
    Integer id_inmueble;
    Inmueble inmueble;

}
