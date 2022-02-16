package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.*;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import com.metrobuschallenge.repository.AlcaldiaRepository;
import com.metrobuschallenge.repository.UnidadRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadServiceImpl implements UnidadService{
    private final AlcaldiaRepository alcaldiaRepository;
    private final UnidadRepository repositorio;

    @Autowired
    public UnidadServiceImpl(AlcaldiaRepository alcaldiaRepository, UnidadRepository repositorio) {
        this.alcaldiaRepository = alcaldiaRepository;
        this.repositorio = repositorio;

    }

    @Override
    public Unidad save(Unidad object) throws Exception {
        return this.repositorio.save(object);
    }


    @Override
    public Optional<Unidad> findOne(String id) throws ObjectNotFoundException {
        Optional<Unidad>result = repositorio.findById(id);
        if (result.isPresent()) {
            return result;
        }
        throw new ObjectNotFoundException("Objeto no encontrado");
    }

    @Override
    public List<Unidad> findAll() {
        return this.repositorio.findAll();
    }


    @Override
    public void deleteAll() {
        this.repositorio.deleteAll();
    }

    @Override
    public List<Unidad> saveAll(List<Unidad> unidades) {
        return repositorio.saveAll(unidades);
    }

    @Override
    public List<UnidadDto> findAllByDisponible(Boolean disponible) {
        List<Unidad> unidades = this.repositorio.findAllByDisponible(disponible);
        return listMapper(unidades);
    }

    @Override
    public List<UnidadDto> findAllByAlcaldiaActual(String alcaldia) {
        Alcaldia alcaldiaRequest =this.alcaldiaRepository.findByNombre(alcaldia);
        List<Unidad> unidades = this.repositorio.findAllByAlcaldiaActual(alcaldiaRequest);
        return listMapper(unidades);
    }

    @Override
    public String coordenadasUnidad(String id) throws ObjectNotFoundException {
        Optional<Unidad> unidad = this.findOne(id);
        Point p = new GeometryFactory().createPoint(new Coordinate(unidad.get().getLatitud(), unidad.get().getLongitud()));
        return p.toText();
    }

    @Override
    public List<UnidadDto> listMapper(List<Unidad> unidades){
        ModelMapper modelMapper = new ModelMapper();
        List<UnidadDto> unidadesDto = new ArrayList<>();
        for (Unidad unidad:unidades
        ) {
            unidadesDto.add(modelMapper.map(unidad, UnidadDto.class));
        }
        return unidadesDto;
    }

}
