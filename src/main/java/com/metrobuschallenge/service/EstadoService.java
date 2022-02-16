package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ThirdPartyRequestException;
import com.metrobuschallenge.cdmxApi.UnidadRequest;
import com.vividsolutions.jts.io.ParseException;

import java.util.List;
/**
 * Interface de servicio de estado
 *
 * @author Jose Torrealba
 *
 */
public interface EstadoService {
    void determinarEstado() throws ThirdPartyRequestException, ParseException;
}
