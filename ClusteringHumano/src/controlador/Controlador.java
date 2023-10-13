package controlador;

import java.util.ArrayList;

import modelo.GeneradorDeGruposDePersonas;

public class Controlador {
	public static GeneradorDeGruposDePersonas generarGruposDePersonas(ArrayList<Object[]> datosDePersonas) {
		return new GeneradorDeGruposDePersonas(datosDePersonas);
	}
}
