package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import com.metrobuschallenge.repository.AlcaldiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return this.repositorio.findAll(/* sortByIdAsc()*/);
    }

    @Override
    public List<Alcaldia> findAllByDisponible(Boolean disponible) {
        return this.repositorio.findAllByDisponible(disponible);
    }


}
