package com.practica.genericas;


import com.practica.excecption.EmsInvalidNumberOfDataException;

public class PosicionPersona {

	private Coordenada coordenada;
	private String documento;
	private FechaHora fechaPosicion;

	public static PosicionPersona parsePosicionPersona(String[] data) throws EmsInvalidNumberOfDataException {

		if (data.length != Constantes.MAX_DATOS_LOCALIZACION) {
			throw new EmsInvalidNumberOfDataException("La cantidad de campos de la localización es incorrecta");
		}

		String documento = data[1];
		FechaHora fechaPosicion = FechaHora.parseFecha(data[2], data[3]);
		Coordenada coordenada = new Coordenada(Float.parseFloat(data[4]), Float.parseFloat(data[5]));
		return new PosicionPersona(coordenada, documento, fechaPosicion);
	}

	public PosicionPersona(Coordenada coordenada, String documento, FechaHora fechaPosicion) {
		this.coordenada = coordenada;
		this.documento = documento;
		this.fechaPosicion = fechaPosicion;
	}

	public PosicionPersona() {

	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public FechaHora getFechaPosicion() {
		return fechaPosicion;
	}
	public void setFechaPosicion(FechaHora fechaPosicion) {
		this.fechaPosicion = fechaPosicion;
	}
	public boolean isThisPerson(String documento){
		return this.documento.equals(documento);
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s", documento, fechaPosicion.toString(), coordenada.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PosicionPersona)) {
			return false;
		}

		PosicionPersona posicionPersona = (PosicionPersona) obj;
		return posicionPersona.documento.equals(this.documento) &&
				posicionPersona.fechaPosicion.equals(this.fechaPosicion);
	}

	@Override
	public int hashCode() {
		final int prime = 23;
		int result = 1;
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((fechaPosicion == null) ? 0 : fechaPosicion.hashCode());
		return result;
	}
		
}
