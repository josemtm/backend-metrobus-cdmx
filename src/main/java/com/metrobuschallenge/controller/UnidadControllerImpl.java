package com.metrobuschallenge.controller;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.Unidad;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlador principal para los servicios de unidades
 *
 * @author Jose Torrealba
 *
 */
@RestController
@RequestMapping(value = {"/codechallenge/api/v1/unidades"}, produces = {"application/json"})
public class UnidadControllerImpl implements UnidadController{
    @Override
    @Operation(
            summary = "Busca lista de unidades",
            description = "Busca lista de unidades por disponibilidad",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Respuesta a la request de unidades disponibles",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Unidad.class))
                            )
                    })
            }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = {"/disponibles"} ,method = {RequestMethod.GET}, produces = {"application/json"})
    public List<Unidad> getUnidadesDisponibles() {
        return null;
    }

    @Override
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Unidad.class)) }),
            @ApiResponse(responseCode = "404", description = "Object not found",
                    content = @Content) })
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = {"/ubicacionporid/{id}"} ,method = {RequestMethod.GET}, produces = {"application/json"})
    public String ubicacionPorId(@PathVariable String id) {
        return null;
    }

    @Override
    @Operation(
            summary = "Busca lista de unidades",
            description = "Busca lista de unidades por alcaldia",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Respuesta a la request de unidades por alcaldia",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Unidad.class))
                            )
                    })
            }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = {RequestMethod.GET}, value = {"poralcaldia/{id}"}, produces = {"application/json"})
    public List<Unidad> getUnidadesPorAlcaldia(String alcalda) {
        return null;
    }
}
