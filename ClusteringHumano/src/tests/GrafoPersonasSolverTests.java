package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;
import modelo.GrafoPersonasSolver;
import modelo.Persona;

class GrafoPersonasSolverTests {

	private static List<Persona> personas;
	private static Grafo<Persona> grafo;

	@BeforeAll
	static void setUp() {
		personas = new ArrayList<Persona>();
	}

	@AfterEach
	void tearDown() {
		personas = new ArrayList<Persona>();
	}

	@Test
	void personasAgregadasCorrectamenteTest() {
		personas.add(new Persona("Juan", 0, 0, 0, 0));
		personas.add(new Persona("Bautista", 0, 0, 0, 0));
		personas.add(new Persona("María", 0, 0, 0, 0));
		personas.add(new Persona("Jose", 0, 0, 0, 0));

		grafo = GrafoPersonasSolver.generarGrafo(personas);

		List<Vertice<Persona>> vertices = grafo.obtenerVertices();

		for (Vertice<Persona> verticeActual : vertices) {
			assertTrue(personas.contains(verticeActual.getCarga()));
		}

		assertEquals(grafo.tamanio(), personas.size());
	}

	@Test
	void grafoEsCompletoAlSerCreadoTest() {
		personas.add(new Persona("Juan", 0, 0, 0, 0));
		personas.add(new Persona("Bautista", 0, 0, 0, 0));
		personas.add(new Persona("María", 0, 0, 0, 0));
		personas.add(new Persona("Jose", 0, 0, 0, 0));

		grafo = GrafoPersonasSolver.generarGrafo(personas);

		assertTrue(grafo.esCompleto());
	}

	@Test
	void calcularIndiceDeSimilaridadTest() {
		Persona persona0 = new Persona("", 1, 5, 4, 5);
		Persona persona1 = new Persona("", 2, 3, 5, 5);

		int indiceDeSimilaridad = GrafoPersonasSolver.calcularIndiceDeSimilaridad(persona0, persona1);

		assertEquals(4, indiceDeSimilaridad);
	}

	@Test
	void indiceDeSimilaridadDeInteresesIdenticosDaCeroTest() {
		Persona persona0 = new Persona("", 2, 5, 4, 1);
		Persona persona1 = new Persona("", 2, 5, 4, 1);

		int indiceDeSimilaridad = GrafoPersonasSolver.calcularIndiceDeSimilaridad(persona0, persona1);

		assertEquals(0, indiceDeSimilaridad);
	}

	@Test
	void eliminarAristaDeMayorPesoTest() {
		Persona persona0 = new Persona("Juan", 1, 5, 4, 5);
		Persona persona1 = new Persona("Bautista", 2, 3, 5, 5);
		Persona persona2 = new Persona("María", 2, 0, 3, 0);
		Persona persona3 = new Persona("Jose", 2, 0, 3, 1);

		personas.add(persona0);
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);

		grafo = GrafoPersonasSolver.generarGrafo(personas);

		List<Arista<Persona>> aristasObtenidas = grafo.obtenerAristas();

		int cargaDeAristaDeMayorPesoEsperada = 12;

		Arista<Persona> aristaMaxima = null;

		for (Arista<Persona> aristaActual : aristasObtenidas) {
			if (aristaActual.getCarga() == cargaDeAristaDeMayorPesoEsperada) {
				aristaMaxima = aristaActual;
			}
		}

		GrafoPersonasSolver.eliminarAristaDeMayorPeso(grafo);

		assertFalse(grafo.existeArista(aristaMaxima));
	}
}