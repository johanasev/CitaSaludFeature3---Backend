package com.citasalud.backend.service;

import com.citasalud.backend.domain.Disponibilidad;
import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.dto.DisponibilidadDTO;
import com.citasalud.backend.mapper.DisponibilidadMapper;
import com.citasalud.backend.repository.DisponibilidadRepository;
import com.citasalud.backend.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisponibilidadServiceImpl implements DisponibilidadService {

    private final DisponibilidadRepository franjaRepo;
    private final MedicoRepository medicoRepo;

    public DisponibilidadServiceImpl(DisponibilidadRepository franjaRepo, MedicoRepository medicoRepo) {
        this.franjaRepo = franjaRepo;
        this.medicoRepo = medicoRepo;
    }

    @Override
    public DisponibilidadDTO agregarFranja(DisponibilidadDTO dto) {
        Optional<Medico> medico = medicoRepo.findById(dto.getMedicoId());
        if (medico.isEmpty()) {
            throw new RuntimeException("Médico no encontrado");
        }

        Disponibilidad franja = DisponibilidadMapper.toEntity(dto);
        franja.setMedico(medico.get());
        Disponibilidad guardada = franjaRepo.save(franja);
        return DisponibilidadMapper.toDTO(guardada);
    }
}
