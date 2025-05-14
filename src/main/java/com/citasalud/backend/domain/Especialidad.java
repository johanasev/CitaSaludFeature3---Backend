package com.citasalud.backend.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "especialidad_id")
    private long  especialidadId;
    @Column(name = "especialidad", nullable = false)
    private String especialidad;
    @Column(name = "descripcion")
    private String descripcion;

    public long getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(long especialidadId) {
        this.especialidadId = especialidadId;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

