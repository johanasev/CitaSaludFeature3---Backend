package com.citasalud.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificacion_id")
    private Long idNotificacion;
    @Column(name = "mensaje", nullable = false)
    private String mensaje;

    @Column(name = "fecha", nullable = false)
    private LocalTime fecha;

    @ManyToOne
    @JoinColumn(name = "bloqueo_id", nullable = false)
    private BloqueoOperativo bloqueoOperativo;

    public Long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalTime fecha) {
        this.fecha = fecha;
    }

    public BloqueoOperativo getBloqueoOperativo() {
        return bloqueoOperativo;
    }

    public void setBloqueoOperativo(BloqueoOperativo bloqueoOperativo) {
        this.bloqueoOperativo = bloqueoOperativo;
    }
}

