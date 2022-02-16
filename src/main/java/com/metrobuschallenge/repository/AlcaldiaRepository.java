package com.metrobuschallenge.repository;

import com.metrobuschallenge.entity.Alcaldia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Interface del repositorio de Alcaldia
 *
 * @author Jose Torrealba
 *
 */
public interface AlcaldiaRepository extends JpaRepository<Alcaldia, String> {
    List<Alcaldia> findAllByDisponible(Boolean disponible);
    Alcaldia findByNombre(String nombre);

}
