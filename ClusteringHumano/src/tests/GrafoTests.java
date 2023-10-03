package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Grafo;
import modelo.Vertice;

public class GrafoTests {

	@Test
	public void agregarVerticeTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice = new Vertice<Integer>();

		grafo.agregarVertice(vertice);

		assertTrue(grafo.tamanio() == 1);
	}

	@Test
	public void agregarAristaTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();
		Vertice<Integer> verticeB = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);
		grafo.agregarVertice(verticeB);

		grafo.agregarArista(verticeA, verticeB);

		assertTrue(grafo.getVecinos(verticeA).contains(verticeB));
		assertTrue(grafo.getVecinos(verticeB).contains(verticeA));
	}

	@Test
	public void noSeAgreganVerticesDuplicadosTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);
		grafo.agregarVertice(verticeA);

		assertTrue(grafo.tamanio() == 1);
	}

	@Test
	public void noSeAgreganVecinosDuplicadosTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();
		Vertice<Integer> verticeB = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);
		grafo.agregarVertice(verticeB);

		grafo.agregarArista(verticeA, verticeB);
		grafo.agregarArista(verticeA, verticeB);

		assertTrue(grafo.getCantidadVecinos(verticeA) == 1);
		assertTrue(grafo.getCantidadVecinos(verticeB) == 1);
	}

	@Test
	public void eliminarVerticeTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);
		grafo.eliminarVertice(verticeA);

		assertTrue(grafo.tamanio() == 0);
	}

	@Test
	public void eliminarVerticeDeListasDeVecinosTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();
		Vertice<Integer> verticeB = new Vertice<Integer>();
		Vertice<Integer> verticeC = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);
		grafo.agregarVertice(verticeB);
		grafo.agregarVertice(verticeC);

		grafo.agregarArista(verticeA, verticeB);
		grafo.agregarArista(verticeA, verticeC);

		grafo.eliminarVertice(verticeA);

		assertTrue(grafo.tamanio() == 2);

		assertTrue(grafo.getCantidadVecinos(verticeB) == 0);
		assertTrue(grafo.getCantidadVecinos(verticeC) == 0);
	}
}
