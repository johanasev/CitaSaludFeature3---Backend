package com.citasalud.backend.service;

import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.domain.Especialidad;
import com.citasalud.backend.domain.Rol;
import com.citasalud.backend.dto.MedicoDTO;
import com.citasalud.backend.mapper.MedicoMapper;
import com.citasalud.backend.repository.EspecialidadRepository;
import com.citasalud.backend.repository.MedicoRepository;
import com.citasalud.backend.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepo;
    private final EspecialidadRepository especialidadRepo;
    private final RolRepository rolRepo;

    public MedicoServiceImpl(MedicoRepository medicoRepo,
                             EspecialidadRepository especialidadRepo,
                             RolRepository rolRepo) {
        this.medicoRepo = medicoRepo;
        this.especialidadRepo = especialidadRepo;
        this.rolRepo = rolRepo;
    }

    @Override
    public List<MedicoDTO> obtenerTodos() {
        return medicoRepo.findAll()
                .stream()
                .map(MedicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicoDTO crear(MedicoDTO dto) {
        Especialidad especialidad = especialidadRepo.findById(dto.getEspecialidadId())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        Rol rol = rolRepo.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Medico medico = new Medico();
        medico.setNombre(dto.getNombre());
        medico.setApellido(dto.getApellido());
        medico.setEmail(dto.getEmail());
        medico.setPassword(dto.getPassword());
        medico.setTipoDocumento(dto.getTipoDocumento());
        medico.setNumeroDocumento(dto.getNumeroDocumento());
        medico.setEspecialidad(especialidad);   // ✅ este campo se llama especialidad
        medico.setRol(rol);                     // ✅ este campo se llama rol, no rolId

        Medico guardado = medicoRepo.save(medico);

        dto.setId(guardado.getId());
        return dto;
    }

}
