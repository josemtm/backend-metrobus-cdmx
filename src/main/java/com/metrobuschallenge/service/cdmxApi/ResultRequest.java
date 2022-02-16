package com.metrobuschallenge.service.cdmxApi;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultRequest implements Serializable {

    private static final long serialVersionUID = 6261217485667756283L;

    private Integer total;
    private List<UnidadRequest> records;
}
