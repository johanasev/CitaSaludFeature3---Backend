package com.citasalud.backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicoDTO {
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String password;

    private String tipoDocumento;
    private String numeroDocumento;

    private Long especialidadId;
    private String especialidad;        // <- Nombre legible de la especialidad

    private Long rolId;
    private String nombreCompleto;      // <- Campo extra si lo estás armando en el mapper
}



