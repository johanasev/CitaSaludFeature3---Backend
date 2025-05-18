package com.citasalud.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DisponibilidadDTO {
    @NotNull(message = "La lista de días no puede ser nula")
    @Size(min = 1, message = "Debe seleccionar al menos un día")
    private List<String> dias;         // Ej: ["LUNES", "MIERCOLES"]
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @NotNull(message = "La hora de inicio no puede ser nula")
    private LocalTime horaInicio;      // Ej: 08:00
    @NotNull(message = "La hora de fin no puede ser nula")
    private LocalTime horaFin;         // Ej: 12:00
}




