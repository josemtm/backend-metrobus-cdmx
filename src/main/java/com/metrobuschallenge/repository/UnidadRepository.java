package com.metrobuschallenge.repository;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadRepository extends JpaRepository<Unidad, String> {
    List<Unidad> findAllByDisponible(Boolean disponible);
    List<Unidad> findAllByAlcaldia(Alcaldia alcaldia);
}
