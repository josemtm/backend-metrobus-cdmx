package com.metrobuschallenge.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class AlcaldiaDto implements Serializable {

    private static final long serialVersionUID = 6269114566416283L;

    private String id;
    private String nombre;
    private Boolean disponible;

}
