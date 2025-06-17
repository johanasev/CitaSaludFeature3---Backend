package com.citasalud.backend.controller;

import com.citasalud.backend.dto.DisponibilidadDTO;
import com.citasalud.backend.service.DisponibilidadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/franjas")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "BearerAuth")
public class DisponibilidadController {

    private final DisponibilidadService franjaHorariaService;

    public DisponibilidadController(DisponibilidadService franjaHorariaService) {
        this.franjaHorariaService = franjaHorariaService;
    }

    // HU002 - Agregar franja horaria a un médico

    @PostMapping("/{id}")

    @PreAuthorize("hasAnyRole('MEDICO', 'COORDINADOR')")
    public ResponseEntity<DisponibilidadDTO> agregarFranja(@Valid @RequestBody DisponibilidadDTO dto,
                                                           @PathVariable("id") Long medicoId) {
        franjaHorariaService.agregarFranja(dto, medicoId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/listarfranjas")
    public ResponseEntity<List<DisponibilidadDTO>> obtenerFranjas() {
        List<DisponibilidadDTO> franjas = franjaHorariaService.listarFranjas();
        return ResponseEntity.ok(franjas);
    }

    @PreAuthorize("hasAnyRole('MEDICO', 'COORDINADOR', 'ADMINISTRADOR')")
    @DeleteMapping("/{idFranja}") // Usamos un nombre de variable claro para el ID de la franja
    public ResponseEntity<Void> eliminarFranja(@PathVariable("idFranja") Long franjaId) {
        franjaHorariaService.eliminarFranja(franjaId);
        // Retorna 204 No Content si la eliminación fue exitosa (o 404 si no se encontró antes de eliminar)
        return ResponseEntity.noContent().build();
    }

    // En DisponibilidadController
    @PreAuthorize("hasAnyRole('MEDICO', 'COORDINADOR', 'ADMINISTRADOR')")
    @PutMapping("/{idFranja}") // Usamos PUT para actualizar
    public ResponseEntity<DisponibilidadDTO> actualizarFranja(@PathVariable("idFranja") Long franjaId,
                                                              @Valid @RequestBody DisponibilidadDTO dto) { // Aplicamos validación al DTO
        DisponibilidadDTO franjaActualizada = franjaHorariaService.actualizarFranja(franjaId, dto);
        return ResponseEntity.ok(franjaActualizada);
    }
}
