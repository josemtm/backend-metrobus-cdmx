package com.metrobuschallenge.service.cdmxApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metrobuschallenge.entity.Unidad;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import lombok.Data;

import java.io.Serializable;

@Data
public class UnidadRequest implements Serializable {
    private static final long serialVersionUID = 6269117485667756413L;

    private String id;
    @JsonProperty("position_latitude")
    private Double latitud;
    @JsonProperty("position_longitude")
    private Double longitud;
    @JsonProperty("trip_id")
    private Integer tripId;

    public Unidad convertirUnidad() {
        Unidad unidad = new Unidad();
        unidad.setId(id);
        if(tripId!=null){
            unidad.setDisponible(true);
        }else{
            unidad.setDisponible(false);
        }
        unidad.setLatitud(latitud);
        unidad.setLongitud(longitud);
        return unidad;
    }

}
