package com.example.proyectofct.application.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDTO implements Serializable {

    private Integer id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String email;
    private boolean admin;
}
