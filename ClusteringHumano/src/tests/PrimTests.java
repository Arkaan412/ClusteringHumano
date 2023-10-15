package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import grafo.Arista;
import grafo.Grafo;
import grafo.Prim;
import grafo.Vertice;

class PrimTests {
	private static Grafo<Integer> grafo;

	private static Prim<Integer> prim;

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

		prim = new Prim<Integer>(grafo);

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

		prim = new Prim<Integer>(grafo);
	}

	@Test
	void generarAGMEnGrafoVacioTest() {
		assertThrows(IllegalArgumentException.class, () -> prim.generarAGM());
	}

	@Test
	void generarAGMEnGrafoNoConexoTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);
		
		Arista<Integer> arista01 = new Arista<>(vertice0, vertice1, 6);
		Arista<Integer> arista02 = new Arista<>(vertice0, vertice2, 5);
		Arista<Integer> arista03 = new Arista<>(vertice0, vertice3, 3);
		Arista<Integer> arista12 = new Arista<>(vertice1, vertice2, 7);
		Arista<Integer> arista13 = new Arista<>(vertice1, vertice3, 5);
		Arista<Integer> arista23 = new Arista<>(vertice2, vertice3, 5);
		
		grafo.agregarArista(arista01);
		grafo.agregarArista(arista02);
		grafo.agregarArista(arista03);
		grafo.agregarArista(arista12);
		grafo.agregarArista(arista13);
		grafo.agregarArista(arista23);
		
		assertThrows(IllegalArgumentException.class, () -> prim.generarAGM());
	}
	
	@Test
	void asdTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);

		Arista<Integer> arista01 = new Arista<>(vertice0, vertice1, 0);
		Arista<Integer> arista12 = new Arista<>(vertice1, vertice2, 20);
		Arista<Integer> arista13 = new Arista<>(vertice1, vertice3, 20);
		Arista<Integer> arista23 = new Arista<>(vertice2, vertice3, 0);
		Arista<Integer> arista03 = new Arista<>(vertice0, vertice3, 20);
		Arista<Integer> arista02 = new Arista<>(vertice0, vertice2, 20);

		grafo.agregarArista(arista01);
		grafo.agregarArista(arista12);
		grafo.agregarArista(arista13);
		grafo.agregarArista(arista23);
		grafo.agregarArista(arista03);
		grafo.agregarArista(arista02);

//		List<Arista<Integer>> aristasEsperadas = new ArrayList<>();
//
//		aristasEsperadas.add(arista04);
//		aristasEsperadas.add(arista34);
//		aristasEsperadas.add(arista13);
//		aristasEsperadas.add(arista02);

		prim.generarAGM();

		Grafo<Integer> agm = prim.obtenerAGM();

		System.out.println(agm.obtenerAristas());
//		List<Arista<Integer>> aristasObtenidas = agm.obtenerAristas();

