package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ThirdPartyRequestException;
import com.metrobuschallenge.cdmxApi.CdmxApiServiceImpl;
import com.metrobuschallenge.cdmxApi.UnidadRequest;
import com.vividsolutions.jts.io.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Clase del servicio de estado de las unidades
 *
 * @author Jose Torrealba
 *
 */
@Service
public class EstadoServiceImpl implements EstadoService {
    private final AlcaldiaServiceImpl alcaldiaService;
    private final UnidadServiceImpl unidadService;
    private final CdmxApiServiceImpl cdmxApiService;

    public EstadoServiceImpl(AlcaldiaServiceImpl alcaldiaService, UnidadServiceImpl unidadService, CdmxApiServiceImpl cdmxApiService) {
        this.alcaldiaService = alcaldiaService;
        this.unidadService = unidadService;
        this.cdmxApiService = cdmxApiService;
    }

    /**
     *  Metodo con chrono para determinar estado de las unidades y alcaldias por medio de la api de cdmx y servicios de entidad
     * @since 1.0
     */
    @Override
    @Scheduled(fixedDelay = 300000)
    @Transactional
    public void determinarEstado() throws ThirdPartyRequestException, ParseException {
        System.out.println("Peticion");
        this.unidadService.deleteAll();
        List<UnidadRequest> unidadesRequest = this.cdmxApiService.getUnidadesApi().getResult().getRecords();
        List<Alcaldia> alcaldias = alcaldiaService.findAll();
        List<Unidad> unidades = this.unidadService.determinarEstadoUnidades(unidadesRequest, alcaldias);
        this.alcaldiaService.determinarEstadoAlcaldias(alcaldias, unidades);
        this.alcaldiaService.saveAll(alcaldias);
        this.unidadService.saveAll(unidades);
    }




}
