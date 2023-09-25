package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Vertice {
	private static int siguienteID = 1;

	private int id;
	private HashSet<Vertice> vecinos;

	public Vertice() {
		vecinos = new HashSet<Vertice>();

		id = siguienteID;

		siguienteID++;
	}

	public void agregarVecino(Vertice vecino) {
		vecinos.add(vecino);

		vecino.obtenerVecinos().add(this);
	}

	public void eliminarVecino(Vertice vecino) {
		vecinos.remove(vecino);

		vecino.obtenerVecinos().remove(this);
	}

	public boolean esVecinoDe(Vertice vecino) {
		return vecinos.contains(vecino);
	}

	public Set<Vertice> obtenerVecinos() {
		return vecinos;
	}

	public int obtenerCantidadDeVecinos() {
		return vecinos.size();
	}

	public int obtenerId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Vertice))
			return false;

		Vertice other = (Vertice) obj;

		return id == other.id;
	}
}
