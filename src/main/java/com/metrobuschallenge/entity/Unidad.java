package com.metrobuschallenge.entity;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Unidad implements Serializable {

    private static final long serialVersionUID = 6269114156156283L;

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2",strategy = "uuid2")
    private String id;
    @ManyToOne
    private Alcaldia alcaldiaActual;
    @NotNull(message = "latitud es necesaria")
    private Double latitud;
    @NotNull(message = "longitud es necesaria")
    private Double longitud;
    @NotNull(message = "Disponibilidad es necesaria")
    private Boolean disponible;

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
