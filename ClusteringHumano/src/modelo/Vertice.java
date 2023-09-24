package modelo;

import java.util.HashSet;
import java.util.Set;

public abstract class Vertice {
	private HashSet<Vertice> vecinos;

	public Vertice() {
		vecinos = new HashSet<Vertice>();
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

	private void verificarLoop(Vertice vecino) {
		if (this.equals(vecino))
			throw new IllegalArgumentException("No se admiten loops. Un vértice no puede ser vecino de sí mismo.");
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(vecinos);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Vertice)) {
//			return false;
//		}
//		Vertice other = (Vertice) obj;
//		return Objects.equals(vecinos, other.vecinos);
//	}
}
