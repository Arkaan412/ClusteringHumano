package grafo;

import java.util.ArrayList;
import java.util.List;

public class Prim<T> {
	Grafo<T> grafoG;
	Grafo<T> agmT;

	public Prim(Grafo<T> grafoG) {
		this.grafoG = grafoG;

		agmT = new Grafo<>();
	}

	public void generarAGM() {
		if (grafoG.estaVacio())
			throw new IllegalArgumentException("El grafo G no tiene vértices.");
		if (!grafoG.esConexo())
			throw new IllegalArgumentException("El grafo G no es conexo. El AGM T resultante no tendrá la misma cantidad de vértices que G.");
		
		List<Vertice<T>> verticesDeG = grafoG.obtenerVertices();
		agmT.agregarVertice(verticesDeG.get(0));

		System.out.println("Inicio");
		System.out.println(agmT.obtenerVertices());

		while (agmT.tamanio() < grafoG.tamanio()) {
			Arista<T> aristaMinima = obtenerAristaMinimaQueNoFormeCiclo();
			System.out.println(aristaMinima);

			Vertice<T> verticeA = aristaMinima.getVerticeA();
			Vertice<T> verticeB = aristaMinima.getVerticeB();
			agmT.agregarVertice(verticeA);
			agmT.agregarVertice(verticeB);

			agmT.agregarArista(aristaMinima);
			System.out.println(agmT.obtenerVertices());
		}

		System.out.println("RESULTADO");
		System.out.println(agmT.obtenerVertices());
		System.out.println(agmT.obtenerAristas());
	}

	public Grafo<T> obtenerAGM() {
		return agmT;
	}

	private Arista<T> obtenerAristaMinimaQueNoFormeCiclo() {
		List<Arista<T>> aristasDesdeGHaciaT = obtenerAristasDesdeGHaciaT();
//		System.out.println("cont");
//		System.out.println(aristasDesdeGHaciaT);

		Arista<T> aristaMinima = aristasDesdeGHaciaT.get(0);
		int cargaAristaMinima = aristaMinima.getCarga();

		for (Arista<T> aristaActual : aristasDesdeGHaciaT) {
			int cargaAristaActual = aristaActual.getCarga();

			if (aristaFormaCiclo(aristaMinima)) {
				aristaMinima = aristaActual;
			} else {
				if (!aristaFormaCiclo(aristaActual)) {
					if (cargaAristaActual <= cargaAristaMinima) {
						aristaMinima = aristaActual;
					}
				}
			}
		}

		return aristaMinima;
	}

	private List<Arista<T>> obtenerAristasDesdeGHaciaT() {
		List<Vertice<T>> verticesDeT = agmT.obtenerVertices();

		List<Arista<T>> aristasDesdeGHaciaT = new ArrayList<>();

		for (Vertice<T> verticeActual : verticesDeT) {
			List<Arista<T>> aristasDeVerticeActual = grafoG.obtenerAristasDeVertice(verticeActual);

			for (Arista<T> aristaActual : aristasDeVerticeActual) {
				boolean existeAristaEnT = agmT.existeArista(aristaActual);

				if (!existeAristaEnT) {
					aristasDesdeGHaciaT.add(aristaActual);
				}
			}
		}

		System.out.println("aristasDesdeGHaciaT");
		System.out.println(aristasDesdeGHaciaT);
		return aristasDesdeGHaciaT;
	}

	private boolean aristaFormaCiclo(Arista<T> arista) {
		Vertice<T> verticeA = arista.getVerticeA();
		Vertice<T> verticeB = arista.getVerticeB();

		return agmT.existeVertice(verticeA) && agmT.existeVertice(verticeB);
	}
}