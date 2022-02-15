package com.metrobuschallenge.service.cdmxApi;

import lombok.Data;

import java.util.List;

@Data
public class apiRequest {
    private Boolean success;
    private Integer total;
    private List<UnidadRequest> records;
}
