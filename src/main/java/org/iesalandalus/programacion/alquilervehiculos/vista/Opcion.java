package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {

	SALIR("Salir"),
	INSERTAR_CLIENTE("Insertar cliente"),
	INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"),
	BUSCAR_CLIENTE("Buscar cliente"),
	BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"),
	MODIFICAR_CLIENTE("Modificar cliente"),
	DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"),
	BORRAR_TURISMO("Borrar turismo"),
	BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"),
	LISTAR_TURISMOS("Listar turismos"),
	LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres del cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar alquileres del turismo");
	
	private String texto;
	
	private Opcion (String texto) {
		this.texto = texto;
	}
	
	private boolean esOrdinalValido (int ordinal) {
		return ((ordinal >= 0) && (ordinal <=Opcion.values().length));
	}
	
	public Opcion get(int ordinal) {
		if (!esOrdinalValido(ordinal)) {
			throw new IllegalArgumentException("ERROR: La opcion seleccionada no es válida.");
		}
		return Opcion.values()[ordinal];
	}
	
	@Override
	public String toString() {
		return String.format("%d.- %s",ordinal() ,texto);
	}	
}