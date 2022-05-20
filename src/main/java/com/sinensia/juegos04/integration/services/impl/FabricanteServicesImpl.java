package com.sinensia.juegos04.integration.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.juegos04.exceptions.AlreadyExistsException;
import com.sinensia.juegos04.exceptions.NotFoundException;
import com.sinensia.juegos04.integration.model.Fabricante;
import com.sinensia.juegos04.integration.repositories.FabricanteRepository;
import com.sinensia.juegos04.integration.services.FabricanteServices;
import com.sinensia.juegos04.utils.JuegosUtils;

@Service
public class FabricanteServicesImpl implements FabricanteServices {
	
	@Autowired
	FabricanteRepository fabricanteRepository;

	@Override
	public List<Fabricante> obtenerFabricantes() {
		return fabricanteRepository.findAll();
	}

	@Override
	public Fabricante obtenerFabricantePorCodigo(Integer codigo) {
		
		Optional<Fabricante> fabricante = fabricanteRepository.findById(codigo);
		
		if(fabricante.isPresent()) {
			return fabricante.get();
		}
		else {
			throw new NotFoundException("Fabricante");
		}
	}

	@Override
	@Transactional
	public boolean crearFabricante(Fabricante fabricante) {
		
		Optional<Fabricante> mifabricante = fabricanteRepository.findById(fabricante.getCodigo());
		
		if(mifabricante.isPresent()) {
			String nombreId = JuegosUtils.getPKColumnName(Fabricante.class);
			throw new AlreadyExistsException("fabricante", nombreId, fabricante.getCodigo());

		}
		else {
			return fabricanteRepository.save(fabricante) != null;
		}
	}
	
}

