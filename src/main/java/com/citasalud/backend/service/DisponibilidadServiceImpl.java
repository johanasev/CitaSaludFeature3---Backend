package com.citasalud.backend.service;

import com.citasalud.backend.domain.Disponibilidad;
import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.dto.DisponibilidadDTO;
import com.citasalud.backend.mapper.DisponibilidadMapper;
import com.citasalud.backend.repository.DisponibilidadRepository;
import com.citasalud.backend.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisponibilidadServiceImpl implements DisponibilidadService {

    private final DisponibilidadRepository franjaRepo;
    private final MedicoRepository medicoRepo;

    public DisponibilidadServiceImpl(DisponibilidadRepository franjaRepo, MedicoRepository medicoRepo) {
        this.franjaRepo = franjaRepo;
        this.medicoRepo = medicoRepo;
    }

    @Override
    public void agregarFranja(DisponibilidadDTO dto, Long medicoId) {
        Optional<Medico> medicoOpt = medicoRepo.findById(medicoId);
        if (medicoOpt.isEmpty()) {
            throw new RuntimeException("Médico no encontrado");
        }

        Medico medico = medicoOpt.get();

        Disponibilidad franja = DisponibilidadMapper.toEntity(dto);
        franja.setMedico(medico);
        franjaRepo.save(franja);
    }

    @Override
    public List<DisponibilidadDTO> listarFranjas() {
        return franjaRepo.findAll().stream()
                .map((Disponibilidad entity) -> DisponibilidadMapper.toDTO(entity))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional // Asegura que la operación de eliminación sea transaccional
    public void eliminarFranja(Long franjaId) {
        // Opcional: verificar si la franja existe antes de intentar eliminar
        if (!franjaRepo.existsById(franjaId)) {
            throw new RuntimeException("Franja horaria con ID " + franjaId + " no encontrada");
        }
        franjaRepo.deleteById(franjaId);
    }

    // En DisponibilidadServiceImpl
    @Override
    @Transactional // Asegura que la operación sea transaccional
    public DisponibilidadDTO actualizarFranja(Long franjaId, DisponibilidadDTO dto) {
        // Buscar la franja existente
        Disponibilidad franjaExistente = franjaRepo.findById(franjaId)
                .orElseThrow(() -> new RuntimeException("Franja horaria con ID " + franjaId + " no encontrada"));

        // Actualizar los campos de la entidad existente con los datos del DTO
        // NOTA: El ID y el médico asociado generalmente NO se cambian en una actualización de franja
        franjaExistente.setDias(dto.getDias());
        franjaExistente.setFechaInicio(dto.getFechaInicio());
        franjaExistente.setFechaFin(dto.getFechaFin());
        franjaExistente.setHoraInicio(dto.getHoraInicio());
        franjaExistente.setHoraFin(dto.getHoraFin());


        // Guardar la entidad actualizada (JpaRepository.save sirve para update si tiene ID)
        Disponibilidad franjaActualizada = franjaRepo.save(franjaExistente);

        // Convertir y retornar el DTO actualizado
        return DisponibilidadMapper.toDTO(franjaActualizada);
    }
}
