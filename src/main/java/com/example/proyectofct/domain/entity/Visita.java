package com.example.proyectofct.domain.entity;

import com.example.proyectofct.application.dto.input.VisitaInputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visita", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_visita"})})
public class Visita {

    @Id
    @GeneratedValue
    Integer id_visita;

    @Column
    LocalDateTime fecha_visita;

    public Visita(VisitaInputDTO visitaInputDTO){
        this.id_visita = visitaInputDTO.getId_visita();
        this.fecha_visita = visitaInputDTO.getFecha_visita();
    }

}
