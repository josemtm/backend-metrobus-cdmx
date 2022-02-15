package com.metrobuschallenge.entity;

import com.vividsolutions.jts.geom.Point;
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
    private Punto ubicacion;
    @NotNull(message = "Disponibilidad es necesaria")
    private Boolean disponible;

    void determinarAlcaldia(Alcaldia alcaldia){
        if(alcaldia.getLimite().getPolygon().contains(ubicacion.getPoint())){
            this.alcaldiaActual=alcaldia;
        }
    }
}
