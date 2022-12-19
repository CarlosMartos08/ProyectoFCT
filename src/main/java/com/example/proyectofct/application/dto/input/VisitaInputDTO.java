package com.example.proyectofct.application.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitaInputDTO {

    Integer id_visita;

    LocalDateTime fecha_visita;

}
