package grafo;

import java.util.ArrayList;
import java.util.List;

public class Kruskal<T> {
	Grafo<T> grafoG;
	Grafo<T> agmT;
	UnionFind unionFind;

	public Kruskal(Grafo<T> grafoG) {
		this.grafoG = grafoG;

		this.agmT = new Grafo<>();

		this.unionFind = new UnionFind(this.grafoG);
	}

	public Grafo<T> obtenerAGM() {
		ArrayList<Arista<T>> aristasDeG = new ArrayList<Arista<T>>(grafoG.obtenerAristas());

		ArrayList<Arista<T>> aristasDeT = new ArrayList<Arista<T>>();

		int cantidadDeVerticesDeG = grafoG.tamanio();

		for (int i = 0; i < cantidadDeVerticesDeG - 1; i++) {
			Arista<T> aristaMinima = obtenerAristaMinimaQueNoFormeCiclo(aristasDeG);

			aristasDeT.add(aristaMinima);
			
			Vertice<T> verticeA = aristaMinima.getVerticeA();
			Vertice<T> verticeB = aristaMinima.getVerticeB();
			System.out.println("union");
			unionFind.union(verticeA, verticeB);
		}

		formarGrafoAPartirDeAristas(aristasDeT);

		return agmT;
	}

	private Arista<T> obtenerAristaMinimaQueNoFormeCiclo(ArrayList<Arista<T>> aristasDeG) {
		System.out.println("obtenerAristaMinimaQueNoFormeCiclo");
		Arista<T> aristaMinima = obtenerAristaMinima(aristasDeG);

		while (aristaFormaCiclo(aristaMinima)) {
			aristasDeG.remove(aristaMinima);
			aristaMinima = obtenerAristaMinima(aristasDeG);
		}

		return aristaMinima;
	}

	private boolean aristaFormaCiclo(Arista<T> aristaActual) {
		Vertice<T> verticeA = aristaActual.getVerticeA();
		Vertice<T> verticeB = aristaActual.getVerticeB();
		System.out.println("aristaFormaCiclo");
		boolean formaCiclo = unionFind.find(verticeA, verticeB);

		return formaCiclo;
	}

	private Arista<T> obtenerAristaMinima(ArrayList<Arista<T>> aristasDeG) {
		Arista<T> aristaMinima = aristasDeG.get(0);
		System.out.println("obtenerAristaMinima");
		int cargaAristaMinima = aristaMinima.getCarga();

		for (Arista<T> aristaActual : aristasDeG) {
			int cargaAristaActual = aristaActual.getCarga();

			if (cargaAristaActual < cargaAristaMinima) {
				aristaMinima = aristaActual;
				cargaAristaMinima = cargaAristaActual;
			}
		}

		return aristaMinima;
	}

	public void formarGrafoAPartirDeAristas(List<Arista<T>> aristas) {
		for (Arista<T> aristaActual : aristas) {
			Vertice<T> verticeA = aristaActual.getVerticeA();
			Vertice<T> verticeB = aristaActual.getVerticeB();
			
			agmT.agregarVertice(verticeA);
			agmT.agregarVertice(verticeB);
			
			agmT.agregarArista(aristaActual);
		}
	}
}
