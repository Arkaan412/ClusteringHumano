package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.Arista;
import modelo.Grafo;
import modelo.Vertice;

class GrafoTests {

	@Test
	void grafoVacioAlPrincipioTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		assertTrue(grafo.estaVacio());
	}

	@Test
	void verticeQueNoPerteneceAlGrafoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();

		assertThrows(IllegalArgumentException.class, () -> grafo.obtenerVecinos(vertice1));
	}

	@Test
	void agregarVerticeTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice = new Vertice<Integer>();

		grafo.agregarVertice(vertice);

		assertTrue(grafo.tamanio() == 1);
	}

	@Test
	void verticeSinVecinosAlPrincipioTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice = new Vertice<Integer>();

		grafo.agregarVertice(vertice);

		assertTrue(grafo.noTieneVecinos(vertice));
	}

	@Test
	void crearAristaConVerticeQueNoPerteneceAlGrafoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);

		assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(vertice1, vertice2));
	}

	@Test
	void verticeNoPuedeSerVecinoDeSiMismoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);

		assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(vertice1, vertice1));
	}

	@Test
	void agregarAristaTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		grafo.agregarArista(vertice1, vertice2);

		assertTrue(grafo.sonVecinos(vertice1, vertice2));
		assertTrue(grafo.sonVecinos(vertice2, vertice1));
	}

	@Test
	void agregarVariasAristasTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		Vertice<Integer> vertice3 = new Vertice<Integer>();
		Vertice<Integer> vertice4 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice1, vertice3);
		grafo.agregarArista(vertice1, vertice4);

		assertTrue(grafo.sonVecinos(vertice1, vertice2));
		assertTrue(grafo.sonVecinos(vertice1, vertice3));
		assertTrue(grafo.sonVecinos(vertice1, vertice4));
	}

	@Test
	void tieneVecinosCuandoSeAgregaAristaTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		grafo.agregarArista(vertice1, vertice2);

		assertFalse(grafo.noTieneVecinos(vertice1));
		assertFalse(grafo.noTieneVecinos(vertice2));
	}

	@Test
	void seCreaAristaTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();
		
		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		
		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice2, vertice1);
		grafo.agregarArista(vertice1, vertice2);

		assertTrue(grafo.obtenerAristas().size() == 1);	
	}
	
	@Test
	void aristaInstanciadaCorrectamenteTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		
		int cargaArista = 5;
		
		grafo.agregarArista(vertice1, vertice2, cargaArista);

		Arista<Integer> arista = grafo.obtenerAristas().get(0);
		
		Vertice<Integer> verticeA = arista.getVerticeA();
		Vertice<Integer> verticeB = arista.getVerticeB();
		
		assertTrue(verticeA.equals(vertice1));	
		assertTrue(verticeB.equals(vertice2));	
		assertTrue(arista.getCarga() == cargaArista);	
	}
	
	@Test
	void agregarAristasAPartirDeAristasYaInstanciadas() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		Vertice<Integer> vertice3 = new Vertice<Integer>();
		Vertice<Integer> vertice4 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);

		Arista<Integer> arista12 = new Arista<>(vertice1, vertice2);
		Arista<Integer> arista24 = new Arista<>(vertice2, vertice4);
		Arista<Integer> arista34 = new Arista<>(vertice3, vertice4);

		grafo.agregarArista(arista12);
		grafo.agregarArista(arista24);
		grafo.agregarArista(arista34);

		assertTrue(grafo.sonVecinos(vertice1, vertice2));
		assertTrue(grafo.sonVecinos(vertice2, vertice4));
		assertTrue(grafo.sonVecinos(vertice3, vertice4));
	}

	@Test
	void noSeAgreganVerticesDuplicadosTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice1);

		assertTrue(grafo.tamanio() == 1);
	}

	@Test
	void noSeAgreganVecinosDuplicadosTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice1, vertice2);

		assertTrue(grafo.obtenerCantidadVecinos(vertice1) == 1);
		assertTrue(grafo.obtenerCantidadVecinos(vertice2) == 1);
	}

	@Test
	void noSeAgreganVecinosDuplicadosConAristaInvertidaTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice2, vertice1);

		assertTrue(grafo.obtenerCantidadVecinos(vertice1) == 1);
		assertTrue(grafo.obtenerCantidadVecinos(vertice2) == 1);
	}

	@Test
	void eliminarVerticeTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);

		grafo.eliminarVertice(vertice1);

		assertTrue(grafo.tamanio() == 0);
	}

	@Test
	void eliminarVerticeDeListasDeVecinosTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		Vertice<Integer> vertice3 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice1, vertice3);

		grafo.eliminarVertice(vertice1);

		assertFalse(grafo.sonVecinos(vertice1, vertice2));
		assertFalse(grafo.sonVecinos(vertice1, vertice3));
	}

	@Test
	void grafoVacioNoEsConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		assertFalse(grafo.esConexo());
	}

	@Test
	void grafoDeUnVerticeEsConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);

		assertTrue(grafo.esConexo(vertice1));
	}

	@Test
	void grafoDeDosVerticesEsConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		grafo.agregarArista(vertice1, vertice2);

		assertTrue(grafo.esConexo(vertice1));
	}

	@Test
	void grafoConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

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

		assertTrue(grafo.esConexo(vertice1));
	}

	@Test
	void grafoCompletoEsConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

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
		grafo.agregarArista(vertice1, vertice4);
		grafo.agregarArista(vertice1, vertice5);
		grafo.agregarArista(vertice2, vertice3);
		grafo.agregarArista(vertice2, vertice4);
		grafo.agregarArista(vertice2, vertice5);
		grafo.agregarArista(vertice3, vertice4);
		grafo.agregarArista(vertice3, vertice5);
		grafo.agregarArista(vertice4, vertice5);

		assertTrue(grafo.esConexo(vertice1));
	}

	@Test
	void grafoDeDosVerticesNoVecinosNoEsConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		assertFalse(grafo.esConexo(vertice1));
	}

	@Test
	void grafoNoConexoTest() {
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

		assertFalse(grafo.esConexo(vertice1));
	}

	@Test
	void verticeSeAlcanzaASiMismoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);

		assertTrue(grafo.sonAlcanzablesEntreSi(vertice1, vertice1));
	}

	@Test
	void grafoDeDosVerticesQueSonAlcanzablesTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		grafo.agregarArista(vertice1, vertice2);

		assertTrue(grafo.esConexo(vertice1));
	}

	@Test
	void verticesSonAlcanzablesTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

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

		assertTrue(grafo.sonAlcanzablesEntreSi(vertice1, vertice5));
	}

	@Test
	void verticesSonAlcanzablesEnGrafoNoConexoTest() {
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

		assertTrue(grafo.sonAlcanzablesEntreSi(vertice1, vertice5));
	}

	@Test
	void grafoDeDosVerticesQueNoSonAlcanzablesTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);

		assertFalse(grafo.sonAlcanzablesEntreSi(vertice1, vertice2));
	}

	@Test
	void verticesNoSonAlcanzablesTest() {
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

		assertFalse(grafo.sonAlcanzablesEntreSi(vertice1, vertice7));
	}

	@Test
	void esArbolTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		Vertice<Integer> vertice3 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice2, vertice3);

		assertTrue(grafo.esArbol());
	}

	@Test
	void grafoDeUnVerticeArbolTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);

		assertTrue(grafo.esArbol());
	}

	@Test
	void noEsArbolPorTenerCiclosTest() {
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

		assertFalse(grafo.esArbol());
	}

	@Test
	void noEsArbolGrafoPorNoSerConexoTest() {
		Grafo<Integer> grafo = new Grafo<Integer>();

		Vertice<Integer> vertice1 = new Vertice<Integer>();
		Vertice<Integer> vertice2 = new Vertice<Integer>();
		Vertice<Integer> vertice3 = new Vertice<Integer>();
		Vertice<Integer> vertice4 = new Vertice<Integer>();

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);

		grafo.agregarArista(vertice1, vertice2);
		grafo.agregarArista(vertice3, vertice4);

		assertFalse(grafo.esArbol());
	}
}