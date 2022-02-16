package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.AlcaldiaDto;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import com.metrobuschallenge.repository.AlcaldiaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlcaldiaServiceImpl implements AlcaldiaService{
    private final AlcaldiaRepository repositorio;

    @Autowired
    public AlcaldiaServiceImpl(AlcaldiaRepository repositorio) {
        this.repositorio = repositorio;

    }

    @Override
    public Alcaldia save(Alcaldia object) throws Exception {
        return this.repositorio.save(object);
    }

    @Override
    public Alcaldia update(Alcaldia object, String id) throws ObjectNotFoundException {
        Optional<Alcaldia> result = findOne(id);

        if (result.isPresent()) {
            object.setId(id);
            return repositorio.save(object);
        }
        throw new ObjectNotFoundException("Objeto no encontrado");
    }

    @Override
    public Optional<Alcaldia> findOne(String id) throws ObjectNotFoundException {
        Optional<Alcaldia>result = repositorio.findById(id);
        if (result.isPresent()) {
            return result;
        }
        throw new ObjectNotFoundException("Objeto no encontrado");
    }

    @Override
    public List<Alcaldia> findAll() {
        return this.repositorio.findAll();
    }

    @Override
    public List<AlcaldiaDto> findAllByDisponible(Boolean disponible) {
        List<Alcaldia> alcaldias = this.repositorio.findAllByDisponible(disponible);
        List<AlcaldiaDto> alcaldiasDto = listMapper(alcaldias);
        return alcaldiasDto;

    }

    @Override
    public List<Alcaldia> saveAll(List<Alcaldia> alcaldias) {
        return repositorio.saveAll(alcaldias);
    }

    @Override
    public List<AlcaldiaDto> listMapper(List<Alcaldia> alcaldias){
        ModelMapper modelMapper = new ModelMapper();
        List<AlcaldiaDto> alcaldiasDto = new ArrayList<>();
        for (Alcaldia alcaldia:alcaldias
        ) {
            alcaldiasDto.add(modelMapper.map(alcaldia, AlcaldiaDto.class));
        }
        return alcaldiasDto;
    }



}