//		Asserts.compararColecciones(aristasEsperadas, aristasObtenidas);
		
		assertTrue(agm.esConexo());
		assertTrue(agm.esArbol());
	}

	@Test
	void generarAGMTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);

		Arista<Integer> arista01 = new Arista<>(vertice0, vertice1, 6);
		Arista<Integer> arista02 = new Arista<>(vertice0, vertice2, 5);
		Arista<Integer> arista04 = new Arista<>(vertice0, vertice4, 3);
		Arista<Integer> arista12 = new Arista<>(vertice1, vertice2, 7);
		Arista<Integer> arista13 = new Arista<>(vertice1, vertice3, 5);
		Arista<Integer> arista14 = new Arista<>(vertice1, vertice4, 1);
		Arista<Integer> arista34 = new Arista<>(vertice3, vertice4, 2);

		grafo.agregarArista(arista01);
		grafo.agregarArista(arista02);
		grafo.agregarArista(arista04);
		grafo.agregarArista(arista12);
		grafo.agregarArista(arista13);
		grafo.agregarArista(arista14);
		grafo.agregarArista(arista34);

		List<Arista<Integer>> aristasEsperadas = new ArrayList<>();

		aristasEsperadas.add(arista04);
		aristasEsperadas.add(arista34);
		aristasEsperadas.add(arista13);
		aristasEsperadas.add(arista02);

		prim.generarAGM();

		Grafo<Integer> agm = prim.obtenerAGM();

		List<Arista<Integer>> aristasObtenidas = agm.obtenerAristas();

		Asserts.compararColecciones(aristasEsperadas, aristasObtenidas);
	}

	@Test
	void generarAGMEnGrafoCompletoTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);

		Arista<Integer> arista01 = new Arista<>(vertice0, vertice1, 1);
		Arista<Integer> arista02 = new Arista<>(vertice0, vertice2, 2);
		Arista<Integer> arista03 = new Arista<>(vertice0, vertice3, 3);
		Arista<Integer> arista12 = new Arista<>(vertice1, vertice2, 5);
		Arista<Integer> arista13 = new Arista<>(vertice1, vertice3, 4);
		Arista<Integer> arista23 = new Arista<>(vertice2, vertice3, 5);

		grafo.agregarArista(arista01);
		grafo.agregarArista(arista02);
		grafo.agregarArista(arista03);
		grafo.agregarArista(arista12);
		grafo.agregarArista(arista13);
		grafo.agregarArista(arista23);

		List<Arista<Integer>> aristasEsperadas = new ArrayList<>();

		aristasEsperadas.add(arista01);
		aristasEsperadas.add(arista02);
		aristasEsperadas.add(arista03);
		aristasEsperadas.add(arista12);
		aristasEsperadas.add(arista13);
		aristasEsperadas.add(arista23);

		prim.generarAGM();

		Grafo<Integer> agm = prim.obtenerAGM();

		List<Arista<Integer>> aristasObtenidas = agm.obtenerAristas();

		Asserts.compararColecciones(aristasEsperadas, aristasObtenidas);
	}

	@Test
	void generarAGMEnGrafoConTodasSusAristasDeIgualCargaTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);

		Arista<Integer> arista01 = new Arista<>(vertice0, vertice1, 1);
		Arista<Integer> arista02 = new Arista<>(vertice0, vertice2, 1);
		Arista<Integer> arista04 = new Arista<>(vertice0, vertice4, 1);
		Arista<Integer> arista12 = new Arista<>(vertice1, vertice2, 1);
		Arista<Integer> arista13 = new Arista<>(vertice1, vertice3, 1);
		Arista<Integer> arista14 = new Arista<>(vertice1, vertice4, 1);
		Arista<Integer> arista34 = new Arista<>(vertice3, vertice4, 1);

		grafo.agregarArista(arista01);
		grafo.agregarArista(arista02);
		grafo.agregarArista(arista04);
		grafo.agregarArista(arista12);
		grafo.agregarArista(arista13);
		grafo.agregarArista(arista14);
		grafo.agregarArista(arista34);

		prim.generarAGM();

		Grafo<Integer> agm = prim.obtenerAGM();

		assertTrue(agm.esArbol());
	}

	@Test
	void generarAGMEnGrafoCompletoConTodasSusAristasDeIgualCargaTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);

		Arista<Integer> arista01 = new Arista<>(vertice0, vertice1, 1);
		Arista<Integer> arista02 = new Arista<>(vertice0, vertice2, 1);
		Arista<Integer> arista03 = new Arista<>(vertice0, vertice3, 1);
		Arista<Integer> arista04 = new Arista<>(vertice0, vertice4, 1);
		Arista<Integer> arista12 = new Arista<>(vertice1, vertice2, 1);
		Arista<Integer> arista13 = new Arista<>(vertice1, vertice3, 1);
		Arista<Integer> arista14 = new Arista<>(vertice1, vertice4, 1);
		Arista<Integer> arista23 = new Arista<>(vertice2, vertice3, 1);
		Arista<Integer> arista24 = new Arista<>(vertice2, vertice4, 1);
		Arista<Integer> arista34 = new Arista<>(vertice3, vertice4, 1);

		grafo.agregarArista(arista01);
		grafo.agregarArista(arista02);
		grafo.agregarArista(arista03);
		grafo.agregarArista(arista04);
		grafo.agregarArista(arista12);
		grafo.agregarArista(arista13);
		grafo.agregarArista(arista14);
		grafo.agregarArista(arista23);
		grafo.agregarArista(arista24);
		grafo.agregarArista(arista34);

		prim.generarAGM();

		Grafo<Integer> agm = prim.obtenerAGM();

		assertTrue(agm.esArbol());
	}

	@Test
	void generarAGMEnArbolTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);

		Arista<Integer> arista01 = new Arista<>(vertice0, vertice1, 1);
		Arista<Integer> arista02 = new Arista<>(vertice0, vertice2, 2);
		Arista<Integer> arista03 = new Arista<>(vertice0, vertice3, 3);
		Arista<Integer> arista34 = new Arista<>(vertice3, vertice4, 3);

		grafo.agregarArista(arista01);
		grafo.agregarArista(arista02);
		grafo.agregarArista(arista03);
		grafo.agregarArista(arista34);

		List<Arista<Integer>> aristasEsperadas = new ArrayList<>();

		aristasEsperadas.add(arista01);
		aristasEsperadas.add(arista02);
		aristasEsperadas.add(arista03);
		aristasEsperadas.add(arista34);

		prim.generarAGM();

		Grafo<Integer> agm = prim.obtenerAGM();

		List<Arista<Integer>> aristasObtenidas = agm.obtenerAristas();

		Asserts.compararColecciones(aristasEsperadas, aristasObtenidas);
	}

	@Test
	void generarAGMEnArbolConTodasSusAristasDeIgualCargaTest() {
		grafo.agregarVertice(vertice0);
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);

		Arista<Integer> arista01 = new Arista<>(vertice0, vertice1, 1);
		Arista<Integer> arista02 = new Arista<>(vertice0, vertice2, 1);
		Arista<Integer> arista03 = new Arista<>(vertice0, vertice3, 1);
		Arista<Integer> arista34 = new Arista<>(vertice3, vertice4, 1);

		grafo.agregarArista(arista01);
		grafo.agregarArista(arista02);
		grafo.agregarArista(arista03);
		grafo.agregarArista(arista34);

		List<Arista<Integer>> aristasEsperadas = new ArrayList<>();

		aristasEsperadas.add(arista01);
		aristasEsperadas.add(arista02);
		aristasEsperadas.add(arista03);
		aristasEsperadas.add(arista34);

		prim.generarAGM();

		Grafo<Integer> agm = prim.obtenerAGM();

		List<Arista<Integer>> aristasObtenidas = agm.obtenerAristas();

		Asserts.compararColecciones(aristasEsperadas, aristasObtenidas);
	}
}