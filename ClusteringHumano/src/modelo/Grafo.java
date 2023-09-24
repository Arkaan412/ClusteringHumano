package modelo;

import java.util.ArrayList;
import java.util.HashSet;

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

	private ArrayList<Vertice> obtenerVertices() {
		return vertices;
	}

	private void eliminarVertice(int posicion) {
		vertices.remove(posicion);
	}
}
