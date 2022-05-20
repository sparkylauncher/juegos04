package com.sinensia.juegos04.integration.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sinensia.juegos04.integration.model.Fabricante;
import com.sinensia.juegos04.integration.model.TipoVideojuego;
import com.sinensia.juegos04.integration.model.Videojuego;
import com.sinensia.juegos04.integration.repositories.VideojuegoRepository;
import com.sinensia.juegos04.integration.services.impl.VideoJuegoServicesImpl;

@ExtendWith(MockitoExtension.class)
class VideojuegoServicesTest {
	
	@Mock
	VideojuegoRepository videojuegoRepository;
	
	@InjectMocks
	VideoJuegoServicesImpl videojuegoServices;
	
	private Videojuego videojuego1;
	private Videojuego videojuego2;
	
	private Fabricante fabricante1;
	
	private List<Videojuego> listaVideojuegos;

	@BeforeEach
	public void init() {	
		initMocks();
	}
	
	@Test
	void testObtenerListadoJuegos() {
		
		when(videojuegoRepository.findAll()).thenReturn(listaVideojuegos);
		
		List<Videojuego> videojuegosObtenidos = videojuegoServices.obtenerListadoJuegos();
		
		assertEquals(2,videojuegosObtenidos.size());
		assertNotNull(videojuegosObtenidos.get(0));
		
		Videojuego miVideojuego = new Videojuego();
		
		miVideojuego.setCodigo("DFGERT334E");
		
		assertTrue(videojuegosObtenidos.contains(miVideojuego));
		
	}

	@Test
	void testObtenerJuegoByCodigo() {
		
		when(videojuegoRepository.findById("DFGERT334E")).thenReturn(Optional.of(videojuego1));
		
		Videojuego miVideojuego = videojuegoServices.obtenerJuegoByCodigo("DFGERT334E");
		
		assertNotNull(miVideojuego);
		assertEquals("DFGERT334E",miVideojuego.getCodigo());
		assertEquals("SONIC RANGERS", miVideojuego.getTitulo());
		assertEquals(TipoVideojuego.PLATAFORMAS,miVideojuego.getTipoVideojuego());
	}

	@Test
	void testCrearJuego() {
		
		when(videojuegoRepository.save(videojuego1)).thenReturn(videojuego1);
		
		assertTrue(videojuegoServices.crearJuego(videojuego1));
	}

	@Test
	void testObtenerJuegoByFabricante() {
		when(videojuegoRepository.findByFabricanteCodigo(1)).thenReturn(List.of(videojuego1));
		
		List<Videojuego> misVideojuegosByFabricante = videojuegoServices.obtenerJuegoByFabricante(1);
		
		assertEquals(1,misVideojuegosByFabricante.size());
		assertNotNull(misVideojuegosByFabricante.get(0));
		
		Videojuego miVideojuego = new Videojuego();
		
		miVideojuego.setCodigo("DFGERT334E");
		
		assertTrue(misVideojuegosByFabricante.contains(miVideojuego));
		
		
	}
	
	private void initMocks() {
		
		videojuego1 = new Videojuego();
		videojuego2 = new Videojuego();
		
		fabricante1 = new Fabricante();
		
		videojuego1.setCodigo("DFGERT334E");
		videojuego1.setTitulo("SONIC RANGERS");
		videojuego1.setFechaAlta(new Date(200000));
		videojuego1.setPrecio(50.0);
		videojuego1.setTipoVideojuego(TipoVideojuego.PLATAFORMAS);
		videojuego1.setDescatalogado(false);
		videojuego1.setFabricante(fabricante1);
		
		videojuego2.setCodigo("GFDG3334D3");
		videojuego2.setTitulo("KINDOM HEARTS");
		videojuego2.setFechaAlta(new Date(300000));
		videojuego2.setPrecio(10.0);
		videojuego2.setTipoVideojuego(TipoVideojuego.AVENTURAS);
		videojuego2.setDescatalogado(true);
		videojuego2.setFabricante(fabricante1);
		
		listaVideojuegos = new ArrayList<>();
		
		listaVideojuegos.add(videojuego1);
		listaVideojuegos.add(videojuego2);
	}

}
