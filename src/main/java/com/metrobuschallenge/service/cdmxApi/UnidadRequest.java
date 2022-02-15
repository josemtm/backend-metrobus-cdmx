package com.metrobuschallenge.service.cdmxApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metrobuschallenge.entity.Punto;
import com.metrobuschallenge.entity.Unidad;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import lombok.Data;

@Data
public class UnidadRequest {

    private String id;
    @JsonProperty("geograpich_point")
    private String ubicacion;
    @JsonProperty("trip_id")
    private Integer tripId;

    Unidad convertirUnidad() throws ParseException {
        Unidad unidad = new Unidad();
        unidad.setId(id);
        if(tripId!=null){
            unidad.setDisponible(true);
        }
        Punto punto = new Punto();
        punto.setPoint((Point) new WKTReader().read(ubicacion));
        unidad.setUbicacion(punto);
        return unidad;
    }

}
