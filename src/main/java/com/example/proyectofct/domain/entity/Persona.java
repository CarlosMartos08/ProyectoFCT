package com.example.proyectofct.domain.entity;

import com.example.proyectofct.application.dto.input.PersonaInputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_persona"})})
public class Persona implements Serializable {

    @Id
    @GeneratedValue
    Integer id_persona;

    @Column
    String usuario;

    @Column
    String password;

    @Column
    String name;

    @Column
    String surname;

    @Column
    String email;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean admin;


    public Persona(PersonaInputDTO personaDTO) {
        this.id_persona = personaDTO.getId_persona();
        this.usuario = personaDTO.getUsuario();
        this.password = personaDTO.getPassword();
        this.name = personaDTO.getName();
        this.surname = personaDTO.getSurname();
        this.email = personaDTO.getEmail();
        this.admin = personaDTO.isAdmin();
    }

}
