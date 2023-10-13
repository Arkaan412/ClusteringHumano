package modelo;

import java.util.List;

import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;

public class GrafoPersonasSolver {
	public static Grafo<Persona> generarGrafo(List<Persona> personas) {
		Grafo<Persona> grafo = new Grafo<>();

		agregarPersonasAlGrafo(grafo, personas);

		grafo.convertirAGrafoCompleto();

		return grafo;
	}

	private static void agregarPersonasAlGrafo(Grafo<Persona> grafo, List<Persona> personas) {
		for (Persona personaActual : personas) {
			Vertice<Persona> nuevoVertice = new Vertice<>(personaActual);

			grafo.agregarVertice(nuevoVertice);
		}
	}

	public static void eliminarAristaDeMayorPeso(Grafo<Persona> grafo) {
		Arista<Persona> aristaDeMayorPeso = obtenerAristaDeMayorPeso(grafo);

		grafo.eliminarArista(aristaDeMayorPeso);
	}

	private static Arista<Persona> obtenerAristaDeMayorPeso(Grafo<Persona> grafo) {
		List<Arista<Persona>> aristas = grafo.obtenerAristas();

		Arista<Persona> aristaDeMayorPeso = aristas.get(0);

		int pesoAristaMayor = aristaDeMayorPeso.getCarga();

		for (Arista<Persona> aristaActual : aristas) {
			int pesoAristaActual = aristaActual.getCarga();

			if (pesoAristaActual > pesoAristaMayor)
				aristaDeMayorPeso = aristaActual;
		}

		return aristaDeMayorPeso;
	}
}