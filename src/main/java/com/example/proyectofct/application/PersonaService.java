package com.example.proyectofct.application;

import com.example.proyectofct.application.dto.input.PersonaInputDTO;
import com.example.proyectofct.application.dto.output.PersonaOutputDTO;
import com.example.proyectofct.domain.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface PersonaService {
    public PersonaOutputDTO insertarPersona(PersonaInputDTO personaDTO);
    public PersonaOutputDTO editarPersona(Integer id, PersonaInputDTO personaInputDTO);
    public void eliminarPersona(Integer id);
    public PersonaOutputDTO buscarPersonaPorId(Integer id);
    public List<PersonaOutputDTO> buscarPersonaPorName(String name);
    public List<Persona> dameAllPersonas() throws Exception;
    public List<Persona> damePersonasPorCriterioPaginado(HashMap<String, Object> conditions, Integer offset, Integer limit);


}
