package modelo;

import java.util.Objects;

public class Persona {
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

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, interesCiencia, interesDeportes, interesEspectaculos, interesMusica, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Persona)) {
			return false;
		}
		Persona other = (Persona) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", id=" + id + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public int getInteresDeportes() {
		return interesDeportes;
	}

	public int getInteresEspectaculos() {
		return interesEspectaculos;
	}

	public int getInteresCiencia() {
		return interesCiencia;
	}

	public int getInteresMusica() {
		return interesMusica;
	}
}