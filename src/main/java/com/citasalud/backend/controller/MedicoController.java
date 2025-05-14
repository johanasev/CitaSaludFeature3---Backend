package com.citasalud.backend.controller;

import com.citasalud.backend.dto.MedicoDTO;
import com.citasalud.backend.service.MedicoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<MedicoDTO> obtenerMedicos() {
        return medicoService.obtenerTodos();
    }
}

