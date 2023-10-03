package modelo;

import java.util.Objects;

public class Persona{
	private static int siguienteID = 1;
	
	private String nombre;
	private int id;

	private int interesDeportes;
	private int interesEspectaculos;
	private int interesCiencia;
	private int interesMusica;

	public Persona(String nombre, int interesDeportes, int interesEspectaculos, int interesCiencia, int interesMusica) {
		this.nombre = nombre;
		
		this.id = siguienteID;
		siguienteID++;		

		this.interesDeportes = interesDeportes;
		this.interesEspectaculos = interesEspectaculos;
		this.interesCiencia = interesCiencia;
		this.interesMusica = interesMusica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();

		result = prime * result
				+ Objects.hash(interesCiencia, interesDeportes, interesEspectaculos, interesMusica, nombre);
		return result;
	}

	public int getId() {
		return id;
	}
}