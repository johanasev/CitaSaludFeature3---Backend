package com.citasalud.backend.mapper;

import com.citasalud.backend.domain.Especialidad;
import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.domain.Rol;
import com.citasalud.backend.dto.MedicoDTO;

public class MedicoMapper {

    public static MedicoDTO toDTO(Medico medico) {
        if (medico == null) {
            return null;
        }

        MedicoDTO dto = new MedicoDTO();
        dto.setNombre(medico.getNombre());
        dto.setApellido(medico.getApellido());
        dto.setEmail(medico.getEmail());
        dto.setTipoDocumento(medico.getTipoDocumento());
        dto.setNumeroDocumento(medico.getNumeroDocumento());

        // Mapear la información de las relaciones (Especialidad y Rol)
        if (medico.getEspecialidad() != null) {
            dto.setEspecialidadId(medico.getEspecialidad().getEspecialidadId());
             // Asumiendo que Especialidad tiene getNombre()
        }

        if (medico.getRolId() != null) { // Nota: el nombre de tu variable es rolId, lo uso aquí
            dto.setRolId(medico.getRolId().getRolId());
             // Asumiendo que Rol tiene getNombre()
        }

        return dto;
    }

    public static Medico toEntity(MedicoDTO dto) {
        if (dto == null) {
            return null;
        }

        Medico medico = new Medico();
        medico.setNombre(dto.getNombre());
        medico.setApellido(dto.getApellido());
        medico.setEmail(dto.getEmail());
        medico.setPassword(dto.getPassword());
        medico.setTipoDocumento(dto.getTipoDocumento());
        medico.setNumeroDocumento(dto.getNumeroDocumento());

        if (dto.getEspecialidadId() != null) {
            // Esto es un DUMMY. Reemplazar en la vida real.
            Especialidad especialidad = new Especialidad();
            especialidad.setEspecialidadId(dto.getEspecialidadId());
            // Si necesitas otros campos de Especialidad, cárgalos desde el DTO o la base de datos.
            medico.setEspecialidad(especialidad);
        }

        if (dto.getRolId() != null) {
            // Esto es un DUMMY. Reemplazar en la vida real.
            Rol rol = new Rol();
            rol.setRolId(dto.getRolId());
            // Si necesitas otros campos de Rol, cárgalos desde el DTO o la base de datos.
            medico.setRolId(rol); // Nota: tu variable se llama rolId, lo uso aquí
        }


        return medico;
    }
}
