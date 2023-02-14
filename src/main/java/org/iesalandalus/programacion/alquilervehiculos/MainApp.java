package org.iesalandalus.programacion.alquilervehiculos;


import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Controlador controlador = new Controlador(new Modelo(), vista);
		controlador.comenzar();
	}

}
