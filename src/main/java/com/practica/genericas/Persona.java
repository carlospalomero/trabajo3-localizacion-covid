package com.practica.genericas;


import com.practica.excecption.EmsInvalidNumberOfDataException;

public class Persona {


	private String nombre, apellidos, documento, email, direccion, cp;
	FechaHora fechaNacimiento;

	public static Persona parsePersona(String[]data) throws EmsInvalidNumberOfDataException {

		if(data.length != Constantes.MAX_DATOS_PERSONA) {
			throw new EmsInvalidNumberOfDataException("Invalid number of fields for PERSONA");
		}

		String nombre = data[2];
		String apellidos = data[3];
		String documento = data[1];
		String email = data[4];
		String direccion = data[5];
		String cp = data[6];
		FechaHora fechaNacimiento = FechaHora.parseFecha(data[7]);

		return new Persona(nombre, apellidos, documento, email, direccion, cp, fechaNacimiento);
	}

	public Persona(String nombre, String apellidos, String documento, String email, String direccion, String cp,
				   FechaHora fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.documento = documento;
		this.email = email;
		this.direccion = direccion;
		this.cp = cp;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona(Persona other) {
		this.nombre = other.nombre;
		this.apellidos = other.apellidos;
		this.documento = other.documento;
		this.email = other.email;
		this.direccion = other.direccion;
		this.cp = other.cp;
		this.fechaNacimiento = other.fechaNacimiento;
	}

	public Persona(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		FechaHora fecha = fechaNacimiento;
		String cadena = "";

		cadena += String.format("%s;", documento);
		cadena += String.format("%s,%s;", apellidos,nombre);
		cadena += String.format("%s;", email);
		cadena += String.format("%s,%s;", direccion, cp);
		cadena+= fecha.toString();

		return cadena;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Persona other = (Persona) obj;
		return documento.equals(other.documento);
	}

	@Override
	public int hashCode() {
		return documento.hashCode();
	}
}
