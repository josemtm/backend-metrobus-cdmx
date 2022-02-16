package com.metrobuschallenge.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Coordenadas implements Serializable {

    private static final long serialVersionUID = 6269114112156283L;

    @NotNull(message = "latitud es necesaria")
    private Double latitud;
    @NotNull(message = "longitud es necesaria")
    private Double longitud;

    public Coordenadas(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
