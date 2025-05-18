package com.citasalud.backend.controller;

import com.citasalud.backend.dto.MedicoDTO;
import com.citasalud.backend.dto.MedicoFranjasDTO;
import com.citasalud.backend.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/obtenermedicos")
    public List<MedicoDTO> obtenerMedicos() {
        return medicoService.obtenerTodos();
    }

    @PostMapping("/crearmedico")
    public ResponseEntity<MedicoDTO> crearMedico(@RequestBody MedicoDTO medicoDTO) {
        medicoService.crearMedico(medicoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // En MedicoController
    @GetMapping("/confranjas") // Un nuevo endpoint claro
    public ResponseEntity<List<MedicoFranjasDTO>> obtenerMedicosConFranjas() {
        List<MedicoFranjasDTO> medicosConFranjas = medicoService.listarMedicosConFranjas();
        return ResponseEntity.ok(medicosConFranjas);
    }
}

