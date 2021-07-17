package com.compassouol.sprint4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compassouol.sprint4.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
}
