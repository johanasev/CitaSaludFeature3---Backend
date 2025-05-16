package com.citasalud.backend.service;

import com.citasalud.backend.domain.Disponibilidad;
import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.dto.DisponibilidadDTO;
import com.citasalud.backend.mapper.DisponibilidadMapper;
import com.citasalud.backend.repository.DisponibilidadRepository;
import com.citasalud.backend.repository.MedicoRepository;
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
}
