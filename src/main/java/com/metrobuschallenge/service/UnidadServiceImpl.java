package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.Coordenadas;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import com.metrobuschallenge.repository.AlcaldiaRepository;
import com.metrobuschallenge.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Unidad> findAllByDisponible(Boolean disponible) {
        return this.repositorio.findAllByDisponible(disponible);
    }

    @Override
    public List<Unidad> findAllByAlcaldiaActual(String alcaldia) {
        Alcaldia alcaldiaRequest =this.alcaldiaRepository.findByNombre(alcaldia);
        return this.repositorio.findAllByAlcaldiaActual(alcaldiaRequest);
    }

    @Override
    public Coordenadas coordenadasUnidad(String id) throws ObjectNotFoundException {
        Optional<Unidad> unidad = this.findOne(id);
        return new Coordenadas(unidad.get().getLatitud(), unidad.get().getLongitud());
    }


}
