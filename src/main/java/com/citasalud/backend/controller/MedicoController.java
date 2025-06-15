package com.citasalud.backend.controller;

import com.citasalud.backend.dto.MedicoDTO;
import com.citasalud.backend.dto.MedicoFranjasDTO;
import com.citasalud.backend.service.MedicoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "BearerAuth")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/obtenermedicos")
    public List<MedicoDTO> obtenerMedicos() {
        return medicoService.obtenerTodos();
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'COORDINADOR')")
    @PostMapping("/crearmedico")
    public ResponseEntity<MedicoDTO> crearMedico(@RequestBody MedicoDTO medicoDTO) {
        medicoService.crearMedico(medicoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // En MedicoController
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/confranjas") // Un nuevo endpoint claro
    public ResponseEntity<List<MedicoFranjasDTO>> obtenerMedicosConFranjas() {
        List<MedicoFranjasDTO> medicosConFranjas = medicoService.listarMedicosConFranjas();
        return ResponseEntity.ok(medicosConFranjas);
    }
}

