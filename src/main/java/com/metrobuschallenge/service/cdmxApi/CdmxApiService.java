package com.metrobuschallenge.service.cdmxApi;

import com.metrobuschallenge.exception.ThirdPartyRequestException;

public interface CdmxApiService {
    apiRequest getUnidadesApi() throws ThirdPartyRequestException;

}
