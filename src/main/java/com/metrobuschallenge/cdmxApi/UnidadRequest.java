package com.metrobuschallenge.cdmxApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metrobuschallenge.entity.Unidad;
import lombok.Data;

import java.io.Serializable;
/**
 * Clases de mapeo de proposito principal para la api de cdmx
 *
 * @author Jose Torrealba
 *
 */
@Data
public class UnidadRequest implements Serializable {
    private static final long serialVersionUID = 6269117485667756413L;

    private String id;
    @JsonProperty("position_latitude")
    private Double latitud;
    /**
     * Parte del vector de posicion
     */
    @JsonProperty("position_longitude")
    /**
     * Parte del vector de posicion
     */
    private Double longitud;
    /**
     * Id de trip para determinar si la unidad esta activa
     */
    @JsonProperty("trip_id")
    private Integer tripId;
    /**
     *  Metodo para convertir la clases de mapeo a la entidad Unidad
     * @return Unidad convertida a entidad
     * @since 1.0
     */
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
