package com.example.proyectofct.application.dto.output;

import com.example.proyectofct.domain.entity.Persona;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDTO {

    private Integer id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String email;
    private boolean admin;


    public PersonaOutputDTO(Persona persona){
        setId_persona(persona.getId_persona());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setEmail(persona.getEmail());
        setAdmin(persona.isAdmin());
    }

}
