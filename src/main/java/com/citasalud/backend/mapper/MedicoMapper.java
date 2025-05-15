package com.citasalud.backend.mapper;

import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.dto.MedicoDTO;

public class MedicoMapper {

    public static MedicoDTO toDTO(Medico medico) {
        MedicoDTO dto = new MedicoDTO();
        dto.setEspecialidadId(medico.getEspecialidad().getId());
        dto.setEspecialidad(medico.getEspecialidad().getEspecialidad());
        dto.setRolId(medico.getRol().getId()); // ← esta es la corrección
        dto.setNombreCompleto(medico.getNombre() + " " + medico.getApellido());

        return dto;
    }
}
