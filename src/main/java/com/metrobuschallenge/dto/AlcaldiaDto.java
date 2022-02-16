package com.metrobuschallenge.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Clase DTO para alcaldia
 *
 * @author Jose Torrealba
 *
 */
@Data
public class AlcaldiaDto implements Serializable {

    private static final long serialVersionUID = 6269114566416283L;

    private String id;
    private String nombre;
    private Boolean disponible;

}
