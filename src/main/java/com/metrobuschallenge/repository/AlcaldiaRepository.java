package com.metrobuschallenge.repository;

import com.metrobuschallenge.entity.Alcaldia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlcaldiaRepository extends JpaRepository<Alcaldia, String> {
    List<Alcaldia> findAllByDisponible(Boolean disponible);
}
