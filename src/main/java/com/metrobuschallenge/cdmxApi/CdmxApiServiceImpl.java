package com.metrobuschallenge.cdmxApi;

import com.metrobuschallenge.configuration.CdmxApiConfiguration;
import com.metrobuschallenge.exception.ThirdPartyRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
/**
 * Clases de implementacion para la api de cdmx
 *
 * @author Jose Torrealba
 *
 */
@Service
public class CdmxApiServiceImpl implements CdmxApiService{
    private final CdmxApiConfiguration conf;
    private final RestTemplate restTemplate;

    @Autowired
    public CdmxApiServiceImpl(RestTemplateBuilder restTemplateBuilder, CdmxApiConfiguration conf) {
        this.restTemplate = restTemplateBuilder.build();
        this.conf = conf;
    }
    /**
     *  Metodo para realiza la peticion api por medio de los parametros de configuracion
     * @return respuesta mapeada de la api
     * @since 1.0
     */
    public apiRequest getUnidadesApi() throws ThirdPartyRequestException {

        try{
            ResponseEntity<apiRequest> responseEntity = restTemplate.getForEntity(conf.getUrl()+conf.getLimite(), apiRequest.class);
            apiRequest result = responseEntity.getBody();
            return result;
        }catch (HttpStatusCodeException ex){
            throw new ThirdPartyRequestException(ex.getResponseBodyAsString());
        }

    }


}
