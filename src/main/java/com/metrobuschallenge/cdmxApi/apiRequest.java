package com.metrobuschallenge.cdmxApi;

import lombok.Data;

import java.io.Serializable;
/**
 * Clases de mapeo
 *
 * @author Jose Torrealba
 *
 */
@Data
public class apiRequest implements Serializable {

    private static final long serialVersionUID = 626911415667756283L;

    private Boolean success;
    private ResultRequest result;
}
