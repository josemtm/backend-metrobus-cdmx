package com.metrobuschallenge.entity;

import com.vividsolutions.jts.geom.Polygon;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Alcaldia implements Serializable {

    private static final long serialVersionUID = 62691141566416283L;

    @Id
    private String id;
    @NotNull(message = "Nombre es necesario")
    private String nombre;
    @NotNull(message = "Polygon es necesario")
    @Lob
    private String polygon;
    @NotNull(message = "Estado de alcaldia es necesario")
    private Boolean disponible;


}
