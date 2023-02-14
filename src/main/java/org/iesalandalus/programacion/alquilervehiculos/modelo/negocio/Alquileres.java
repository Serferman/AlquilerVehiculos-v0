package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {

	List<Alquiler> coleccionAlquileres;

	public Alquileres() {
		coleccionAlquileres = new ArrayList<>();
	}

	public List<Alquiler> get() {
		return new ArrayList<>(coleccionAlquileres);
	}

	public List<Alquiler> get(Cliente cliente) {
		ArrayList<Alquiler> arrayAlquileresCliente = new ArrayList<>();

		for (Alquiler alquilerLista1 : coleccionAlquileres) {
			if (alquilerLista1.getCliente().equals(cliente)) {
				arrayAlquileresCliente.add(alquilerLista1);
			}
		}

		return arrayAlquileresCliente;
	}

	public List<Alquiler> get(Turismo turismo) {
		ArrayList<Alquiler> arrayAlquileresCliente = new ArrayList<>();

		for (Alquiler alquilerLista2 : coleccionAlquileres) {
			if (alquilerLista2.getTurismo().equals(turismo)) {
				arrayAlquileresCliente.add(alquilerLista2);
			}
		}

		return arrayAlquileresCliente;
	}

	public int getCantidad() {
		return coleccionAlquileres.size();
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		comprobarAlquiler(alquiler.getCliente(),alquiler.getTurismo(),alquiler.getFechaAlquiler()); 
		coleccionAlquileres.add(alquiler);
	}

	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) throws OperationNotSupportedException{		
		for(Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getFechaDevolucion() == null){
				//Sin devolver
				if (alquiler.getCliente().equals(cliente)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				}else if (alquiler.getTurismo().equals(turismo)) {
					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				}
			} else {
				//Devueltos
				if ((alquiler.getCliente().equals(cliente)) && (alquiler.getFechaDevolucion().compareTo(fechaAlquiler) >= 0)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}else if ((alquiler.getTurismo().equals(turismo)) && (alquiler.getFechaDevolucion().compareTo(fechaAlquiler) >= 0)) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}
			}
		}
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if(alquiler == null){
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}
		
		if ( buscar(alquiler) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		} 
		buscar(alquiler).devolver(fechaDevolucion);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			 throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		
		if(buscar(alquiler) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		coleccionAlquileres.remove(alquiler);
	}

	public Alquiler buscar(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		int indice = coleccionAlquileres.indexOf(alquiler);
		return (indice == -1)? null: coleccionAlquileres.get(indice);
	}
}
