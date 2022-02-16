package com.metrobuschallenge.service;

import com.metrobuschallenge.cdmxApi.UnidadRequest;
import com.metrobuschallenge.dto.UnidadDto;
import com.metrobuschallenge.entity.*;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import com.metrobuschallenge.repository.AlcaldiaRepository;
import com.metrobuschallenge.repository.UnidadRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Clase de servicio para Unidad
 *
 * @author Jose Torrealba
 *
 */
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
    /**
     *  Metodo para conseguir las unidades por disponibilidad
     * @param disponible booleano para la busquedad
     * @return Lista de Dto de unidades
     * @since 1.0
     */
    @Override
    public List<UnidadDto> findAllByDisponible(Boolean disponible) {
        List<Unidad> unidades = this.repositorio.findAllByDisponible(disponible);
        return listMapper(unidades);
    }
    /**
     *  Metodo para buscar unidades por medio de nombre de alcaldia
     * @param alcaldia nombre de alcaldia
     * @return Lista de Dto de unidades
     * @since 1.0
     */
    @Override
    public List<UnidadDto> findAllByAlcaldiaActual(String alcaldia) {
        Alcaldia alcaldiaRequest =this.alcaldiaRepository.findByNombre(alcaldia);
        List<Unidad> unidades = this.repositorio.findAllByAlcaldiaActual(alcaldiaRequest);
        return listMapper(unidades);
    }
    /**
     *  Devuelve coordenadas de ubicacion por medio de la id de unidad
     * @param id de Unidad
     * @return Unidades en formato WKT o de api JST
     * @since 1.0
     */
    @Override
    public String coordenadasUnidad(String id) throws ObjectNotFoundException {
        Optional<Unidad> unidad = this.findOne(id);
        Point p = new GeometryFactory().createPoint(new Coordinate(unidad.get().getLatitud(), unidad.get().getLongitud()));
        return p.toText();
    }
    /**
     *  Mapper de Dto para la peticion de unidades
     * @param unidades lista de unidades a mapear
     * @return lista de Dto de unidades mapeada
     * @since 1.0
     */
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
    /**
     *  Metodo para crear conjunto de unidades proveniente de api
     * @param unidadesRequest unidades primitivas
     * @param alcaldias lista de alcaldias a mapear
     * @return lista de unidades procesadas
     * @since 1.0
     */
    @Override
    public List<Unidad> determinarEstadoUnidades(List<UnidadRequest> unidadesRequest, List<Alcaldia> alcaldias) throws ParseException {
        List<Unidad> unidades = new ArrayList<>();
        for (UnidadRequest request:unidadesRequest) {
            Unidad unidad = request.convertirUnidad();
            unidad.determinarAlcaldia(alcaldias);
            unidades.add(unidad);
        }
        return unidades;
    }

}
