package modelo;

import java.util.Objects;

public class Persona extends Vertice {
	private String nombre;

	private int interesDeportes;
	private int interesEspectaculos;
	private int interesCiencia;
	private int interesMusica;

	public Persona(String nombre, int interesDeportes, int interesEspectaculos, int interesCiencia, int interesMusica) {
		super();
		this.nombre = nombre;

		this.interesDeportes = interesDeportes;
		this.interesEspectaculos = interesEspectaculos;
		this.interesCiencia = interesCiencia;
		this.interesMusica = interesMusica;
	}

	public Persona() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();

		result = prime * result
				+ Objects.hash(interesCiencia, interesDeportes, interesEspectaculos, interesMusica, nombre);
		return result;
	}
}