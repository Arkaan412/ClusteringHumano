package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.BFS;
import modelo.Grafo;
import modelo.Vertice;

class BFSTests {

	@Test
	void bfsEnVerticeQueNoPerrteneceAlGrafoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();

		assertThrows(IllegalArgumentException.class, () -> BFS.bfs(grafo, vertice1));
	}
	
	@Test
	void bfsEnGrafoConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		Vertice<Integer> vertice3 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice1, vertice3);
		grafo.agregarArista(vertice2, vertice3);

		ArrayList<Vertice<Integer>> verticesVisitadosEsperados = new ArrayList<Vertice<Integer>>();

		verticesVisitadosEsperados.add(vertice1);
		verticesVisitadosEsperados.add(vertice2);
		verticesVisitadosEsperados.add(vertice3);

		List<Vertice<Integer>> verticesVisitados = BFS.bfs(grafo, vertice1);

		boolean sonIguales = Asserts.compararColecciones(verticesVisitados, verticesVisitadosEsperados);

		assertTrue(sonIguales);
	}

	@Test
	void bfsEnGrafoNoConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		Vertice<Integer> vertice3 = new Vertice<Integer>();
		Vertice<Integer> vertice4 = new Vertice<Integer>();
		Vertice<Integer> vertice5 = new Vertice<Integer>();
		Vertice<Integer> vertice6 = new Vertice<Integer>();
		Vertice<Integer> vertice7 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);
		grafo.agregarVertice(vertice5);
		grafo.agregarVertice(vertice6);
		grafo.agregarVertice(vertice7);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice1, vertice3);
		grafo.agregarArista(vertice2, vertice3);
		grafo.agregarArista(vertice2, vertice4);
		grafo.agregarArista(vertice3, vertice5);
		grafo.agregarArista(vertice4, vertice5);
		grafo.agregarArista(vertice6, vertice7);

		ArrayList<Vertice<Integer>> verticesVisitadosEsperados = new ArrayList<Vertice<Integer>>();

		verticesVisitadosEsperados.add(vertice1);
		verticesVisitadosEsperados.add(vertice2);
		verticesVisitadosEsperados.add(vertice3);
		verticesVisitadosEsperados.add(vertice4);
		verticesVisitadosEsperados.add(vertice5);

		List<Vertice<Integer>> verticesVisitados = BFS.bfs(grafo, vertice1);

		boolean sonIguales = Asserts.compararColecciones(verticesVisitados, verticesVisitadosEsperados);

		assertTrue(sonIguales);
	}
}
