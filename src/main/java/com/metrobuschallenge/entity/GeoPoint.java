package com.metrobuschallenge.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Data
@Entity
public class GeoPoint {
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2",strategy = "uuid2")
    private String id;
    @NotNull(message = "Latitud es necesario")
    private Double latitud;
    @NotNull(message = "Longitud es necesario")
    private Double longitud;

}
