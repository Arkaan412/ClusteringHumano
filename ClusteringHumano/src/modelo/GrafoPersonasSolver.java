package modelo;

import java.util.List;

import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;

public class GrafoPersonasSolver {
	public static Grafo<Persona> generarGrafo(List<Persona> personas) {
		Grafo<Persona> grafo = new Grafo<>();

		agregarPersonasAlGrafo(grafo, personas);

		convertirAGrafoCompleto(grafo);

		return grafo;
	}

	private static void agregarPersonasAlGrafo(Grafo<Persona> grafo, List<Persona> personas) {
		for (Persona personaActual : personas) {
			Vertice<Persona> nuevoVertice = new Vertice<>(personaActual);

			grafo.agregarVertice(nuevoVertice);
		}
	}

	private static void convertirAGrafoCompleto(Grafo<Persona> grafo) {
		List<Vertice<Persona>> vertices = grafo.obtenerVertices();

		for (Vertice<Persona> verticeActual : vertices) {
			for (Vertice<Persona> vecinoAAgregar : vertices) {
				boolean aristaEsValida = !grafo.sonElMismoVertice(verticeActual, vecinoAAgregar)
						&& !grafo.sonVecinos(verticeActual, vecinoAAgregar);

				if (aristaEsValida) {
					Persona personaA = verticeActual.getCarga();
					Persona personaB = vecinoAAgregar.getCarga();

					int indiceDeSimilaridad = calcularIndiceDeSimilaridad(personaA, personaB);

					grafo.agregarArista(verticeActual, vecinoAAgregar, indiceDeSimilaridad);
				}
			}
		}
	}

	public static int calcularIndiceDeSimilaridad(Persona personaA, Persona personaB) {
		int interesDeportesDeA = personaA.getInteresDeportes();
		int interesEspectaculosDeA = personaA.getInteresEspectaculos();
		int interesCienciaDeA = personaA.getInteresCiencia();
		int interesMusicaDeA = personaA.getInteresMusica();

		int interesDeportesDeB = personaB.getInteresDeportes();
		int interesEspectaculosDeB = personaB.getInteresEspectaculos();
		int interesCienciaDeB = personaB.getInteresCiencia();
		int interesMusicaDeB = personaB.getInteresMusica();

		int indiceDeSimilaridad = Math.abs(interesDeportesDeA - interesDeportesDeB)
				+ Math.abs(interesEspectaculosDeA - interesEspectaculosDeB)
				+ Math.abs(interesCienciaDeA - interesCienciaDeB)
				+ Math.abs(interesMusicaDeA - interesMusicaDeB);

		return indiceDeSimilaridad;
	}

	public static void eliminarAristaDeMayorPeso(Grafo<Persona> grafo) {
		Arista<Persona> aristaDeMayorPeso = obtenerAristaDeMayorPeso(grafo);

		grafo.eliminarArista(aristaDeMayorPeso);
	}

	private static Arista<Persona> obtenerAristaDeMayorPeso(Grafo<Persona> grafo) {
		List<Arista<Persona>> aristas = grafo.obtenerAristas();

		Arista<Persona> aristaDeMayorPeso = aristas.get(0);

		for (Arista<Persona> aristaActual : aristas) {
			int pesoAristaMayor = aristaDeMayorPeso.getCarga();
			int pesoAristaActual = aristaActual.getCarga();

			if (pesoAristaActual > pesoAristaMayor) {
				aristaDeMayorPeso = aristaActual;
			}
		}

		return aristaDeMayorPeso;
	}
}