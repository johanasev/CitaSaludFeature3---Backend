package com.citasalud.backend.controller;

import com.citasalud.backend.dto.DisponibilidadDTO;
import com.citasalud.backend.service.DisponibilidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franjas")
@CrossOrigin(origins = "*")
public class DisponibilidadController {

    private final DisponibilidadService franjaHorariaService;

    public DisponibilidadController(DisponibilidadService franjaHorariaService) {
        this.franjaHorariaService = franjaHorariaService;
    }

    // HU002 - Agregar franja horaria a un médico
    @PostMapping("/{id}")
    public ResponseEntity<DisponibilidadDTO> agregarFranja(@RequestBody DisponibilidadDTO dto,
                                                           @PathVariable("id") Long medicoId) {
        franjaHorariaService.agregarFranja(dto, medicoId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listarfranjas")
    public ResponseEntity<List<DisponibilidadDTO>> obtenerFranjas() {
        List<DisponibilidadDTO> franjas = franjaHorariaService.listarFranjas();
        return ResponseEntity.ok(franjas);
    }

}
