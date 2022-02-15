package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import com.metrobuschallenge.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadServiceImpl implements UnidadService{
    private final UnidadRepository repositorio;

    @Autowired
    public UnidadServiceImpl(UnidadRepository repositorio) {
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


}
