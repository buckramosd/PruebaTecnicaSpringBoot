package com.example.PruebaTecnicaARVision.repository;

import com.example.PruebaTecnicaARVision.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaz que extiende de JpaRepository para la persistencia de datos con Hibernate
 */
@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

}
