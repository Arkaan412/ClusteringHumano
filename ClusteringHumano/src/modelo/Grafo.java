package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	private ArrayList<Vertice> vertices;
	private HashSet<Arista> aristas;

	public Grafo() {
		vertices = new ArrayList<Vertice>();
		aristas = new HashSet<Arista>();
	}

	public void agregarVertice(Vertice vertice) {
		vertices.add(vertice);
	}

	private Vertice obtenerVertice(int posicion) {
		return vertices.get(posicion);
	}

	private List<Vertice> obtenerVertices() {
		return vertices;
	}

	private void eliminarVertice(int posicion) {
		vertices.remove(posicion);
	}

	public void agregarArista(int posicionVerticeA, int posicionVerticeB) {
		Vertice verticeA = obtenerVertice(posicionVerticeA);
		Vertice verticeB = obtenerVertice(posicionVerticeB);

		verificarLoop(verticeA, verticeB);

		verticeA.agregarVecino(verticeB);
		verticeB.agregarVecino(verticeA);

		// agregar arista
	}

	public void eliminarArista(int posicionVerticeA, int posicionVerticeB) {
		Vertice verticeA = obtenerVertice(posicionVerticeA);
		Vertice verticeB = obtenerVertice(posicionVerticeB);

		verticeA.eliminarVecino(verticeB);
		verticeB.eliminarVecino(verticeA);

		// eliminar arista
	}

	public boolean sonVecinos(int posicionVerticeA, int posicionVerticeB) {
		Vertice verticeA = obtenerVertice(posicionVerticeA);
		Vertice verticeB = obtenerVertice(posicionVerticeB);

		return verticeA.esVecinoDe(verticeB);
	}

	public Set<Vertice> obtenerVecinosDe(int posicionVertice) {
		Vertice vertice = obtenerVertice(posicionVertice);

		return vertice.obtenerVecinos();
	}

	public int obtenerCantidadDeVecinosDe(int posicionVertice) {
		Vertice vertice = obtenerVertice(posicionVertice);

		return vertice.obtenerCantidadDeVecinos();
	}

	private void verificarLoop(Vertice verticeA, Vertice verticeB) {
		if (verticeA.equals(verticeB))
			throw new IllegalArgumentException("No se admiten loops. Un vértice no puede ser vecino de sí mismo.");
	}
}