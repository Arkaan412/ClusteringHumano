package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import grafo.BFS;
import grafo.Grafo;
import grafo.Vertice;

class BFSTests {
	private static Grafo<Integer> grafo;

	private static Vertice<Integer> vertice0;
	private static Vertice<Integer> vertice1;
	private static Vertice<Integer> vertice2;
	private static Vertice<Integer> vertice3;
	private static Vertice<Integer> vertice4;
	private static Vertice<Integer> vertice5;
	private static Vertice<Integer> vertice6;

	@BeforeAll
	static void setUp() {
		grafo = new Grafo<Integer>();

		vertice0 = new Vertice<Integer>();
		vertice1 = new Vertice<Integer>();
		vertice2 = new Vertice<Integer>();
		vertice3 = new Vertice<Integer>();
		vertice4 = new Vertice<Integer>();
		vertice5 = new Vertice<Integer>();
		vertice6 = new Vertice<Integer>();
	}

	@AfterEach
	void tearDown() {
		grafo.eliminarVertice(vertice0);
		grafo.eliminarVertice(vertice1);
		grafo.eliminarVertice(vertice2);
		grafo.eliminarVertice(vertice3);
		grafo.eliminarVertice(vertice4);
		grafo.eliminarVertice(vertice5);
		grafo.eliminarVertice(vertice6);
	}
	
	@Test
	void bfsEnVerticeQueNoPerteneceAlGrafoTest() {
		assertThrows(IllegalArgumentException.class, () -> BFS.bfs(grafo, vertice0));
	}
	
	@Test
	void bfsEnGrafoVacioTest() {
		List<Vertice<Integer>> verticesVisitados = BFS.bfs(grafo);
		
		int cantidadDeVerticesVisitados = verticesVisitados.size();

		assertEquals(0, cantidadDeVerticesVisitados);
	}
	
	@Test
	void bfsEnGrafoDeUnVerticeTest() {
		grafo.agregarVertice(vertice0);

		ArrayList<Vertice<Integer>> verticesVisitadosEsperados = new ArrayList<Vertice<Integer>>();

		verticesVisitadosEsperados.add(vertice0);

		List<Vertice<Integer>> verticesVisitados = BFS.bfs(grafo, vertice0);

		boolean sonIguales = Asserts.compararColecciones(verticesVisitados, verticesVisitadosEsperados);

		assertTrue(sonIguales);
	}

	@Test
	void bfsEnGrafoConexoTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		grafo.agregarArista(vertice0, vertice1);
		grafo.agregarArista(vertice0, vertice2);
		grafo.agregarArista(vertice1, vertice2);

		ArrayList<Vertice<Integer>> verticesVisitadosEsperados = new ArrayList<Vertice<Integer>>();

		verticesVisitadosEsperados.add(vertice0);
		verticesVisitadosEsperados.add(vertice1);
		verticesVisitadosEsperados.add(vertice2);

		List<Vertice<Integer>> verticesVisitados = BFS.bfs(grafo, vertice0);

		boolean sonIguales = Asserts.compararColecciones(verticesVisitados, verticesVisitadosEsperados);

		assertTrue(sonIguales);
	}

	@Test
	void bfsEnGrafoNoConexoTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);
		grafo.agregarVertice(vertice5);
		grafo.agregarVertice(vertice6);

		grafo.agregarArista(vertice0, vertice1);
		grafo.agregarArista(vertice0, vertice2);
		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice1, vertice3);
		grafo.agregarArista(vertice2, vertice4);
		grafo.agregarArista(vertice3, vertice4);
		grafo.agregarArista(vertice5, vertice6);

		ArrayList<Vertice<Integer>> verticesVisitadosEsperados = new ArrayList<Vertice<Integer>>();

		verticesVisitadosEsperados.add(vertice0);
		verticesVisitadosEsperados.add(vertice1);
		verticesVisitadosEsperados.add(vertice2);
		verticesVisitadosEsperados.add(vertice3);
		verticesVisitadosEsperados.add(vertice4);

		List<Vertice<Integer>> verticesVisitados = BFS.bfs(grafo, vertice0);

		boolean sonIguales = Asserts.compararColecciones(verticesVisitados, verticesVisitadosEsperados);

		assertTrue(sonIguales);
	}
	
	@Test
	void bfsEnArbolTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		
		grafo.agregarArista(vertice0, vertice3);
		grafo.agregarArista(vertice1, vertice3);
		grafo.agregarArista(vertice2, vertice3);
		
		ArrayList<Vertice<Integer>> verticesVisitadosEsperados = new ArrayList<Vertice<Integer>>();
		
		verticesVisitadosEsperados.add(vertice0);
		verticesVisitadosEsperados.add(vertice1);
		verticesVisitadosEsperados.add(vertice2);
		verticesVisitadosEsperados.add(vertice3);
		
		List<Vertice<Integer>> verticesVisitados = BFS.bfs(grafo, vertice0);
		
		boolean sonIguales = Asserts.compararColecciones(verticesVisitados, verticesVisitadosEsperados);
		
		assertTrue(sonIguales);
	}
	
	@Test
	void bfsEnArbolSinArbolSinArista13Test() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);

		grafo.agregarArista(vertice0, vertice3);
		grafo.agregarArista(vertice2, vertice3);

		ArrayList<Vertice<Integer>> verticesVisitadosEsperados = new ArrayList<Vertice<Integer>>();

		verticesVisitadosEsperados.add(vertice0);
		verticesVisitadosEsperados.add(vertice2);
		verticesVisitadosEsperados.add(vertice3);

		List<Vertice<Integer>> verticesVisitados = BFS.bfs(grafo, vertice0);

		boolean sonIguales = Asserts.compararColecciones(verticesVisitados, verticesVisitadosEsperados);

		assertTrue(sonIguales);
	}
}
