package com.metrobuschallenge.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "cdmxapi")
@Data
public class CdmxApiConfiguration {
    /**
     * api request limite
     */

    private String limite;
    /**
     * Url api
     */
    private String url;

}