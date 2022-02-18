package com.metrobuschallenge.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UbicacionDto  implements Serializable {

    private static final long serialVersionUID = 62121120156156283L;

    private String coordenadas;
    private String alcaldia;
}
