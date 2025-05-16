package com.citasalud.backend.dto;

import com.citasalud.backend.domain.Medico;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DisponibilidadDTO {
    private List<String> dias;         // Ej: ["LUNES", "MIERCOLES"]
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horaInicio;      // Ej: 08:00
    private LocalTime horaFin;         // Ej: 12:00
}




