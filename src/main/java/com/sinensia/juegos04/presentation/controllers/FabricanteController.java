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

import com.sinensia.juegos04.integration.model.Fabricante;
import com.sinensia.juegos04.integration.services.FabricanteServices;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {
	
	@Autowired
	FabricanteServices fabricanteServices;
	
	@GetMapping
	public List<Fabricante> obtenerFabricantes(){
		
		return fabricanteServices.obtenerFabricantes();
	}
	
	@GetMapping("/{codigo}")
	public Fabricante obtenerFabricanteByCodigo(@PathVariable("codigo") Integer codigo) {

		return fabricanteServices.obtenerFabricantePorCodigo(codigo);
			
	}
	
	@PostMapping
	public ResponseEntity<?> crearFabricante(@RequestBody Fabricante fabricante, UriComponentsBuilder uriComponentsBuilder) {
		return (fabricanteServices.crearFabricante(fabricante)) ?
				ResponseEntity
				.created(uriComponentsBuilder.path("/fabricantes/{codigo}").build(fabricante.getCodigo()))
				.body("fabricante creado") : ResponseEntity.internalServerError().build();

	}
}
