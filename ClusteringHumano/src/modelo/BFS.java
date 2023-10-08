package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BFS {

	public static <T> List<Vertice<T>> bfs(Grafo<T> grafo) {
		Vertice<T> vertice = grafo.obtenerVertices().get(0);

		List<Vertice<T>> verticesVisitados = bfs(grafo, vertice);

		return verticesVisitados;
	}

	public static <T> List<Vertice<T>> bfs(Grafo<T> grafo, Vertice<T> vertice) {
		ArrayList<Vertice<T>> listaPendientes = new ArrayList<>();
		ArrayList<Vertice<T>> visitados = new ArrayList<>();

		listaPendientes.add(vertice);

		while (!listaPendientes.isEmpty()) {
			Vertice<T> actual = listaPendientes.get(0);

			visitados.add(actual);

			Set<Vertice<T>> listaVecinos = grafo.obtenerVecinos(actual);

			for (Vertice<T> vecinoActual : listaVecinos) {
				boolean vecinoaActualNoFueVisitado = !visitados.contains(vecinoActual);
				boolean vecinoaActualNoEstaEnPendientes = !listaPendientes.contains(vecinoActual);

				if (vecinoaActualNoFueVisitado && vecinoaActualNoEstaEnPendientes) {
					listaPendientes.add(vecinoActual);
				}
			}

			listaPendientes.remove(0);
		}

		return visitados;
	}
}
