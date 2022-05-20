package com.sinensia.juegos04.integration.services;

import java.util.List;

import com.sinensia.juegos04.integration.model.Fabricante;

public interface FabricanteServices {
	
	List<Fabricante> obtenerFabricantes();
	
	Fabricante obtenerFabricantePorCodigo(Integer codigo);
	
	boolean crearFabricante(Fabricante fabricante);

}
