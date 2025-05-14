package com.citasalud.backend.mapper;

import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.dto.MedicoDTO;

public class MedicoMapper {
    public static MedicoDTO toDTO(Medico medico) {
        MedicoDTO dto = new MedicoDTO();
        dto.setId(medico.getId());
        dto.setNombreCompleto(medico.getNombre() + " " + medico.getApellido());
        dto.setTipoDocumento(medico.getTipoDocumento());
        dto.setNumeroDocumento(medico.getNumeroDocumento());
        dto.setEspecialidad(
                medico.getEspecialidad() != null ? medico.getEspecialidad().getNombre() : null
        );
        return dto;
    }
}
