package com.example.proyectofct.application;

import com.example.proyectofct.application.dto.input.InmuebleInputDTO;
import com.example.proyectofct.application.dto.output.InmuebleOutputDTO;
import com.example.proyectofct.domain.entity.Inmueble;
import com.example.proyectofct.infrastructure.repository.InmuebleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Service
public class InmuebleServiceImpl implements InmuebleService{

    @Autowired
    InmuebleRepositorio inmuebleRepo;

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public InmuebleOutputDTO insertarInmueble(InmuebleInputDTO inmuebleInputDTO) {

        Inmueble inmueble = new Inmueble(inmuebleInputDTO);
        inmuebleRepo.save(inmueble);
        InmuebleOutputDTO saveOutputDTO = new InmuebleOutputDTO(inmueble);
        return saveOutputDTO;
    }

    @Override
    public InmuebleOutputDTO editarInmueble(Integer id, InmuebleInputDTO inmuebleInputDTO) {
        Optional<Inmueble> inmuebleOptional = inmuebleRepo.findById(id);
        if (inmuebleOptional.isEmpty()){
            throw new EntityNotFoundException();
        }

        Inmueble inmueble = inmuebleOptional.get();

        inmueble.setDescripcion(inmuebleInputDTO.getDescripcion());
        inmueble.setHabs(inmuebleInputDTO.getHabs());
        inmueble.setBanos(inmuebleInputDTO.getBanos());
        inmueble.setM2(inmuebleInputDTO.getM2());
        inmueble.setPrecio(inmuebleInputDTO.getPrecio());
        inmueble.setDireccion(inmuebleInputDTO.getDireccion());
        inmueble.setDireccion(inmuebleInputDTO.getDireccion());
        inmueble.setLocalidad(inmuebleInputDTO.getLocalidad());
        inmueble.setProvincia(inmuebleInputDTO.getProvincia());

        inmuebleRepo.save(inmueble);

        return new InmuebleOutputDTO(inmueble);
    }

    @Override
    public String eliminarInmueble(Integer id) {
        try {

            inmuebleRepo.deleteById(id);
            return "Borrado exitosamente";

        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public InmuebleOutputDTO buscarInmueblePorId(Integer id) {
        Inmueble inmueble = inmuebleRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return  new InmuebleOutputDTO(inmueble);
    }

    @Override
    public List<InmuebleOutputDTO> dameAllInmuebles() throws Exception {
        List<InmuebleOutputDTO> listaInmueblesDTO = new ArrayList<>();

        try {

            List<Inmueble> listaInmuebles = new ArrayList<Inmueble>(inmuebleRepo.findAll());

            for (int i = 0; i<listaInmuebles.size(); i++){

                InmuebleOutputDTO inmuebleOutpuDTO = new InmuebleOutputDTO(listaInmuebles.get(i));

                listaInmueblesDTO.add(inmuebleOutpuDTO);

            }

            return listaInmueblesDTO;

        } catch (Exception e) {
            throw new Exception("No hay registros");
        }
    }

    @Override
    public List<InmuebleOutputDTO> buscarPorPersona(Integer id) {
        return null;
    }

//    @Override
//    public List<InmuebleOutputDTO> buscarPorPersona(Integer id) {
//
//            return inmuebleRepo.findAllByPersona(id);
//
//    }

    @Override
    public List<Inmueble> dameInmueblesPorCriterioPaginado(HashMap<String, Object> conditions, Integer offset, Integer limit) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Inmueble> query = cb.createQuery(Inmueble.class);
        Root<Inmueble> root = query.from(Inmueble.class);

        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((field, value) ->
        {
            switch (field) {
                case "habs":
                    System.out.println(value);
                    predicates.add(cb.like(root.get(field), "%" + (String) value + "%"));
                case "banos":
                    System.out.println(value);
                    predicates.add(cb.equal(root.get(field), (String) value));
                case "m2":
                    predicates.add(cb.like(root.get(field), "%" + (String) value + "%"));
            }
        });

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).setMaxResults(limit = 2).setFirstResult(offset = 0).getResultList();

    }
}
