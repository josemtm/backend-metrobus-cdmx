package com.metrobuschallenge.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Unidad {
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2",strategy = "uuid2")
    private String id;
    @NotNull(message = "Alcaldia es necesario")
    @ManyToOne
    private Alcaldia alcaldiaActual;
    @NotNull(message = "Ubicacion es necesario")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private GeoPoint ubicacion;
    @NotNull(message = "Disponibilidad es necesaria")
    private Boolean disponible;
}
