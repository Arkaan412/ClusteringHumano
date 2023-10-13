package modelo;

import java.util.ArrayList;
import java.util.List;

public class InterpreteDeDatosDePersonas {

	public static List<Persona> generarPersonas(ArrayList<Object[]> datosDePersonas) {
		ArrayList<Persona> personas = new ArrayList<>();

		for (Object[] datosDePersona : datosDePersonas) {
			String nombre = (String) datosDePersona[0];

			int interesDeportes = (int) datosDePersona[1];
			int interesMusica = (int) datosDePersona[2];
			int interesEspectaculos = (int) datosDePersona[3];
			int interesCiencia = (int) datosDePersona[4];

			personas.add(new Persona(nombre, interesDeportes, interesMusica, interesEspectaculos, interesCiencia));
		}

		return personas;
	}
}
