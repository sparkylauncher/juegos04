package com.sinensia.juegos04.exceptions;

public class NotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NotFoundException(String nombreObjeto) {
		super(nombreObjeto + " no encontrado");
	}

}
