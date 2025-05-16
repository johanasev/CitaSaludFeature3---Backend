package com.citasalud.backend.service;

import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.dto.MedicoDTO;
import com.citasalud.backend.mapper.MedicoMapper;
import com.citasalud.backend.repository.MedicoRepository;
import org.springframework.stereotype.Service;

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
}

