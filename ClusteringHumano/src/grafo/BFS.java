package grafo;

import java.util.ArrayList;
import java.util.List;

public class BFS {

	public static <T> List<Vertice<T>> bfs(Grafo<T> grafo) {
		List<Vertice<T>> verticesVisitados = new ArrayList<>();
		
		if (grafo.estaVacio())
			return verticesVisitados;
		
		Vertice<T> vertice = grafo.obtenerVertices().get(0);

		verticesVisitados = bfs(grafo, vertice);

		return verticesVisitados;
	}

	public static <T> List<Vertice<T>> bfs(Grafo<T> grafo, Vertice<T> vertice) {
		ArrayList<Vertice<T>> listaPendientes = new ArrayList<>();
		ArrayList<Vertice<T>> verticesVisitados = new ArrayList<>();

		listaPendientes.add(vertice);

		while (!listaPendientes.isEmpty()) {
			Vertice<T> actual = listaPendientes.get(0);

			verticesVisitados.add(actual);

			List<Vertice<T>> listaVecinos = grafo.obtenerVecinos(actual);

			for (Vertice<T> vecinoActual : listaVecinos) {
				boolean vecinoaActualNoFueVisitado = !verticesVisitados.contains(vecinoActual);
				boolean vecinoaActualNoEstaEnPendientes = !listaPendientes.contains(vecinoActual);

				if (vecinoaActualNoFueVisitado && vecinoaActualNoEstaEnPendientes) {
					listaPendientes.add(vecinoActual);
				}
			}

			listaPendientes.remove(0);
		}

		return verticesVisitados;
	}
}