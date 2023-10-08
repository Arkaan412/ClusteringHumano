package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modelo.Grafo;
import modelo.Vertice;
import modelo.UnionFind;

class UnionFindTests {
	static Grafo<Integer> grafo;

	static Vertice<Integer> vertice0;
	static Vertice<Integer> vertice1;
	static Vertice<Integer> vertice2;

	@BeforeAll
	static void setUp() {
		grafo = new Grafo<>();

		vertice0 = new Vertice<>();
		vertice1 = new Vertice<>();
		vertice2 = new Vertice<>();
	}

	@AfterEach
	void tearDown() {
		grafo.eliminarVertice(vertice0);
		grafo.eliminarVertice(vertice1);
		grafo.eliminarVertice(vertice2);
	}

	@Test
	void inicializacionDeUnionFindTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		UnionFind unionFind = new UnionFind(grafo);

		int[] raicesEsperadas = { 0, 1, 2 };

		int[] raicesObtenidas = unionFind.getRaices();

		boolean sonIguales = Asserts.compararArreglos(raicesEsperadas, raicesObtenidas);

		assertTrue(sonIguales);
	}

	@Test
	void raicesEsperadasRepetidasTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		UnionFind unionFind = new UnionFind(grafo);

		int[] raicesEsperadas = { 0, 2, 2 };
		int[] raicesObtenidas = unionFind.getRaices();

		boolean sonIguales = Asserts.compararArreglos(raicesEsperadas, raicesObtenidas);

		assertFalse(sonIguales);
	}

	@Test
	void unionTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		grafo.agregarArista(vertice1, vertice2);

		UnionFind unionFind = new UnionFind(grafo);

		int[] raicesObtenidas = unionFind.getRaices();

		unionFind.union(vertice1, vertice2);

		int[] raicesEsperadas = { 0, 2, 2 };

		boolean sonIguales = Asserts.compararArreglos(raicesEsperadas, raicesObtenidas);

		assertTrue(sonIguales);
	}
}
