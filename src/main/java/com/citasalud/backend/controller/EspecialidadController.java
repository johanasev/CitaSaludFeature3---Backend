package com.citasalud.backend.controller;

import com.citasalud.backend.domain.Especialidad;
import com.citasalud.backend.repository.EspecialidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin(origins = "*")
public class EspecialidadController {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadController(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @GetMapping
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }
}
