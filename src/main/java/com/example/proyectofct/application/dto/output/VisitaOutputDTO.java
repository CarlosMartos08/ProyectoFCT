package com.example.proyectofct.application.dto.output;

import com.example.proyectofct.domain.entity.Visita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitaOutputDTO {

    Integer id_visita;

    LocalDateTime fecha_visita;

    public VisitaOutputDTO(Visita visita){
        this.id_visita = visita.getId_visita();
        this.fecha_visita = visita.getFecha_visita();
    }
}
