package com.citasalud.backend.service;

import com.citasalud.backend.dto.DisponibilidadDTO;

import java.util.List;

public interface DisponibilidadService {

    void agregarFranja(DisponibilidadDTO dto, Long medicoId);
    List<DisponibilidadDTO> listarFranjas();
    void eliminarFranja(Long franjaId);
    DisponibilidadDTO actualizarFranja(Long franjaId, DisponibilidadDTO dto);
}

