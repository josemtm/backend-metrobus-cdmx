package com.metrobuschallenge.entity;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Unidad implements Serializable {

    private static final long serialVersionUID = 6269114156156283L;

    @Id
    private String id;
    /**
     * Alcaldia en la que esta ubicada una unidad
     */
    @ManyToOne
    private Alcaldia alcaldiaActual;
    /**
     * Parte del punto espacial geografco
     */
    @NotNull(message = "latitud es necesaria")
    private Double latitud;
    /**
     * Parte del punto espacial geografco
     */
    @NotNull(message = "longitud es necesaria")
    private Double longitud;
    /**
     * Disponibilidad inferida de si posee un trip id en la peticion
     */
    @NotNull(message = "Disponibilidad es necesaria")
    private Boolean disponible;
    /**
     *  Metodo usado para determinar alcaldia en la que se encuentra una unidad, se determina por medio una operacion geometrica
     *  que verifica si un punto de coordenadas se encuentra dentro de los limites poligonales de alcaldia
     * @param alcaldias lista de tipo Alcaldia
     * @since 1.0
     */
    public void determinarAlcaldia(List<Alcaldia> alcaldias) throws ParseException {
        for (Alcaldia alcaldia:alcaldias
             ) {
            Polygon p = (Polygon) new WKTReader().read(alcaldia.getPolygon());
            Point p2 = new GeometryFactory().createPoint(new Coordinate(longitud,latitud));
            if(p.contains(p2)){
               this.alcaldiaActual=alcaldia;
               break;
           }
        }

    }
}
