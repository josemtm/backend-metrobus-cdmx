package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ThirdPartyRequestException;
import com.metrobuschallenge.service.cdmxApi.CdmxApiServiceImpl;
import com.metrobuschallenge.service.cdmxApi.UnidadRequest;
import com.vividsolutions.jts.io.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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


    @Override
    @Scheduled(fixedDelay = 300000)
    @Transactional
    public void determinarEstado() throws ThirdPartyRequestException, ParseException {
        System.out.println("Peticion");
        this.unidadService.deleteAll();
        List<UnidadRequest> unidadesRequest = this.cdmxApiService.getUnidadesApi().getResult().getRecords();
        List<Alcaldia> alcaldias = alcaldiaService.findAll();
        List<Unidad> unidades = determinarEstadoUnidades(unidadesRequest, alcaldias);
        determinarEstadoAlcaldias(alcaldias, unidades);
        this.alcaldiaService.saveAll(alcaldias);
        this.unidadService.saveAll(unidades);
    }

    public List<Unidad> determinarEstadoUnidades(List<UnidadRequest> unidadesRequest,List<Alcaldia> alcaldias) throws ParseException {
        List<Unidad> unidades = new ArrayList<>();
        for (UnidadRequest request:unidadesRequest) {
            Unidad unidad = request.convertirUnidad();
            unidad.determinarAlcaldia(alcaldias);
            unidades.add(unidad);
        }
        return unidades;
    }

    public void determinarEstadoAlcaldias(List<Alcaldia> alcaldias, List<Unidad> unidades){
        for (Alcaldia alcaldia : alcaldias){
            boolean esDisponible = unidades.stream()
                    .anyMatch(p -> p.getAlcaldiaActual().getClass().equals(alcaldia.getClass()));
            if (esDisponible) alcaldia.setDisponible(true);
            else alcaldia.setDisponible(false);
        }

    }
}
