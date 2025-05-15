package com.citasalud.backend.service;

import com.citasalud.backend.domain.Disponibilidad;
import com.citasalud.backend.domain.Medico;
import com.citasalud.backend.dto.DisponibilidadDTO;
import com.citasalud.backend.mapper.DisponibilidadMapper;
import com.citasalud.backend.repository.DisponibilidadRepository;
import com.citasalud.backend.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import com.citasalud.backend.domain.Dia;
import java.util.List;


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
        Medico medico = medicoRepo.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        Disponibilidad franja = new Disponibilidad();
        franja.setHoraInicio(dto.getHoraInicio());
        franja.setHoraFin(dto.getHoraFin());
        franja.setMedico(medico);

        // Convertir List<String> a List<Dia>
        List<Dia> listaDias = dto.getDias().stream().map(nombre -> {
            Dia dia = new Dia();
            dia.setNombre(nombre);
            dia.setDisponibilidad(franja); // referencia inversa
            return dia;
        }).toList();

        franja.setDias(listaDias);

        Disponibilidad guardada = franjaRepo.save(franja);

        // Convertir a DTO
        DisponibilidadDTO respuesta = new DisponibilidadDTO();
        respuesta.setId(guardada.getDisponibilidadId());
        respuesta.setMedicoId(medico.getId());
        respuesta.setHoraInicio(guardada.getHoraInicio());
        respuesta.setHoraFin(guardada.getHoraFin());

        List<String> diasRespuesta = guardada.getDias().stream()
                .map(Dia::getNombre)
                .toList();
        respuesta.setDias(diasRespuesta);

        return respuesta;
    }
}
