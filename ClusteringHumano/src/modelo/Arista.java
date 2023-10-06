package modelo;

public class Arista<T> {
	private int carga;

	private Vertice<T> verticeA;
	private Vertice<T> verticeB;

	public Arista(Vertice<T> verticeA, Vertice<T> verticeB, int carga) {
		this.setVerticeA(verticeA);
		this.setVerticeB(verticeB);

		this.carga = carga;
	}

	public Arista(Vertice<T> verticeA, Vertice<T> verticeB) {
		this.setVerticeA(verticeA);
		this.setVerticeB(verticeB);
		
		this.carga = 0;
	}


	public int getCarga() {
		return carga;
	}

	public Vertice<T> getVerticeA() {
		return verticeA;
	}

	public Vertice<T> getVerticeB() {
		return verticeB;
	}

	public void setVerticeA(Vertice<T> verticeA) {
		this.verticeA = verticeA;
	}

	public void setVerticeB(Vertice<T> verticeB) {
		this.verticeB = verticeB;
	}
	
	public boolean perteneceAlVertice(Vertice<T> vertice) {
		return vertice == verticeA || vertice == verticeB;
	}
}
