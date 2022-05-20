package com.sinensia.juegos04.integration.services;

import java.util.List;

import com.sinensia.juegos04.integration.model.Videojuego;

public interface VideojuegoServices {
	
	List<Videojuego> obtenerListadoJuegos();
	
	Videojuego obtenerJuegoByCodigo(String codigo);
	
	boolean crearJuego(Videojuego videojuego);
	
	List<Videojuego> obtenerJuegoByFabricante(Integer codigo);

}
