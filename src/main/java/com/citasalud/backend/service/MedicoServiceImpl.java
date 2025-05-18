package com.citasalud.backend.service;

import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.dto.MedicoDTO;
import com.citasalud.backend.dto.MedicoFranjasDTO;
import com.citasalud.backend.mapper.DisponibilidadMapper;
import com.citasalud.backend.mapper.MedicoMapper;
import com.citasalud.backend.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServiceImpl implements MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<MedicoDTO> obtenerTodos() {
        return medicoRepository.findAll()
                .stream()
                .map(MedicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void crearMedico(MedicoDTO medicoDTO) {
        Medico medico = MedicoMapper.toEntity(medicoDTO); // Convierte el DTO a entidad
        medicoRepository.save(medico); // Guarda en la BD
         // Convierte de nuevo a DTO para retornar
    }

    @Override // Si implementas una interfaz MedicoService
    public List<MedicoFranjasDTO> listarMedicosConFranjas() {
        // *** Aquí llamas al método definido en la interfaz MedicoRepository ***
        List<Medico> medicos = medicoRepository.findAllWithDisponibilidades();

        // Mapear de List<Medico> a List<MedicoConFranjasDTO>
        return medicos.stream()
                .map(medico -> {
                    MedicoFranjasDTO dto = new MedicoFranjasDTO();
                    // Mapear campos básicos de Medico
                    dto.setId(medico.getId());
                    dto.setNombre(medico.getNombre());
                    dto.setApellido(medico.getApellido());
                    dto.setEmail(medico.getEmail());
                    dto.setTipoDocumento(medico.getTipoDocumento());
                    dto.setNumeroDocumento(medico.getNumeroDocumento());

                    // Mapear la especialidad y el rol (puedes reutilizar MedicoMapper para los campos base o hacerlo aquí)
                    if (medico.getEspecialidad() != null) {
                        dto.setEspecialidadId(medico.getEspecialidad().getEspecialidadId());
                        dto.setEspecialidadNombre(medico.getEspecialidad().getEspecialidad()); // Asumiendo getNombre()
                    }
                    if (medico.getRolId() != null) { // Asumiendo getRolId() es Rol
                        dto.setRolId(medico.getRolId().getRolId());
                        dto.setRolNombre(medico.getRolId().getNombre()); // Asumiendo getNombre()
                    }


                    // *** Mapear la lista de Disponibilidad a List<DisponibilidadDTO> ***
                    if (medico.getDisponibilidades() != null) {
                        dto.setFranjasDisponibles(medico.getDisponibilidades().stream()
                                .map(DisponibilidadMapper::toDTO) // Reutiliza tu DisponibilidadMapper
                                .collect(Collectors.toList()));
                    } else {
                        dto.setFranjasDisponibles(Collections.emptyList());
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }
}

