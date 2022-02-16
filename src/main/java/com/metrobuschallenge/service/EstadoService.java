package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ThirdPartyRequestException;
import com.metrobuschallenge.service.cdmxApi.UnidadRequest;
import com.vividsolutions.jts.io.ParseException;

import java.util.List;

public interface EstadoService {
    void determinarEstado() throws ThirdPartyRequestException, ParseException;
    List<Unidad> determinarEstadoUnidades(List<UnidadRequest> unidadesRequest, List<Alcaldia> alcaldias) throws ParseException;
    void determinarEstadoAlcaldias(List<Alcaldia> alcaldias, List<Unidad> unidades);
}
