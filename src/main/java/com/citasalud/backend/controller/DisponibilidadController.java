package com.citasalud.backend.controller;

import com.citasalud.backend.dto.DisponibilidadDTO;
import com.citasalud.backend.service.DisponibilidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franjas")
@CrossOrigin(origins = "*")
public class DisponibilidadController {

    private final DisponibilidadService franjaHorariaService;

    public DisponibilidadController(DisponibilidadService franjaHorariaService) {
        this.franjaHorariaService = franjaHorariaService;
    }

    // HU002 - Agregar franja horaria a un médico
    @PostMapping
    public ResponseEntity<DisponibilidadDTO> agregarFranja(@RequestBody DisponibilidadDTO dto) {
        DisponibilidadDTO guardada = franjaHorariaService.agregarFranja(dto);
        return ResponseEntity.ok(guardada);
    }
}
