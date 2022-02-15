package com.metrobuschallenge.service.cdmxApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UnidadRequest {

    private String id;
    @JsonProperty("geograpich_point")
    private String ubicacion;
    @JsonProperty("trip_id")
    private Integer tripId;

}
