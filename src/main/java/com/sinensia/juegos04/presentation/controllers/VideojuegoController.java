package com.sinensia.juegos04.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.juegos04.integration.model.Videojuego;
import com.sinensia.juegos04.integration.services.VideojuegoServices;

@RestController
@RequestMapping("/videojuegos")
public class VideojuegoController {


		
		@Autowired
		VideojuegoServices videojuegoServices;
		
		@GetMapping
		public List<Videojuego> obtenervideojuegos(){
			
			return videojuegoServices.obtenerListadoJuegos();
		}
		
		@GetMapping("/{codigo}")
		public Videojuego obtenervideojuegoByCodigo(@PathVariable("codigo") String codigo) {

			return videojuegoServices.obtenerJuegoByCodigo(codigo);
				
		}
		
		@PostMapping
		public ResponseEntity<?> crearvideojuego(@RequestBody Videojuego videojuego, UriComponentsBuilder uriComponentsBuilder) {
			return (videojuegoServices.crearJuego(videojuego)) ?
					ResponseEntity
					.created(uriComponentsBuilder.path("/videojuegos/{codigo}").build(videojuego.getCodigo()))
					.body("fabricante creado") : ResponseEntity.internalServerError().build();
		}
	}
