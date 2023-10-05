package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.BFS;
import modelo.Grafo;
import modelo.Vertice;

class BFSTests {

	@Test
	void grafoConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		BFS<Integer> bfs = new BFS<>(grafo);

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		Vertice<Integer> vertice3 = new Vertice<Integer>();
		Vertice<Integer> vertice4 = new Vertice<Integer>();
		Vertice<Integer> vertice5 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);
		grafo.agregarVertice(vertice5);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice1, vertice3);
		grafo.agregarArista(vertice2, vertice3);
		grafo.agregarArista(vertice2, vertice4);
		grafo.agregarArista(vertice3, vertice5);
		grafo.agregarArista(vertice4, vertice5);

		assertTrue(bfs.esConexo(vertice1));
	}

	@Test
	void grafoConexoDesdeTodosLosVerticesTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		BFS<Integer> bfs = new BFS<>(grafo);

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		Vertice<Integer> vertice3 = new Vertice<Integer>();
		Vertice<Integer> vertice4 = new Vertice<Integer>();
		Vertice<Integer> vertice5 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);
		grafo.agregarVertice(vertice5);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice1, vertice3);
		grafo.agregarArista(vertice2, vertice3);
		grafo.agregarArista(vertice2, vertice4);
		grafo.agregarArista(vertice3, vertice5);
		grafo.agregarArista(vertice4, vertice5);

		assertTrue(bfs.esConexo(vertice1));
		assertTrue(bfs.esConexo(vertice2));
		assertTrue(bfs.esConexo(vertice3));
		assertTrue(bfs.esConexo(vertice4));
		assertTrue(bfs.esConexo(vertice5));
	}

	@Test
	void grafoNoConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		BFS<Integer> bfs = new BFS<>(grafo);

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

		assertFalse(bfs.esConexo(vertice1));
	}

	@Test
	void grafoNoConexoDesdeTodosLosVerticesTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		BFS<Integer> bfs = new BFS<>(grafo);

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

		assertFalse(bfs.esConexo(vertice1));
		assertFalse(bfs.esConexo(vertice2));
		assertFalse(bfs.esConexo(vertice3));
		assertFalse(bfs.esConexo(vertice4));
		assertFalse(bfs.esConexo(vertice5));
		assertFalse(bfs.esConexo(vertice6));
		assertFalse(bfs.esConexo(vertice7));
	}
}
