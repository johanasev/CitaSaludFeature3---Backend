package com.citasalud.backend.mapper;

import com.citasalud.backend.domain.Disponibilidad;
import com.citasalud.backend.dto.DisponibilidadDTO;

public class DisponibilidadMapper {

    public static DisponibilidadDTO toDTO(Disponibilidad entity) {
        DisponibilidadDTO dto = new DisponibilidadDTO();
        dto.setMedicoId(entity.getMedico().getId());
        dto.setDias(entity.getDias());
        dto.setHoraInicio(entity.getHoraInicio());
        dto.setHoraFin(entity.getHoraFin());
        return dto;
    }

    public static Disponibilidad toEntity(DisponibilidadDTO dto) {
        Disponibilidad entity = new Disponibilidad();
        entity.setDias(dto.getDias());
        entity.setHoraInicio(dto.getHoraInicio());
        entity.setHoraFin(dto.getHoraFin());
        return entity;
    }
}
