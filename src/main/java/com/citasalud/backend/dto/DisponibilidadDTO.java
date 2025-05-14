package com.citasalud.backend.dto;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DisponibilidadDTO {
    private Long medicoId;
    private List<String> dias;         // Ej: ["LUNES", "MIERCOLES"]
    private LocalTime horaInicio;      // Ej: 08:00
    private LocalTime horaFin;         // Ej: 12:00
}




