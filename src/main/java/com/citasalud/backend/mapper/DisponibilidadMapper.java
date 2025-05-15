package com.citasalud.backend.mapper;

import com.citasalud.backend.domain.Dia;
import com.citasalud.backend.domain.Disponibilidad;
import com.citasalud.backend.dto.DisponibilidadDTO;

import java.util.List;

public class DisponibilidadMapper {

    public static DisponibilidadDTO toDTO(Disponibilidad entity) {
        DisponibilidadDTO dto = new DisponibilidadDTO();
        dto.setMedicoId(entity.getMedico().getId());
        dto.setHoraInicio(entity.getHoraInicio());
        dto.setHoraFin(entity.getHoraFin());

        // Convertir List<Dia> a List<String>
        List<String> dias = entity.getDias().stream()
                .map(Dia::getNombre)
                .toList();
        dto.setDias(dias);

        return dto;
    }

    public static Disponibilidad toEntity(DisponibilidadDTO dto) {
        Disponibilidad entity = new Disponibilidad();
        entity.setHoraInicio(dto.getHoraInicio());
        entity.setHoraFin(dto.getHoraFin());

        // Los días deben ser convertidos en el servicio, porque se necesita la referencia a Disponibilidad
        // Aquí devolvemos lista vacía y el service se encargará
        entity.setDias(List.of());

        return entity;
    }
}
