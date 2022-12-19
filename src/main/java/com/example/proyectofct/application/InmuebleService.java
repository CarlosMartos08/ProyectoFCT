package com.example.proyectofct.application;

import com.example.proyectofct.application.dto.input.InmuebleInputDTO;
import com.example.proyectofct.application.dto.output.InmuebleOutputDTO;
import com.example.proyectofct.domain.entity.Inmueble;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface InmuebleService {
    public InmuebleOutputDTO insertarInmueble(InmuebleInputDTO inmuebleInputDTO);
    public InmuebleOutputDTO editarInmueble(Integer id, InmuebleInputDTO inmuebleInputDTO);
    public String eliminarInmueble(Integer id);
    public InmuebleOutputDTO buscarInmueblePorId(Integer id);
    public List<InmuebleOutputDTO> dameAllInmuebles() throws Exception;
//    public List<InmuebleOutputDTO> buscarPorHabs(Integer habs);
//    public List<InmuebleOutputDTO> buscarPorM2(Integer m2);
//    public List<InmuebleOutputDTO> buscarPorBanos(Integer banos);
//    public List<InmuebleOutputDTO> buscarPorLocalidad(String localidad);
//    public List<InmuebleOutputDTO> buscarPorProvincia(String provincia);
//    public List<InmuebleOutputDTO> buscarPorPais(String Pais);
    public List<InmuebleOutputDTO> buscarPorPersona(Integer id);
    public List<Inmueble> dameInmueblesPorCriterioPaginado(HashMap<String, Object> conditions, Integer offset, Integer limit);
}
