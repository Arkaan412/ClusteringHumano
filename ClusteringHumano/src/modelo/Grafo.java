package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Grafo<T> {
	private HashMap<Vertice<T>, HashSet<Vertice<T>>> vertices;
	private HashSet<Arista<T>> aristas;

	public Grafo() {
		vertices = new HashMap<Vertice<T>, HashSet<Vertice<T>>>();
		aristas = new HashSet<Arista<T>>();
	}

	public void agregarVertice(Vertice<T> vertice) {
		HashSet<Vertice<T>> listaVecinos = new HashSet<Vertice<T>>();

		vertices.putIfAbsent(vertice, listaVecinos);
	}

	public void agregarArista(Vertice<T> verticeA, Vertice<T> verticeB) {
		crearArista(verticeA, verticeB, 0);
	}

	public void agregarArista(Vertice<T> verticeA, Vertice<T> verticeB, int cargaArista) {
		crearArista(verticeA, verticeB, cargaArista);
	}

	private void crearArista(Vertice<T> verticeA, Vertice<T> verticeB, int cargaArista) {
		if (!existeVertice(verticeA))
			throw new IllegalArgumentException("El vértice A indicado no pertenece al grafo.");
		if (!existeVertice(verticeB))
			throw new IllegalArgumentException("El vértice B indicado no pertenece al grafo.");

		agregarVecino(verticeA, verticeB);

		Arista<T> nuevaArista = new Arista<>(verticeA, verticeB, cargaArista);
		aristas.add(nuevaArista);
	}

	private void agregarVecino(Vertice<T> verticeA, Vertice<T> verticeB) {
		if (sonElMismoVertice(verticeA, verticeB))
			throw new IllegalArgumentException("Los vértices indicados son el mismo vértice. No se admiten ciclos.");

		HashSet<Vertice<T>> listaVecinosA = vertices.get(verticeA);
		HashSet<Vertice<T>> listaVecinosB = vertices.get(verticeB);

		listaVecinosA.add(verticeB);
		listaVecinosB.add(verticeA);
	}

	public boolean sonElMismoVertice(Vertice<T> verticeA, Vertice<T> verticeB) {
		return verticeA.equals(verticeB);
	}

	public Set<Vertice<T>> obtenerVecinos(Vertice<T> vertice) {
		if (!existeVertice(vertice))
			throw new IllegalArgumentException("El vértice indicado no pertenece al grafo.");

		HashSet<Vertice<T>> listaVecinos = vertices.get(vertice);

		return listaVecinos;
	}

	public Set<Arista<T>> obtenerAristas() {
		return aristas;
	}

	public int tamanio() {
		return vertices.size();
	}

	public boolean estaVacio() {
		return this.tamanio() == 0;
	}

	public boolean noTieneVecinos(Vertice<T> vertice) {
		return obtenerCantidadVecinos(vertice) == 0;
	}

	public int obtenerCantidadVecinos(Vertice<T> vertice) {
		if (!existeVertice(vertice))
			throw new IllegalArgumentException("El vértice indicado no pertenece al grafo.");

		return obtenerVecinos(vertice).size();
	}

	public void eliminarVertice(Vertice<T> vertice) {
		if (existeVertice(vertice)) {
			vertices.remove(vertice);

			eliminarVerticeDeListasDeVecinos(vertice);
		}
	}

	private void eliminarVerticeDeListasDeVecinos(Vertice<T> verticeAEliminar) {
		Set<Vertice<T>> conjuntoVertices = vertices.keySet();

		for (Vertice<T> verticeActual : conjuntoVertices) {
			obtenerVecinos(verticeActual).remove(verticeAEliminar);
		}
	}

	public boolean sonVecinos(Vertice<T> verticeA, Vertice<T> verticeB) {
		if (!existeVertice(verticeA) || !existeVertice(verticeB))
			return false;

		boolean BEsVecinoDeA = obtenerVecinos(verticeA).contains(verticeB);
		boolean AEsVecinoDeB = obtenerVecinos(verticeB).contains(verticeA);

		return BEsVecinoDeA && AEsVecinoDeB;
	}

	private boolean existeVertice(Vertice<T> vertice) {
		return vertices.containsKey(vertice);
	}

	public List<Vertice<T>> obtenerVertices() {
		return new ArrayList<Vertice<T>>(vertices.keySet());
	}

	public Arista<T> obtenerAristaMinima() {
		Iterator<Arista<T>> iterador = aristas.iterator();

		Arista<T> aristaMinima = iterador.next();
		int cargaAristaMinima = aristaMinima.getCarga();

		while (iterador.hasNext()) {
			Arista<T> aristaActual = iterador.next();
			int cargaAristaActual = aristaActual.getCarga();

			if (cargaAristaActual < cargaAristaMinima) {
				aristaMinima = aristaActual;
				cargaAristaMinima = cargaAristaActual;
			}
		}
		return aristaMinima;
	}

	public void formarGrafoAPartirDeAristas(Set<Arista<T>> aristas) {
		for (Arista<T> aristaActual : aristas) {
			Vertice<T> verticeA = aristaActual.getVerticeA();
			Vertice<T> verticeB = aristaActual.getVerticeB();

			agregarVecino(verticeA, verticeB);
		}
	}
	
	public boolean esConexo() {
		if (estaVacio())
			return false;

		int cantidadDeVerticesVisitados = BFS.bfs(this).size();

		return this.tamanio() == cantidadDeVerticesVisitados;
	}

	public boolean esConexo(Vertice<T> verticeA) {
		int cantidadDeVerticesVisitados = BFS.bfs(this, verticeA).size();

		return this.tamanio() == cantidadDeVerticesVisitados;
	}

	public boolean sonAlcanzablesEntreSi(Vertice<T> verticeA, Vertice<T> verticeB) {
		List<Vertice<T>> verticesVisitados = BFS.bfs(this, verticeA);

		return verticesVisitados.contains(verticeB);
	}
	
	public boolean esArbol() {
		int cantidadVertices = tamanio();
		int cantidadAristas = aristas.size();
		
		boolean esArbol = esConexo() && cantidadAristas == cantidadVertices - 1; 
		
		return esArbol;
	}
}