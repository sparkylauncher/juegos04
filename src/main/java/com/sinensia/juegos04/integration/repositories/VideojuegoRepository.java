package com.sinensia.juegos04.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinensia.juegos04.integration.model.Videojuego;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, String>{

	List<Videojuego> findByFabricanteCodigo(Integer codigo);
}
