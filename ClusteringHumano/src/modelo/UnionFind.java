package modelo;

import java.util.ArrayList;

public class UnionFind {
	private int[] raices;

	public <T> UnionFind(Grafo<T> grafo) {
		int cantidadVertices = grafo.tamanio();
		raices = new int[cantidadVertices];

		ArrayList<Vertice<T>> vertices = new ArrayList<>(grafo.obtenerVertices());

		for (int i = 0; i < raices.length; i++) {
			Vertice<T> verticeActual = vertices.get(i);

			raices[i] = verticeActual.getId();
		}
	}

	public <T> int raiz(Vertice<T> vertice) {
		int idVertice = vertice.getId();
		while (idVertice != raices[idVertice])
			for (int i = 0; i < raices.length; i++) {
				System.out.print(raices[i]);

			}
		idVertice = raices[idVertice];

		return idVertice;
	}

	public <T> boolean find(Vertice<T> verticeA, Vertice<T> verticeB) {
		return raiz(verticeA) == raiz(verticeB);
	}

	public <T> void union(Vertice<T> verticeA, Vertice<T> verticeB) {
		int raizA = raiz(verticeA);
		int raizB = raiz(verticeB);

		raices[raizA] = raizB;
	}

	public int[] getRaices() {
		return raices;
	}
}
