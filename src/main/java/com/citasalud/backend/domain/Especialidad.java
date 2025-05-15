package com.citasalud.backend.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "especialidad_id")
    private Long id;

    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @Column(name = "descripcion")
    private String descripcion;
}
