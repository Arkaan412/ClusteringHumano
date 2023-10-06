package modelo;

import java.util.ArrayList;

public class AGM<T> {
	private Grafo<T> grafoG;
	private Grafo<T> agmT;
	
	public AGM(Grafo<T> grafo) {
		this.grafoG = grafo;
		this.agmT = new Grafo<>();
	}
	
	public Grafo<T> obtenerAGM(){
		ArrayList<Arista<T>> aristasDeG = new ArrayList<Arista<T>>(grafoG.obtenerAristas());

		ArrayList<Arista<T>> aristasDeT = new ArrayList<Arista<T>>();
		
		
		aristasDeT.add(aristasDeG.get(0));
		
		
//		agmT.formarGrafoAPartirDeAristas(aristasDeT.);
		
		return agmT;
	}
}
