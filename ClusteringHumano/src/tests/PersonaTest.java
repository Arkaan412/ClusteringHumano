package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Persona;
import modelo.Vertice;

class PersonaTest {
//	Persona a;
//	Persona b;
//	Persona c;
//	Persona d;
//
//	@BeforeEach
//	public void inicializar() {
//		a = new Persona();
//		b = new Persona();
//		c = new Persona("Juan", 1, 2, 3, 4);
//		d = new Persona("Lola", 4, 3, 2, 1);
//	}

	@Test
	public void sinVecinosTest() {
		Persona a = new Persona();
		
		assertEquals(0, a.obtenerCantidadDeVecinos());
	}

	@Test
	public void agregarVecinoTest() {
		Persona a = new Persona();
		Persona b = new Persona();
		
		a.agregarVecino(b);
		
		assertTrue(a.esVecinoDe(b));
		assertTrue(b.esVecinoDe(a));
	}

	@Test
	public void noSeAgregaVecinoDuplicadoTest() {
		Persona a = new Persona();
		Persona b = new Persona();
		
		a.agregarVecino(b);
		a.agregarVecino(b);
		
		assertEquals(1, a.obtenerCantidadDeVecinos());
	}
	
	@Test
	public void equalsTest() {
		Persona a = new Persona();
		Persona b = new Persona();
		
		a.agregarVecino(b);
		
		assertTrue(a.equals(b));
	}
}
