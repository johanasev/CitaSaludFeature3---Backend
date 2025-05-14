package com.citasalud.backend.service;

import com.citasalud.backend.dto.MedicoDTO;

import java.util.List;

public interface MedicoService {
    List<MedicoDTO> obtenerTodos();
}
