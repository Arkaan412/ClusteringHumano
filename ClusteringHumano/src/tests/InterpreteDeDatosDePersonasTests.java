package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modelo.InterpreteDeDatosDePersonas;
import modelo.Persona;

class InterpreteDeDatosDePersonasTests {

	private static ArrayList<Object[]> datosDePersonas;

	@BeforeAll
	static void setUp() {
		datosDePersonas = new ArrayList<Object[]>();
	}

	@AfterEach
	void tearDown() {
		datosDePersonas = new ArrayList<Object[]>();
	}

	@Test
	void cantidadDeDatosMenorALaEsperada() {
		Object[] datosDePersonaInvalidos = { "Juan", 1, 2 };
		datosDePersonas.add(datosDePersonaInvalidos);
	
		assertThrows(ArrayIndexOutOfBoundsException.class,
				() -> InterpreteDeDatosDePersonas.generarPersonas(datosDePersonas));
	}

	@Test
	void nombreNoCorrespondeConSuTipoPredeterminadoTest() {
		Object[] datosDePersonaInvalidos = { 1, 1, 2, 3, 4 };
		datosDePersonas.add(datosDePersonaInvalidos);
		
		assertThrows(ClassCastException.class, () -> InterpreteDeDatosDePersonas.generarPersonas(datosDePersonas));
	}
	
	@Test
	void unoDeLosValoresNumericosNoCorrespondeConSuTipoPredeterminadoTest() {
		Object[] datosDePersonaInvalidos = { "Juan", "1", 2, 3, 4 };
		datosDePersonas.add(datosDePersonaInvalidos);
	
		assertThrows(ClassCastException.class, () -> InterpreteDeDatosDePersonas.generarPersonas(datosDePersonas));
	}

	@Test
	void nombreNuloSeReemplazanPorElStringNullTest() {
		Object[] datosDePersonaConNombreNulo = { null, 0, 0, 0, 0 };
		
		datosDePersonas.add(datosDePersonaConNombreNulo);
		
		List<Persona> resultado = InterpreteDeDatosDePersonas.generarPersonas(datosDePersonas);
		
		Persona personaResultado0 = resultado.get(0);
		
		assertEquals("null", personaResultado0.getNombre());
		assertEquals(0, personaResultado0.getInteresDeportes());
		assertEquals(0, personaResultado0.getInteresEspectaculos());
		assertEquals(0, personaResultado0.getInteresCiencia());
		assertEquals(0, personaResultado0.getInteresMusica());
	}
	
	@Test
	void valoresNumericosNulosSeReemplazanPorCeroTest() {
		Object[] datosDePersonaConValoresNumericosNulos = { "Juan", null, null, null, null };

		datosDePersonas.add(datosDePersonaConValoresNumericosNulos);

		List<Persona> resultado = InterpreteDeDatosDePersonas.generarPersonas(datosDePersonas);

		Persona personaResultado0 = resultado.get(0);

		assertEquals("Juan", personaResultado0.getNombre());
		assertEquals(0, personaResultado0.getInteresDeportes());
		assertEquals(0, personaResultado0.getInteresEspectaculos());
		assertEquals(0, personaResultado0.getInteresCiencia());
		assertEquals(0, personaResultado0.getInteresMusica());
	}

	@Test
	void generarPersonasTest() {
		Object[] datosDePersona0 = { "Juan", 1, 2, 3, 4 };
		
		datosDePersonas.add(datosDePersona0);

		List<Persona> resultado = InterpreteDeDatosDePersonas.generarPersonas(datosDePersonas);

		Persona personaResultado0 = resultado.get(0);

		assertEquals("Juan", personaResultado0.getNombre());
		assertEquals(1, personaResultado0.getInteresDeportes());
		assertEquals(2, personaResultado0.getInteresEspectaculos());
		assertEquals(3, personaResultado0.getInteresCiencia());
		assertEquals(4, personaResultado0.getInteresMusica());
	}

	@Test
	void generarPersonasConDatosPredeterminadosTest() {
		Object[] datosDePersonaPredeterminados = { "", 0, 0, 0, 0, };
		
		datosDePersonas.add(datosDePersonaPredeterminados);

		List<Persona> resultado = InterpreteDeDatosDePersonas.generarPersonas(datosDePersonas);

		Persona personaResultado0 = resultado.get(0);

		assertEquals("", personaResultado0.getNombre());
		assertEquals(0, personaResultado0.getInteresDeportes());
		assertEquals(0, personaResultado0.getInteresEspectaculos());
		assertEquals(0, personaResultado0.getInteresCiencia());
		assertEquals(0, personaResultado0.getInteresMusica());
	}
}
