package com.citasalud.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disponibilidad_id")
    private Long disponibilidadId;

    @OneToMany(mappedBy = "disponibilidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dia> dias;


    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;
}

