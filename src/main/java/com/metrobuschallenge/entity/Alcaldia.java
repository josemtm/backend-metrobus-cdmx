package com.metrobuschallenge.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Alcaldia {
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2",strategy = "uuid2")
    private String id;
    @Size(min=2, max=50)
    @NotNull(message = "Nombre es necesario")
    private String nombre;
    @NotNull(message = "Limites poligonales es necesario")
    @OneToMany
    private List<GeoPoint> limitePoligonal;
    @NotNull(message = "Estado de alcaldia es necesario")
    private Boolean disponible;
}
