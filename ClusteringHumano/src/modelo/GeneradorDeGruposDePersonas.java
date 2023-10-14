package modelo;

import java.util.ArrayList;
import java.util.List;

import grafo.BFS;
import grafo.Grafo;
import grafo.Prim;
import grafo.Vertice;

public class GeneradorDeGruposDePersonas {
	private ArrayList<String> grupoA;
	private ArrayList<String> grupoB;

	private Grafo<Persona> grafo;
	
	private Grafo<Persona> agm;

	public GeneradorDeGruposDePersonas(ArrayList<Object[]> datosDePersonas) {
		grupoA = new ArrayList<>();
		grupoB = new ArrayList<>();

		generarGrafo(datosDePersonas);

		generarAGM();

		GrafoPersonasSolver.eliminarAristaDeMayorPeso(agm);

		obtenerGruposDelGrafo();
	}

	private void generarGrafo(ArrayList<Object[]> datosDePersonas) {
		List<Persona> personas = InterpreteDeDatosDePersonas.generarPersonas(datosDePersonas);

		grafo = GrafoPersonasSolver.generarGrafo(personas);
		
//		ArrayList<Vertice<Persona>> vertices = new ArrayList<>(grafo.obtenerVertices());
//
//		for (int i = 0; i < vertices.size(); i++) {
//			Vertice<Persona> verticeActual = vertices.get(i);
//
//			System.out.println(verticeActual);
//		}
	}

	private void generarAGM() {
		Prim<Persona> prim = new Prim<>(grafo);

		prim.generarAGM();

		agm = prim.obtenerAGM();
	}

	private void obtenerGruposDelGrafo() {
		List<Vertice<Persona>> vertices = grafo.obtenerVertices();

		int indiceVerticeInicial = 0;

//		System.out.println(grafo.obtenerVertices());
		List<Vertice<Persona>> grupoA = BFS.bfs(grafo, vertices.get(indiceVerticeInicial));

		for (int i = 0; i < vertices.size(); i++) {
			Vertice<Persona> verticeActual = vertices.get(i);

			boolean estaEnElGrupoA = vertices.contains(verticeActual);

			if (!estaEnElGrupoA) {
				indiceVerticeInicial = i;
				break;
			}
		}

		List<Vertice<Persona>> grupoB = BFS.bfs(grafo, vertices.get(indiceVerticeInicial));

		generarGrupos(grupoA, grupoB);
	}

	private void generarGrupos(List<Vertice<Persona>> grupoA, List<Vertice<Persona>> grupoB) {
		for (Vertice<Persona> verticeActual : grupoA) {
			Persona personaDeVerticeActual = verticeActual.getCarga();
			String nombreDePersonaActual = personaDeVerticeActual.getNombre();

			this.grupoA.add(nombreDePersonaActual);
		}

		for (Vertice<Persona> verticeActual : grupoB) {
			Persona personaDeVerticeActual = verticeActual.getCarga();
			String nombreDePersonaActual = personaDeVerticeActual.getNombre();

			this.grupoB.add(nombreDePersonaActual);
		}
	}

	public List<String> obtenerGrupoA() {
		return grupoA;
	}

	public List<String> obtenerGrupoB() {
		return grupoB;
	}

}