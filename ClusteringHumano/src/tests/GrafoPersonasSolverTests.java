package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
		
		personas.add(new Persona("Juan", 0, 0, 0, 0));
		personas.add(new Persona("Bautista", 5, 5, 5, 5));
		personas.add(new Persona("María", 3, 3, 3, 3));
		personas.add(new Persona("Jose", 1, 1, 1, 1));
		
		grafo = GrafoPersonasSolver.generarGrafo(personas);
	}

	@Test
	void personasAgregadasCorrectamenteTest() {
		List<Vertice<Persona>> vertices = grafo.obtenerVertices();
		for (Vertice<Persona> verticeActual : vertices) {
			assertTrue(personas.contains(verticeActual.getCarga()));
		}
		
		assertEquals(grafo.tamanio(), personas.size());
	}
	
	@Test
	void grafoEsCompletoAlSerCreadoTest() {
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
	void indiceDeSimilaridadDeGustosIdenticosDaCeroTest() {
		Persona persona0 = new Persona("", 2, 5, 4, 1);
		Persona persona1 = new Persona("", 2, 5, 4, 1);
		
		int indiceDeSimilaridad = GrafoPersonasSolver.calcularIndiceDeSimilaridad(persona0, persona1);
		
		assertEquals(0, indiceDeSimilaridad);
	}
}
