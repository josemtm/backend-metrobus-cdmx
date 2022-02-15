package com.metrobuschallenge.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EstadoUnidadesServiceImpl implements EstadoUnidadesService{

    @Override
    @Scheduled(fixedDelay = 1000)
    @Transactional
    public void determinarEstadoUnidades() {

    }
}
