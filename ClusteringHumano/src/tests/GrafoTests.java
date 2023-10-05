package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import modelo.Grafo;
import modelo.Vertice;

class GrafoTests {

	@Test
	public void grafoVacioAlPrincipioTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		assertTrue(grafo.estaVacio());
	}

	@Test
	public void agregarVerticeTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice = new Vertice<Integer>();

		grafo.agregarVertice(vertice);

		assertTrue(grafo.tamanio() == 1);
	}

	@Test
	public void verticeSinVecinosAlPrincipioTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice = new Vertice<Integer>();

		grafo.agregarVertice(vertice);

		assertTrue(grafo.noTieneVecinos(vertice));
	}

	@Test
	public void verticeNoPuedeSerVecinoDeSiMismoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);

		assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(verticeA, verticeA));
	}

	@Test
	public void tieneVecinosTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();
		Vertice<Integer> verticeB = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);
		grafo.agregarVertice(verticeB);

		grafo.agregarArista(verticeA, verticeB);

		assertFalse(grafo.noTieneVecinos(verticeA));
		assertFalse(grafo.noTieneVecinos(verticeB));
	}

	@Test
	public void agregarAristaTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();
		Vertice<Integer> verticeB = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);
		grafo.agregarVertice(verticeB);

		grafo.agregarArista(verticeA, verticeB);

		assertTrue(grafo.sonVecinos(verticeA, verticeB));
		assertTrue(grafo.sonVecinos(verticeB, verticeA));
	}

	@Test
	public void agregarVariasAristasTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();
		Vertice<Integer> verticeB = new Vertice<Integer>();
		Vertice<Integer> verticeC = new Vertice<Integer>();
		Vertice<Integer> verticeD = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);
		grafo.agregarVertice(verticeB);
		grafo.agregarVertice(verticeC);
		grafo.agregarVertice(verticeD);

		grafo.agregarArista(verticeA, verticeB);
		grafo.agregarArista(verticeA, verticeC);
		grafo.agregarArista(verticeA, verticeD);

		assertTrue(grafo.sonVecinos(verticeA, verticeB));
		assertTrue(grafo.sonVecinos(verticeA, verticeC));
		assertTrue(grafo.sonVecinos(verticeA, verticeD));
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

		assertTrue(grafo.obtenerCantidadVecinos(verticeA) == 1);
		assertTrue(grafo.obtenerCantidadVecinos(verticeB) == 1);
	}

	@Test
	public void noSeAgreganVecinosDuplicadosConAristaInvertidaTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> verticeA = new Vertice<Integer>();
		Vertice<Integer> verticeB = new Vertice<Integer>();

		grafo.agregarVertice(verticeA);
		grafo.agregarVertice(verticeB);

		grafo.agregarArista(verticeA, verticeB);
		grafo.agregarArista(verticeB, verticeA);

		assertTrue(grafo.obtenerCantidadVecinos(verticeA) == 1);
		assertTrue(grafo.obtenerCantidadVecinos(verticeB) == 1);
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

		assertFalse(grafo.sonVecinos(verticeA, verticeB));
		assertFalse(grafo.sonVecinos(verticeA, verticeC));
	}

}