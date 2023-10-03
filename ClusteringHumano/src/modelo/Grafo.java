package modelo;

import java.util.HashMap;
import java.util.HashSet;
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
		HashSet<Vertice<T>> listaVecinosA = vertices.get(verticeA);
		HashSet<Vertice<T>> listaVecinosB = vertices.get(verticeB);

		listaVecinosA.add(verticeB);
		listaVecinosB.add(verticeA);
	}

	public Set<Vertice<T>> getVecinos(Vertice<T> vertice) {
		HashSet<Vertice<T>> listaVecinos = vertices.get(vertice);

		return listaVecinos;
	}

	public Set<Arista<T>> getAristas() {
		return aristas;
	}

	public int tamanio() {
		return vertices.size();
	}

	public int getCantidadVecinos(Vertice<T> vertice) {
		return getVecinos(vertice).size();
	}

	public void eliminarVertice(Vertice<T> vertice) {
		vertices.remove(vertice);

		eliminarVerticeDeListasDeVecinos(vertice);
	}

	private void eliminarVerticeDeListasDeVecinos(Vertice<T> verticeAEliminar) {
		Set<Vertice<T>> conjuntoVertices = vertices.keySet();

		for (Vertice<T> verticeActual : conjuntoVertices) {
			getVecinos(verticeActual).remove(verticeAEliminar);
		}
	}
}