package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BFS<T> {
	private Grafo<T> grafo;
	private ArrayList<Vertice<T>> listaPendientes;
	private ArrayList<Vertice<T>> visitados;

	public BFS(Grafo<T> grafo) {
		this.grafo = grafo;
		this.listaPendientes = new ArrayList<>();
		this.visitados = new ArrayList<>();
	}

	public List<Vertice<T>> bfs(Vertice<T> vertice) {
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

	public List<Vertice<T>> dfs(Vertice<T> vertice) {
		listaPendientes.add(vertice);

		while (!listaPendientes.isEmpty()) {
			Vertice<T> actual = listaPendientes.get(listaPendientes.size() - 1);

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

	public boolean esConexo(Vertice<T> verticeA) {
		this.listaPendientes = new ArrayList<>();
		this.visitados = new ArrayList<>();

		return grafo.tamanio() == bfs(verticeA).size();
	}

	public boolean esConexoDfs(Vertice<T> verticeA) {
		this.listaPendientes = new ArrayList<>();
		this.visitados = new ArrayList<>();

		return grafo.tamanio() == dfs(verticeA).size();
	}
}
