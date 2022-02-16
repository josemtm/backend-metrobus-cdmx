package com.metrobuschallenge.service;

import com.metrobuschallenge.exception.ThirdPartyRequestException;
import com.vividsolutions.jts.io.ParseException;

/**
 * Interface de servicio de estado
 *
 * @author Jose Torrealba
 *
 */
public interface EstadoService {
    void determinarEstado() throws ThirdPartyRequestException, ParseException;
}
