package com.example.proyectofct.infrastructure.controller;

import com.example.proyectofct.application.InmuebleService;
import com.example.proyectofct.application.dto.input.InmuebleInputDTO;
import com.example.proyectofct.application.dto.output.InmuebleOutputDTO;
import com.example.proyectofct.domain.entity.Inmueble;
import com.example.proyectofct.domain.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/inmuebles")
public class InmuebleControlador {

    @Autowired
    InmuebleService inmuebleService;

    @GetMapping("/{id}")
    public InmuebleOutputDTO dameInmueble(@PathVariable Integer id) {
        return inmuebleService.buscarInmueblePorId(id);
    }

    @PostMapping("/insertar/")
    public InmuebleOutputDTO insertarInmueble(@RequestBody InmuebleInputDTO inmuebleInputDTO){
        return inmuebleService.insertarInmueble(inmuebleInputDTO);
    }

    @PutMapping("/editar/")
    public InmuebleOutputDTO editarInmueble(@RequestParam Integer id, @RequestBody InmuebleInputDTO inmueble){
        return inmuebleService.editarInmueble(id,inmueble);
    }

    @DeleteMapping("/eliminar/")
    public String eliminarInmueble(@RequestParam Integer id){
        return inmuebleService.eliminarInmueble(id);
    }

    @GetMapping("/")
    public Iterable<InmuebleOutputDTO> dameInmuebles() throws Exception{
        return inmuebleService.dameAllInmuebles();
    }

//    @GetMapping("")
//    public List<InmuebleOutputDTO> dameInmueblePorPersona(@RequestParam Integer id){
//        return inmuebleService.buscarPorPersona(id);
//    }
//
//    @GetMapping("/listadoCriteria/")
//    public List<Inmueble> getInmueblesPorCriterio(@RequestParam(required = false) Integer habs, @RequestParam(required = false) Integer banos,
//                                                  @RequestParam(required = false) Integer m2, @RequestParam(required = false) String localidad,
//                                                  @RequestParam(required = false) String provincia, @RequestParam(required = false) String pais,
//                                                  @RequestParam(required = false) String orderCondition,
//                                                  @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit){
//
//        HashMap<String, Object> conditions = new HashMap<>();
//        if(habs!=null) {
//            conditions.put("habs", habs);
//        }
//        if(banos!=null) {
//            conditions.put("banos", banos);
//        }
//        if(m2!=null) {
//            conditions.put("m2", m2);
//        }
//        if(localidad!=null) {
//            conditions.put("localidad", localidad);
//        }
//        if(provincia!=null) {
//            conditions.put("provincia", provincia);
//        }
//        if(pais!=null) {
//            conditions.put("pais", pais);
//        }
//        if(orderCondition!=null) {
//            conditions.put("orderCondition", orderCondition);
//        }
//
//        return inmuebleService.dameInmueblesPorCriterioPaginado(conditions, offset, limit);
//    }
}

