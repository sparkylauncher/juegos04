package com.sinensia.juegos04.integration.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sinensia.juegos04.integration.model.Fabricante;
import com.sinensia.juegos04.integration.repositories.FabricanteRepository;
import com.sinensia.juegos04.integration.services.impl.FabricanteServicesImpl;

@ExtendWith(MockitoExtension.class)
class FabricanteServicesTest {
	
	@Mock
	FabricanteRepository fabricanteRepository;
	
	@InjectMocks
	FabricanteServicesImpl fabricanteServices;
	
	private Fabricante fabricante1;
	private Fabricante fabricante2;
	
	private List<Fabricante> listaFabricantes;
	
	@BeforeEach
	public void init() {
		initMocks();
	}

	@Test
	void testObtenerFabricantes() {
		
		when(fabricanteRepository.findAll()).thenReturn(listaFabricantes);
		
		List<Fabricante> fabricantesObtenidos = fabricanteServices.obtenerFabricantes();
		
		assertEquals(2,fabricantesObtenidos.size());
		assertNotNull(fabricantesObtenidos.get(0));
		
		Fabricante miFabricante = new Fabricante();
		
		miFabricante.setCodigo(1);
		
		assertTrue(fabricantesObtenidos.contains(miFabricante));
	}

	@Test
	void testObtenerFabricantePorCodigo() {

		when(fabricanteRepository.findById(1)).thenReturn(Optional.of(fabricante1));
		
		Fabricante miFabricante = fabricanteServices.obtenerFabricantePorCodigo(1);
		
		assertNotNull(miFabricante);
		assertEquals(1,miFabricante.getCodigo());
		assertEquals("SEGA", miFabricante.getNombre());
	}

	@Test
	void testCrearFabricante() {
		
		when(fabricanteRepository.save(fabricante1)).thenReturn(fabricante1);
		
		assertTrue(fabricanteServices.crearFabricante(fabricante1));
	}
	
	private void initMocks() {
		
		fabricante1 = new Fabricante();
		fabricante2 = new Fabricante();
		
		fabricante1.setCodigo(1);
		fabricante1.setNombre("SEGA");
		
		fabricante2.setCodigo(2);
		fabricante2.setNombre("SQUARE ENIX");
		
		listaFabricantes = new ArrayList<>();
		
		listaFabricantes.add(fabricante1);
		listaFabricantes.add(fabricante2);
	}

}
