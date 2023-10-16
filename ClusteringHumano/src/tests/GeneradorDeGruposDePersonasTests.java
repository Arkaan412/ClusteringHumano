package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modelo.GeneradorDeGruposDePersonas;

class GeneradorDeGruposDePersonasTests {

	private static ArrayList<Object[]> datosDePersonas;
	private static GeneradorDeGruposDePersonas generador;

	@BeforeAll
	static void setUp() {
		datosDePersonas = new ArrayList<Object[]>();

		Object[] datosDePersona0 = { "Juan", 1, 5, 4, 5 };
		Object[] datosDePersona1 = { "Bautista", 2, 3, 5, 5 };
		Object[] datosDePersona2 = { "María", 2, 0, 3, 0 };
		Object[] datosDePersona3 = { "José", 2, 0, 3, 1 };

		datosDePersonas.add(datosDePersona0);
		datosDePersonas.add(datosDePersona1);
		datosDePersonas.add(datosDePersona2);
		datosDePersonas.add(datosDePersona3);

		generador = new GeneradorDeGruposDePersonas(datosDePersonas);
	}

	@AfterEach
	void tearDown() {
		datosDePersonas = new ArrayList<Object[]>();
	}

	@Test
	void gruposGeneradosCorrectamente() {
		List<String> grupoA = generador.obtenerGrupoA();
		List<String> grupoB = generador.obtenerGrupoB();

		boolean existeJose = false;
		boolean existeMaria = false;
		boolean existeJuan = false;
		boolean existeBautista = false;

		for (String nombreActual : grupoA) {
			if (nombreActual.equals("María")) {
				existeMaria = true;
			} else if (nombreActual.equals("José")) {
				existeJose = true;
			}
		}

		for (String nombreActual : grupoB) {
			if (nombreActual.equals("Juan")) {
				existeJuan = true;
			}
			if (nombreActual.equals("Bautista")) {
				existeBautista = true;
			}
		}

		boolean grupoACorrecto = existeJose && existeMaria;
		boolean grupoBCorrecto = existeJuan && existeBautista;

		assertTrue(grupoACorrecto);
		assertTrue(grupoBCorrecto);
	}
}