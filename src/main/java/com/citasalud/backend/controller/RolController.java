package com.citasalud.backend.controller;

import com.citasalud.backend.domain.Rol;
import com.citasalud.backend.repository.RolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {

    private final RolRepository rolRepository;

    public RolController(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @GetMapping
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }
}
