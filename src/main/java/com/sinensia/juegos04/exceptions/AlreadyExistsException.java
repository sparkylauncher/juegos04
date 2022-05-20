package com.sinensia.juegos04.exceptions;

public class AlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AlreadyExistsException(String tipoObjeto, String nombreId,Object clave) {
		super("ya existe un " + tipoObjeto + " con " + nombreId + ": " + clave.toString());
	}

}
