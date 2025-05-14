package com.citasalud.backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicoDTO {
    private Long id;
    private String nombreCompleto;
    private String tipoDocumento;
    private String numeroDocumento;
    private String especialidad;
}



