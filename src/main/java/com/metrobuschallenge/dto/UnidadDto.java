package com.metrobuschallenge.dto;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Clase DTO para unidad
 *
 * @author Jose Torrealba
 *
 */
@Data
public class UnidadDto implements Serializable {

    private static final long serialVersionUID = 62691120156156283L;

    private String id;
    private Boolean disponible;
}
