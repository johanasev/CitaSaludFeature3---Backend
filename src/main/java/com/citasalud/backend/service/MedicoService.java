package com.citasalud.backend.service;

import com.citasalud.backend.dto.MedicoDTO;
import com.citasalud.backend.dto.MedicoFranjasDTO;

import java.util.List;

public interface MedicoService {
    List<MedicoDTO> obtenerTodos();
    void crearMedico(MedicoDTO medicoDTO);


    List<MedicoFranjasDTO> listarMedicosConFranjas();
}
