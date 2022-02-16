package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.dto.AlcaldiaDto;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import com.metrobuschallenge.repository.AlcaldiaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Clases de servicio para alcaldia
 *
 * @author Jose Torrealba
 *
 */
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
    /**
     *  Busca lista de alcaldias disponibles
     * @param disponible booleano para la busqueda
     * @return respuesta mapeada a dto de unidades disponibles
     * @since 1.0
     */
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
    /**
     *  Mapper de Dto para la peticion de alcaldias
     * @param alcaldias lista de alcaldias a mapear
     * @return lista de Dto de alcaldias mapeada
     * @since 1.0
     */
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
    /**
     *  Metodo para determinar el estado de disponibilidad de una lista de alcaldias
     * @param alcaldias lista de alcaldias a mapear
     * @param unidades ya procesadas para ser usadas en alcaldias
     * @since 1.0
     */
    @Override
    public void determinarEstadoAlcaldias(List<Alcaldia> alcaldias, List<Unidad> unidades){
        for (Alcaldia alcaldia : alcaldias){
            boolean esDisponible = unidades.stream()
                    .anyMatch(p -> p.getAlcaldiaActual().getClass().equals(alcaldia.getClass()));
            if (esDisponible) alcaldia.setDisponible(true);
            else alcaldia.setDisponible(false);
        }

    }

}
