package com.citasalud.backend.repository;

import com.citasalud.backend.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("SELECT DISTINCT m FROM Medico m LEFT JOIN FETCH m.disponibilidades")
    List<Medico> findAllWithDisponibilidades();
}
