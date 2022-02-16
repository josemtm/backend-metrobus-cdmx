package com.metrobuschallenge.cdmxApi;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 * Clases de mapeo
 *
 * @author Jose Torrealba
 *
 */
@Data
public class ResultRequest implements Serializable {

    private static final long serialVersionUID = 6261217485667756283L;

    private Integer total;
    private List<UnidadRequest> records;
}
