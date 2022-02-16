package com.metrobuschallenge.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * Clase DTO para unidad
 *
 * @author Jose Torrealba
 *
 */
@Data
public class UnidadDto implements Serializable {

    private static final long serialVersionUID = 62691120156156283L;

    private String id;
    private Boolean disponible;
}
