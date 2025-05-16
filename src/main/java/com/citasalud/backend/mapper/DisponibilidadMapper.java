package com.citasalud.backend.mapper;

import com.citasalud.backend.domain.Disponibilidad;
import com.citasalud.backend.dto.DisponibilidadDTO;

public class DisponibilidadMapper {

    public static DisponibilidadDTO toDTO(Disponibilidad entity) {
        DisponibilidadDTO dto = new DisponibilidadDTO();
        dto.setDias(entity.getDias());
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFin(entity.getFechaFin());
        dto.setHoraInicio(entity.getHoraInicio());
        dto.setHoraFin(entity.getHoraFin());
        return dto;
    }

    public static Disponibilidad toEntity(DisponibilidadDTO dto) {
        Disponibilidad entity = new Disponibilidad();
        entity.setDias(dto.getDias());
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        entity.setHoraInicio(dto.getHoraInicio());
        entity.setHoraFin(dto.getHoraFin());
        return entity;
    }
}
