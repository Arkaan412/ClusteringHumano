package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import grafo.Grafo;
import grafo.Kruskal;
import grafo.Vertice;

class KruskalTest {
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
	void generarAgmTest() {
		Grafo<Integer> grafo = new Grafo<>();
//		Kruskal<Integer> agm = new Kruskal<>(grafo);
		
	}

}