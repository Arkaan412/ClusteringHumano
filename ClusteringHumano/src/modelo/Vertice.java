package modelo;

import java.util.HashSet;

public class Vertice {
	private Persona persona;
	private HashSet<Vertice> vecinos;

	public Vertice(Persona persona) {
		this.persona = persona;
	}

	public Vertice() {
	}
}
