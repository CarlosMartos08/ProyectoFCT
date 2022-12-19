package com.example.proyectofct.application.dto.output;

import com.example.proyectofct.domain.entity.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImagenOutputDTO {

    Integer id_imagen;
    String nombre_img;
    Integer id_inmueble;
    InmuebleOutputDTO inmuebleOutputDTO;

    public ImagenOutputDTO(Imagen imagen){
        this.id_imagen = imagen.getId_imagen();
        this.nombre_img = imagen.getNombre_img();
        this.inmuebleOutputDTO = new InmuebleOutputDTO(imagen.getInmueble());
    }
}
