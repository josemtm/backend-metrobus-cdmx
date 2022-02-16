package com.metrobuschallenge.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Clases de configuracion para la api de cdmx
 *
 * @author Jose Torrealba
 *
 */
@ConfigurationProperties(prefix = "cdmxapi")
@Configuration("cdmxapi-conf")
@Data
public class CdmxApiConfiguration {
    /**
     * api request limite de unidades en peticion
     */

    private String limite;
    /**
     * Url api
     */
    private String url;

}