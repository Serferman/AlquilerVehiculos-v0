package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo");
		}
		this.controlador = controlador;
	}

	public void comenzar() {
		Consola.mostrarMenu();
		ejecutar(Consola.elegirOpcion());
	}

	public void terminar() {
		System.out.println("AVISO: La vista ha terminado");
	}

	private void ejecutar(Opcion opcion) {
		switch (opcion.ordinal()) {
		case 0:
			controlador.terminar();
			break;
		case 1:
			insertarCliente();
			comenzar();
			break;
		case 2:
			insertarTurismo();
			comenzar();
			break;
		case 3:
			insertarAlquiler();
			comenzar();
			break;
		case 4:
			buscarCliente();
			comenzar();
			break;
		case 5:
			buscarTurismo();
			comenzar();
			break;
		case 6:
			buscarAlquiler();
			comenzar();
			break;
		case 7:
			modificarCliente();
			comenzar();
			break;
		case 8:
			devolverAlquiler();
			comenzar();
			break;
		case 9:
			borrarCliente();
			comenzar();
			break;
		case 10:
			borrarTurismo();
			comenzar();
			break;
		case 11:
			borrarAlquiler();
			comenzar();
			break;
		case 12:
			listarClientes();
			comenzar();
			break;
		case 13:
			listarTurismos();
			comenzar();
			break;
		case 14:
			listarAlquileres();
			comenzar();
			break;
		case 15:
			listarAlquileresCliente();
			comenzar();
			break;
		case 16:
			listarAlquileresTurismo();
			comenzar();
			break;
		}
	}

	private void insertarCliente() {
		Consola.mostrarCabecera("INSERTAR CLIENTE");
		try {
			controlador.insertar(Consola.leerCliente());
			System.out.printf("%nAVISO: Se ha insertado el cliente correctamente%n");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}

	}

	private void insertarTurismo() {
		Consola.mostrarCabecera("INSERTAR TURISMO");
		try {
			controlador.insertar(Consola.leerTurismo());
			System.out.printf("%nAVISO: Se ha insertado el turismo correctamente%n");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void insertarAlquiler() {
		Consola.mostrarCabecera("INSERTAR ALQUILER");
		try {
			controlador.insertar(Consola.leerAlquiler());
			System.out.printf("%nAVISO: Se ha insertado el alquiler correctamente%n");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void buscarCliente() {
		Consola.mostrarCabecera("BUSCAR CLIENTE");
		try {
			System.out.printf("%n%s%n", controlador.buscar(Consola.leerCliente()));
			System.out.printf("%nAVISO: Se ha buscado el cliente correctamente%n");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void buscarTurismo() {
		Consola.mostrarCabecera("BUSCAR TURISMO");
		try {
			System.out.printf("%n%s%n", controlador.buscar(Consola.leerTurismo()));
			System.out.printf("%nAVISO: Se ha buscado el turismo correctamente%n");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void buscarAlquiler() {
		Consola.mostrarCabecera("BUSCAR ALQUILER");
		try {
			System.out.printf("%n%s%n", controlador.buscar(Consola.leerAlquiler()));
			System.out.printf("%nAVISO: Se ha buscado el alquiler correctamente%n");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void modificarCliente() {
		Consola.mostrarCabecera("MODIFICAR CLIENTE");
		try {
			controlador.modificar(Consola.leerCliente(), Consola.leerNombre(), Consola.leerTelefono());
			System.out.printf("%nAVISO: Se ha modificado el cliente correctamente%n");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void devolverAlquiler() {
		Consola.mostrarCabecera("DEVOLVER ALQUILER");
		try {
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
			System.out.printf("%nAVISO: Se ha devuelto el turismo correctamente%n");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void borrarCliente() {
		Consola.mostrarCabecera("BORRAR CLIENTE");
		try {
			controlador.borrar(Consola.leerCliente());
			System.out.printf("%nAVISO: Se ha borrado el cliente correctamente%n");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void borrarTurismo() {
		Consola.mostrarCabecera("BORRAR TURISMO");
		try {
			controlador.borrar(Consola.leerTurismo());
			System.out.printf("%nAVISO: Se ha borrado el turismo correctamente%n");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void borrarAlquiler() {
		Consola.mostrarCabecera("BORRAR ALQUILER");
		try {
			controlador.borrar(Consola.leerAlquiler());
			System.out.printf("%nAVISO: Se ha borrado el alquiler correctamente%n");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarClientes() {
		Consola.mostrarCabecera("LISTAR CLIENTES");
		try {
			for (Cliente cliente : controlador.getClientes()) {
				System.out.printf("%s%n", cliente);
			}
			System.out.printf("%nAVISO: Se han listado los clientes correctamente%n");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarTurismos() {
		Consola.mostrarCabecera("LISTAR TURISMOS");
		try {
			for (Turismo turismo : controlador.getTurismos()) {
				System.out.printf("%s%n", turismo);
			}
			System.out.printf("%nAVISO: Se han listado los turismos correctamente%n");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("LISTAR ALQUILERES");
		try {
			for (Alquiler alquiler : controlador.getAlquileres()) {
				System.out.printf("%s%n", alquiler);
			}
			System.out.printf("%nAVISO: Se han listado los alquileres correctamente%n");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("LISTAR ALQUILERES CLIENTE");
		try {
			for (Alquiler alquilerCliente : controlador.getAlquileres(Consola.leerCliente())) {
				System.out.printf("%s%n", alquilerCliente);
			}
			System.out.printf("%nAVISO: Se han listado los alquileres del cliente correctamente%n");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("LISTAR ALQUILERES TURISMO");
		try {
			for (Alquiler alquilerTurismo : controlador.getAlquileres(Consola.leerTurismo())) {
				System.out.printf("%s%n", alquilerTurismo);
			}
			System.out.printf("%nAVISO: Se han listado los alquileres del turismo correctamente%n");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}
}