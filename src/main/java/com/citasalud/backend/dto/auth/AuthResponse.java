package com.citasalud.backend.dto.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder // Anotación de Lombok para usar el patrón Builder
public class AuthResponse {
    private String jwt;
    private String email; // o username
    private String role; // El rol del usuario (ej. "MEDICO", "COORDINADOR")
}