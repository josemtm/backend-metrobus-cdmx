package com.metrobuschallenge.cdmxApi;

import com.metrobuschallenge.exception.ThirdPartyRequestException;
/**
 * Interface para la clase de implementacion de la api de cdmx
 *
 * @author Jose Torrealba
 *
 */
public interface CdmxApiService {
    apiRequest getUnidadesApi() throws ThirdPartyRequestException;

}
