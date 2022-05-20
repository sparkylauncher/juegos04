package com.sinensia.juegos04.integration.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.juegos04.exceptions.AlreadyExistsException;
import com.sinensia.juegos04.exceptions.NotFoundException;
import com.sinensia.juegos04.utils.JuegosUtils;
import com.sinensia.juegos04.integration.model.Videojuego;
import com.sinensia.juegos04.integration.repositories.VideojuegoRepository;
import com.sinensia.juegos04.integration.services.VideojuegoServices;

@Service
public class VideoJuegoServicesImpl implements VideojuegoServices {
	
	@Autowired
	VideojuegoRepository videojuegoRepository;

	@Override
	public List<Videojuego> obtenerListadoJuegos() {
		return videojuegoRepository.findAll();
	}

	@Override
	public Videojuego obtenerJuegoByCodigo(String codigo) {
		
		Optional<Videojuego> videojuego = videojuegoRepository.findById(codigo);
		
		if(videojuego.isPresent()) {
			return videojuego.get();
		}
		else {
			throw new NotFoundException("videojuego");
		}
	}

	@Override
	@Transactional
	public boolean crearJuego(Videojuego videojuego) {
		
		Optional<Videojuego> miVideojuego = videojuegoRepository.findById(videojuego.getCodigo());
		
		if(miVideojuego.isPresent()) {
			String nombreId = JuegosUtils.getPKColumnName(Videojuego.class);
			throw new AlreadyExistsException("Videojuego", nombreId, videojuego.getCodigo());

		}
		else {
			return videojuegoRepository.save(videojuego) != null;
		}

	}

	@Override
	public List<Videojuego> obtenerJuegoByFabricante(Integer codigo) {
		return videojuegoRepository.findByFabricanteCodigo(codigo);
	}

}
